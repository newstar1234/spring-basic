package com.newstar.basic.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

// description : Entity 클래스 - 데이터베이스 테이블과 매핑되는 Spring의 클래스 //
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
// description : @Entity - 해당 클래스를 Entity 클래스로 지정하는 어노테이션 //
@Entity(name="user")
// description : @Table - 데이터베이스의 테이블과 매핑시켜주는 어노테이션 //
// description : 클래스명과 데이터베이스명이 다를 때 name을 지정하여 직접 매핑 할 수 있음
@Table(name="user")
public class UserEntity {
    // description : @Id - 테이블의 기본키에 매핑되는 멤버변수를 지정해주는 어노테이션 //
    @Id
    private String email;
    private String password;
    private String nickname;
    private String telNumber;
    private String address;
    private String addressDetail;
    private String profileImageUrl;
}
