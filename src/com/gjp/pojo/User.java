package com.gjp.pojo;

import java.io.Serializable;

/**
 * Created by acer on 2017/7/15.
 */
public class User implements Serializable {
    private String id;
    private String username;
    private String sex;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

}
