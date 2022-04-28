package com.example.module02mvcscopes.controller;

import com.example.module02mvcscopes.beans.ApplicationScopeBean;
import com.example.module02mvcscopes.beans.RequestScopeBean;
import com.example.module02mvcscopes.beans.SessionScopeBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

@Controller
public class IndexController {

    @Autowired
    private RequestScopeBean requestScopeBean;

    @Autowired
    private SessionScopeBean sessionScopeBean;

    @Autowired
    private ApplicationScopeBean applicationScopeBean;

    @RequestMapping(value = "/", method = {RequestMethod.POST, RequestMethod.GET})
    public String index(Model model) {
        model.addAttribute("requestScopeValue", requestScopeBean.getValue());
        model.addAttribute("sessionScopeValue", sessionScopeBean.getValue());
        model.addAttribute("applicationScopeValue", applicationScopeBean.getValue());
        return "/index";
    }

    @PostMapping("/save-request-value")
    public String saveRequestScopeValue(@RequestParam int requestValue) {
        this.requestScopeBean.setValue(requestValue);

        return "forward:/";
    }

    @PostMapping("/save-session-value")
    public String saveSessionScopeValue(@RequestParam int sessionValue) {
        this.sessionScopeBean.setValue(sessionValue);

        return "redirect:/";
    }

    @PostMapping("/save-application-value")
    public String saveApplicationScopeValue(@RequestParam int applicationValue) {
        this.applicationScopeBean.setValue(applicationValue);

        return "redirect:/";
    }


}
