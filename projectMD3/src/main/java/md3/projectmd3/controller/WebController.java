package md3.projectmd3.controller;

import md3.projectmd3.model.entity.Category;
import md3.projectmd3.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class WebController {

    @Autowired
    private CategoryServiceImpl categoryService;

    @RequestMapping(value = {"/", "index"})
    public String index() {
        return "index";
    }
    @RequestMapping(value = "product-detail")
    public String productDetail() {
        return "general/product-detail";
    }
    @GetMapping("/list-products")
    public String listProducts() {
        return "general/list-products";
    }

    @GetMapping("/shopping-cart")
    public String shoppingCart() {
        return "user/shopping-cart";
    }

    @GetMapping("/checkout")
    public String checkOut() {
        return "user/checkout";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin/admin";
    }

//    submit to search
    @RequestMapping("/searchCategory")
    public String searchCategory(@RequestParam("query") String name, Model model) {
        List<Category> categories = categoryService.findByName(name);
        if (categories != null) {
            for (Category category : categories) {
                System.out.println("Category: " + category.getCategoryName());
            }
        }
        model.addAttribute("categories", categories);
        return "index";
    }

//    live search when you change in input (still check)
//    @RequestMapping(value = {"/searchCategory","index"})
//    public List<Category> searchCategory(@RequestParam("query") String name){
//        return categoryService.findByName(name);
//    }
}
