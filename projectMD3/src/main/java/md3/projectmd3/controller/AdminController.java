package md3.projectmd3.controller;

import md3.projectmd3.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

    @Autowired
    private CategoryServiceImpl categoryService;

    @GetMapping("/categoryList")
    public String categoryList(Model model) {
        model.addAttribute("categories",categoryService.findAll());
        return "admin/categoryList";
    }
}
