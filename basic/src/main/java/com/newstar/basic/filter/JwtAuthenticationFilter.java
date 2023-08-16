package com.newstar.basic.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.newstar.basic.provider.JwtProvider;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
// description : 해당 클래스를 필터로 만들기 위해 OncePerRequestFilter 추상 클래스를 확장 //
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    
    private final JwtProvider jwtProvider;

    // description : OncePerRequestFilter 추상클래스의 추상메서드 구현 //
    // description : 필터가 실제로 수행할 작업 구현 //
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
                
                try {

                    // description : 전달받은 request 객체에서 JWT 추출 //
                    String token = parseBearerToken(request);
                    if(token == null) {
                        filterChain.doFilter(request, response);
                        return;
                    }

                    // description : token 검증 //
                    String subject = jwtProvider.validate(token);
                    if(subject == null) {
                        filterChain.doFilter(request, response);
                        return;
                    }

                    AbstractAuthenticationToken authenticationToken = 
                        new UsernamePasswordAuthenticationToken(subject, null, AuthorityUtils.NO_AUTHORITIES);
                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                    SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
                    securityContext.setAuthentication(authenticationToken);

                    SecurityContextHolder.setContext(securityContext);

                } catch (Exception exception) {
                    exception.printStackTrace();
                }

                filterChain.doFilter(request, response);
            }

    // description : request 객체의 헤더에서 jwt 추출하는 메서드 //
    private String parseBearerToken(HttpServletRequest request) {

        // description : request header에 있는 Authorization 값을 추출 //
        String authorization = request.getHeader("Authorization");

        // description : Authorization 키와 값이 존재하는지 검증 //
        boolean hasAuthorization = StringUtils.hasText(authorization);
        if(!hasAuthorization) return null;

        // description : Authorization 값이 Bearer Token 인지 검증 //
        boolean isBearer = authorization.startsWith("Bearer ");
        if(!isBearer) return null;

        // description : Authorization 값에서 'Bearer '를 제외한 토큰 값 추출 //
        String token = authorization.substring(7);
        return token;

    } 

}
