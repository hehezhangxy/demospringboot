package com.example.thymeleaftest.Controller;

import com.example.thymeleaftest.Emee;
import com.example.thymeleaftest.EmeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class EmeeController {
    @Autowired
    EmeeDao emeeDao;
    @RequestMapping("/emps")
    public String list(Model model) {
        Collection<Emee> emees = emeeDao.getAll();
        model.addAttribute("emps", emees);
        return "/list";
    }
}
