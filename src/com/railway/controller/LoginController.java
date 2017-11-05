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
import com.railway.uimodel.CancelTicketUiModel;
import com.railway.uimodel.LoginUiModel;
import com.railway.uimodel.RegistrationUiModel;
import com.railway.uimodel.TrainAdminUiModel;
import com.railway.uimodel.TrainUiModel;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
        String userAdmin = loginUiModel.getUserName();
        User user = new User();

        if (loginFlag) {
            model.addAttribute("bookTicket", new BookTicketUiModel());
            user.setUser(loginUiModel.getUserName());
            session.setAttribute("userSession", user);
            if (userAdmin.equals("admin")) {
                List<TrainUiModel> list = loginDbModel.getAllTrain();
                model.addAttribute("list", list);
                model.addAttribute("trainAdminUiModel", new TrainAdminUiModel());
                model.addAttribute("message", "");

                return "welcomeAdmin";
            } else {
                return "welcome";

            }
        } else {
            model.addAttribute("errorMessage", "Incorrect username and password");
            model.addAttribute("loginUiModel", new LoginUiModel());
            model.addAttribute("registerUiModel", new RegistrationUiModel());
            return "login";
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

    @RequestMapping(value = "/login/ticket/show/{trainNo}", method = RequestMethod.GET)
    public String showTicket(@PathVariable String trainNo, Model model) {
        model.addAttribute("bookTicket", new BookTicketUiModel());
        model.addAttribute("trainNo", trainNo);
        return "BookTicket";
    }

    @RequestMapping(value = "/login/ticket/book/{trainNo}", method = RequestMethod.POST)
    public String bookTicket(HttpSession session, @PathVariable String trainNo, @ModelAttribute("bookTicket") BookTicketUiModel bookTicket, Model model) {
        String userId = ((User) session.getAttribute("userSession")).getUser();
        bookTicket.setLoggedUser(userId);
        int count = loginDbModel.insertCustomerInfo(bookTicket, trainNo);
        String message = "";
        if (count == 0) {
            message = "Your ticket is not booked. Please try Again!!";

        } else {
            message = "Your ticket is booked Successfully!!! Your Pnr Status is " + count;

        }
        model.addAttribute("message", message);
        return "result";
    }

    @RequestMapping(value = "/login/home", method = RequestMethod.GET)
    public String getHomePage(HttpSession session, Model model) {
        String userId = ((User) session.getAttribute("userSession")).getUser();

        if (userId.equals("admin")) {
            List<TrainUiModel> list = loginDbModel.getAllTrain();
            model.addAttribute("list", list);
            model.addAttribute("trainAdminUiModel", new TrainAdminUiModel());
            model.addAttribute("message", "");

            return "welcomeAdmin";
        } else {
            model.addAttribute("bookTicket", new BookTicketUiModel());
            return "welcome";
        }

    }

    @RequestMapping(value = "/login/ticket/cancel", method = RequestMethod.GET)
    public String showCancelTicket(HttpSession session, Model model) {

        model.addAttribute("cancelTicket", new CancelTicketUiModel());
        return "TicketStatus";
    }

    @RequestMapping(value = "/login/ticket/cancel/{trainNo}/{custId}/{ticketBooked}", method = RequestMethod.GET)
    public String cancelTicket(HttpSession session, Model model, @PathVariable String trainNo, @PathVariable String custId, @PathVariable String ticketBooked) {

        int count = loginDbModel.cancelBooking(custId, trainNo, ticketBooked);
        if (count == 1) {
            model.addAttribute("message", "Ticket has been cancelled");
        } else {
            model.addAttribute("message", "Please try again !!!");
        }
        return "result";
    }

    @RequestMapping(value = "/login/ticket/pnr/check", method = RequestMethod.POST)
    public String checkPnr(HttpSession session, @ModelAttribute("cancelTicket") CancelTicketUiModel cancelTicket, Model model) {
        List<CancelTicketUiModel> list = loginDbModel.getPnrList(cancelTicket.getPnr());
        model.addAttribute("cancelTicket", new CancelTicketUiModel());
        model.addAttribute("list", list);

        return "TicketStatus";
    }

    @RequestMapping(value = "/login/train/add", method = RequestMethod.POST)
    public String addTrain(Model model, @ModelAttribute("trainAdminUiModel") TrainAdminUiModel trainAdminUiModel) {
        int count = loginDbModel.insertTrain(trainAdminUiModel);

        if (count == 1) {
            List<TrainUiModel> list = loginDbModel.getAllTrain();
            model.addAttribute("list", list);
            model.addAttribute("message", "Train Successfully Added");
            model.addAttribute("trainAdminUiModel", new TrainAdminUiModel());

            return "welcomeAdmin";
        } else {
            List<TrainUiModel> list = loginDbModel.getAllTrain();
            model.addAttribute("list", list);
            model.addAttribute("message", "Error in Adding Train");
            model.addAttribute("trainAdminUiModel", new TrainAdminUiModel());

            return "welcomeAdmin";
        }

    }

    @RequestMapping(value = "/login/train/edit/get/{trainNo}", method = RequestMethod.GET)
    public String getEditTrain(Model model, @PathVariable String trainNo) {
        TrainAdminUiModel trainAdminUiModel = loginDbModel.getTrainById(trainNo);
        model.addAttribute("trainAdminUiModel", trainAdminUiModel);
        return "editTrain";

    }

    @RequestMapping(value = "/login/train/delete/{trainNo}", method = RequestMethod.GET)
    public String deleteTrain(Model model, @PathVariable String trainNo) {
        int count = loginDbModel.deleteTrain(trainNo);

        if (count == 1) {
            List<TrainUiModel> list = loginDbModel.getAllTrain();
            model.addAttribute("list", list);
            model.addAttribute("message", "Train Successfully Deleted");
            model.addAttribute("trainAdminUiModel", new TrainAdminUiModel());

            return "welcomeAdmin";
        } else {
            List<TrainUiModel> list = loginDbModel.getAllTrain();
            model.addAttribute("list", list);
            model.addAttribute("message", "Error in Deleting Train");
            model.addAttribute("trainAdminUiModel", new TrainAdminUiModel());

            return "welcomeAdmin";
        }

    }

    @RequestMapping(value = "/login/train/edit", method = RequestMethod.POST)
    public String editTrain(Model model, @ModelAttribute("trainAdminUiModel") TrainAdminUiModel trainAdminUiModel) {
        int count = loginDbModel.updateTrain(trainAdminUiModel);

        if (count == 1) {
            List<TrainUiModel> list = loginDbModel.getAllTrain();
            model.addAttribute("list", list);
            model.addAttribute("message", "Train Successfully Updated");
            model.addAttribute("trainAdminUiModel", new TrainAdminUiModel());

            return "welcomeAdmin";
        } else {
            List<TrainUiModel> list = loginDbModel.getAllTrain();
            model.addAttribute("list", list);
            model.addAttribute("message", "Error in Updating Train");
            model.addAttribute("trainAdminUiModel", new TrainAdminUiModel());

            return "welcomeAdmin";
        }

    }

}
