/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.railway.controller;

import com.railway.dbmodel.LoginDbModel;
import com.railway.helpers.Response;
import com.railway.helpers.User;
import com.railway.uimodel.BookTicketUiModel;
import com.railway.uimodel.LoginUiModel;
import com.railway.uimodel.RegistrationUiModel;
import com.railway.uimodel.TrainUiModel;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
        modelAndView.addObject("loginUiModel", new LoginUiModel());
        modelAndView.addObject("registerUiModel", new RegistrationUiModel());
        return modelAndView;
    }

    @RequestMapping(value = "/login/doLogin", method = RequestMethod.POST)
    public String doLogin(HttpSession session, @ModelAttribute("loginUiModel") LoginUiModel loginUiModel, Model model) {

//        LoginDbModel loginDbModel = new LoginDbModel();
        boolean loginFlag = loginDbModel.getUser(loginUiModel.getUserName(), loginUiModel.getPassword());
        User user = new User();

        if (loginFlag) {
            model.addAttribute("bookTicket", new BookTicketUiModel());
            user.setUser(loginUiModel.getUserName());
            session.setAttribute("userSession", user);
            return "welcome";
        } else {
            return "";
        }
    }

    @RequestMapping(value = "/login/register/user", method = RequestMethod.POST)
    public @ResponseBody
    Response registerUser(Model model, @ModelAttribute("registerUiModel") RegistrationUiModel registerUiModel) {
        int count = loginDbModel.insertUser(registerUiModel);

        if (count == 1) {
            model.addAttribute("loginUiModel", new LoginUiModel());
            model.addAttribute("registerUiModel", new RegistrationUiModel());
            return new Response(Response.SUCCESS_CODE, "", "You have Successfully registered.Please login using your credentials");

        } else {
            model.addAttribute("loginUiModel", new LoginUiModel());
            model.addAttribute("registerUiModel", new RegistrationUiModel());
            return new Response(Response.FAIL_CODE, "", "Registration Failed.Please try with different user name!!!");
        }

    }

    @RequestMapping(value = "/login/ticket/check", method = RequestMethod.POST)
    public ModelAndView
            checkAvailiability(Model model, @ModelAttribute("bookTicketUiModel") BookTicketUiModel bookTicketUiModel) {
        List<TrainUiModel> list = loginDbModel.getTrain(bookTicketUiModel.getFromStation());
        int count = list.size();
        model.addAttribute("bookTicket", new BookTicketUiModel());

        model.addAttribute("list", list);
        return new ModelAndView("welcome");

    }

}
