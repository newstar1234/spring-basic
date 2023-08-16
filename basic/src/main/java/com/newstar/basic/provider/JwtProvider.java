package com.newstar.basic.provider;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

// description : JWT 생성 및 검증을 위한 컴포넌트 //
// description : @Component - Spring Bean으로 등록하여 Spring에게 의존성 주입을 제어할 수 있도록 함 //
@Component
public class JwtProvider {

    // description : JWT 생성 메서드 //
    public String create(String sub) {

        // description : 현재 시간 + 1시간의 JWT 만료 날짜 생성 //
        Date expiredDate = Date.from(Instant.now().plus(1, ChronoUnit.HOURS));

        String jwt = Jwts.builder()
                    // description : JWT 암호화 알고리즘 및 비밀키 지정 //
                    .signWith(SignatureAlgorithm.HS256, "security")
                    // description : JWT payload의 sub 키에 들어갈 값을 지정 //
                    .setSubject(sub)
                    // description : JWT가 생성된 날짜 및 시간 //
                    .setIssuedAt(new Date())
                    // description : JWT 만료 날짜 및 시간 //
                    .setExpiration(expiredDate)
                    // description : 지정한 데이터로 암호화 (JWT 생성) //
                    .compact();
        return jwt;
    }

    // description : JWT 검증 메서드 //
    public String validate(String jwt) {

        Claims payload = null;

        try {
            payload = Jwts.parser()
                    // description : JWT 해석에 사용할 비밀키 지정 //
                    .setSigningKey("security")
                    // description : 해석할 JWT 지정 //
                    .parseClaimsJws(jwt)
                    // description : payload 불러오기 //
                    .getBody();
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
        // description : 검증 완료시  payload에 있는 sub 값 반환 //
        return payload.getSubject();        
    }

}
