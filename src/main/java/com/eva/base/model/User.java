package com.eva.base.model;

import com.eva.base.model.base.BaseModel;

/**
 * Created by Jamin.Ma on 2017/5/20.
 */
public class User  extends BaseModel {

    private String name;

    private String pass;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
