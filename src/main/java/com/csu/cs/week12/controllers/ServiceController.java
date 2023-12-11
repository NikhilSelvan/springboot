package com.csu.cs.week12.controllers;

import com.csu.cs.week12.Week12Application;
import com.csu.cs.week12.models.ServiceInfo;
import com.csu.cs.week12.models.ServiceService;
import com.csu.cs.week12.models.UserInfo;
import com.csu.cs.week12.models.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Properties;

@Controller
@RequestMapping(path = "pages")
public class ServiceController {
    private final ServiceService serviceService;
    private final UserService userService;


    @Autowired
    public ServiceController(ServiceService serviceService, UserService userService) {
        this.serviceService = serviceService;
        this.userService = userService;
    }

    @GetMapping
    public List<ServiceInfo> getServices() {
        return serviceService.getServices();
    }

    @GetMapping(value = "dashboard")
    public String passParametersWithModelMap2(ModelMap map) {
        map.addAttribute("welcomeMessage", "welcome");
        map.addAttribute("message", "Baeldung");
        return "pages/dashboard";
    }

    @GetMapping(value = "table-elements")
    public String passParametersWithModelMap(ModelMap map) {
        map.addAttribute("service_providers", serviceService.getServiceProviders(new Boolean(Week12Application.defaultProperties.getProperty("isProvider"))));
        map.addAttribute("isProvider", new Boolean(Week12Application.defaultProperties.getProperty("isProvider")));
        map.addAttribute("providerName", Week12Application.defaultProperties.getProperty("providerName"));
        System.out.println("isProvider: " + Week12Application.defaultProperties.getProperty("isProvider"));
        if (Week12Application.defaultProperties.getProperty("isProvider").equals("false")) {
            return "pages/table-elements";
        } else {
            UserInfo userInfo = userService.findUserInfoById(Long.parseLong(Week12Application.defaultProperties.getProperty("id")));
            ServiceInfo serviceInfo = new ServiceInfo();
            map.addAttribute("user", userInfo);
            map.addAttribute("serviceInfo", serviceInfo);
            return "pages/table-elements-providers";
        }
    }

    @PostMapping(value = "action_add_service")
    public String registration(@Valid @ModelAttribute("serviceInfo") ServiceInfo serviceInfo,
                               BindingResult result,
                               Model model){
        serviceInfo.setId(Long.parseLong(Week12Application.defaultProperties.getProperty("id")));
        //serviceService.addNewService(serviceInfo);
        serviceService.saveService(serviceInfo);

        return "redirect:table-elements";
    }

    @PostMapping(value = "a1ction_add_service123")
    public String addNewService(@RequestBody ServiceInfo serviceInfo) {
        serviceInfo.setId(Long.parseLong(Week12Application.defaultProperties.getProperty("id")));
        serviceService.addNewService(serviceInfo);
        return "redirect:pages/table-elements";
    }
/*
    @DeleteMapping(path = "{ServiceID}")
    public void deleteService(@PathVariable("ServiceID") Long ServiceId){
        ServiceService.deleteService(ServiceId);
    }
*/
}
