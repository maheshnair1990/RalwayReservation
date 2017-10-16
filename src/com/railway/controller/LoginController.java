/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.railway.controller;

import com.railway.dbmodel.LoginDbModel;
import com.railway.uimodel.LoginUiModel;
import com.railway.uimodel.RegistrationUiModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Mahesh Nair
 */
@Controller
public class LoginController {

    @Autowired
    LoginDbModel loginDbModel;

    @RequestMapping(value = "/")
    public ModelAndView getLogin() {
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject(new LoginUiModel());
        return modelAndView;
    }

    @RequestMapping(value = "/login/doLogin", method = RequestMethod.POST)
    public String doLogin(@ModelAttribute("loginUiModel") LoginUiModel loginUiModel) {

//        LoginDbModel loginDbModel = new LoginDbModel();
        boolean loginFlag = loginDbModel.getUser(loginUiModel.getUserName(), loginUiModel.getPassword());
        if (loginFlag) {
            return "welcome";
        } else {
            return "";
        }
    }

    @RequestMapping(value = "/login/register", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute("registerUiModel") RegistrationUiModel registerUiModel) {
        return "";
    }
}
