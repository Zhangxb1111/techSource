package com.itheima.domain;

import java.util.Date;

/**
 * 声明pojo对象时，属性的类型使用包装类型
 *     因为基本数据类型本身代表某状态
 */
public class User {

    private Integer id;
    private String username;
    private String address;
    private Date birthday;
    private String sex;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
