package com.newstar.basic.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostRequestBodyDto {
    @NotBlank
    private String name;
    @NotNull
    private Integer age; //  기본형 데이터타입은 null을 받을수없다. / 참조형 데이터타입은 null을 받을수있다.
}
