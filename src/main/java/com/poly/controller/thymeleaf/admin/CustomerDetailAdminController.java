package com.poly.controller.thymeleaf.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerDetailAdminController {
    @GetMapping("/admin/customer/detail")
    public String customer() {
        return "admin/detail-customer";
    }
}
