/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.railway.dbmodel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Mahesh Nair
 */
public class LoginDbModel {

//    @Autowired
    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public boolean getUser(String user, String password) {
        String sql = "select count(*) from login where user='" + user + "' and password= '" + password+"'";
        int count = 0;
        try {
            count = template.queryForInt(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }
        boolean loginFlag = false;
        if (count == 1) {
            loginFlag = true;
        }

        return loginFlag;

    }
}
