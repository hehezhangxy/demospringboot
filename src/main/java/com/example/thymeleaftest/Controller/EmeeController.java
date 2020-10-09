package com.example.thymeleaftest.Controller;

import com.example.thymeleaftest.Depart;
import com.example.thymeleaftest.DepartDao;
import com.example.thymeleaftest.Emee;
import com.example.thymeleaftest.EmeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class EmeeController {

    EmeeDao emeeDao;
    @Autowired

    public void setEmeeDao(EmeeDao emeeDao) {
        this.emeeDao = emeeDao;
    }


    DepartDao departDao;
    @Autowired
    public void setDepartDao(DepartDao departDao) {
        this.departDao = departDao;
    }

    @RequestMapping("/emps")
    public String list(Model model) {
        Collection<Emee> emees = emeeDao.getAll();
        model.addAttribute("emps", emees);
        return "/list";
    }

    @GetMapping("/emp")
    public String toAddpage(Model model) {
        Collection<Depart> departs = departDao.getDeparts();
        model.addAttribute("departs",departs);
        return "/add";
    }

    @PostMapping("/emp")
    public String addEmp(Emee emee) {
        emeeDao.save(emee);
        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String toUpdateEmp(@PathVariable("id") Integer id, Model model) {
        Emee emeeById = emeeDao.getEmeeById(id);
        model.addAttribute("emp", emeeById);
        Collection<Depart> departs = departDao.getDeparts();
        model.addAttribute("departs",departs);
        return "/update";
    }

    @PostMapping("/updateEmp")
    public String updateEmp(Emee emee) {
        emeeDao.save(emee);
        return "redirect:/emps";
    }
}
