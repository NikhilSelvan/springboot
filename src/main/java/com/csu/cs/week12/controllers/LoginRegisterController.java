package com.csu.cs.week12.controllers;

import com.csu.cs.week12.Week12Application;
import com.csu.cs.week12.forms.LoginForm;
import com.csu.cs.week12.models.UserInfo;
import com.csu.cs.week12.models.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Properties;

@Controller
//@RequestMapping(path = "api/v1/login/")
public class LoginRegisterController {

    private final UserService userService;

    @Autowired
    public LoginRegisterController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "action_login", params = "login")
    public String login(@RequestParam Map<String, String> params) {
        String phoneNumber = null, password = null;
        for (String key : params.keySet()) {
            if (key.equals("phoneNumber")) {
                phoneNumber = params.get(key);
            } else if (key.equals("password")) {
                password = params.get(key);
            }

            System.out.println("key: " + key + " value: " + params.get(key) );
        }
        if (phoneNumber != null && password != null) {
            UserInfo userInfo = userService.findUserInfoByPhoneNumberAndPassword(phoneNumber, password);
            if (userInfo != null) {
                Week12Application.defaultProperties.setProperty("isProvider", ""+userInfo.getIsServiceProvider());
                Week12Application.defaultProperties.setProperty("providerName", userInfo.getName());
                Week12Application.defaultProperties.setProperty("id", ""+userInfo.getId());
                return "redirect:/pages/table-elements";
            }
        }
        return "redirect:/login?error";
    }

    @PostMapping(value = "action_registerabc", params = "register")
    public String register(@RequestParam Map<String, String> params) {
        for (String key : params.keySet()) {


            System.out.println("key:" + params.get(key) );
        }
        /*ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("register.html");
        return modelAndView;*/
        return "/register.html";
    }

    // handler method to handle user registration form submit request
    @PostMapping(value = "action_register")
    public String registration(@Valid @ModelAttribute("userInfo") UserInfo userInfo,
                               BindingResult result,
                               Model model){
        UserInfo existingUser = userService.findUserInfoByPhoneNumber(userInfo.getPhoneNumber());

        if(existingUser != null && existingUser.getPhoneNumber() != null){
            result.rejectValue("phoneNumber", null,
                    "There is already an account registered with the same phone number");
        }

        if(result.hasErrors()){
            model.addAttribute("user", userInfo);
            return "/register";
        }

        userService.saveUser(userInfo);
        return "redirect:/register?success";
    }

    // handler method to handle user registration form request
    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        // create model object to store form data
        UserInfo user = new UserInfo();
        model.addAttribute("user", user);
        return "register";
    }

    // handler method to handle user login form request
    @GetMapping("/login")
    public String showForm(LoginForm loginForm) {
        return "form";
    }
}
