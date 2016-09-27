package com.insurance.polismart.web;

import com.insurance.polismart.service.InsuranceCompanyService;
import com.insurance.polismart.web.usercontroller.AbstractUserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Admin on 31.07.2016.
 */
@Controller
public class RootController extends AbstractUserController{

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String root(){
        return "redirect:insurance";
    }

    @RequestMapping(value = "/insurance", method = RequestMethod.GET)
    public String insuranceCompanyList(){
        return "insuranceCompanyList";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String userList(){
        return "userList";
    }
}
