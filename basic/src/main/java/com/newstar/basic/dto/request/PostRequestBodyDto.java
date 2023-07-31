package com.newstar.basic.dto.request;

public class PostRequestBodyDto {
    private String name;
    private int age;

    public PostRequestBodyDto() {}

    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }

}
