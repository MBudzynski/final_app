package pl.sda.finalapp.categories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public String categoriesPage(@RequestParam(required = false) String searchText, Model model){
        List<CategoryDto> categories = categoryService.findCategories(searchText);
        model.addAttribute("categoriesData",categories);
        model.addAttribute("searchText",searchText);
        return "categoriesPage";
    }

    @PostMapping("/addCategory")
    public String addCategory(@RequestParam String categoryName, @RequestParam Integer parentId){
        categoryService.addCategory(categoryName, parentId);
        return "redirect:/categories?searchText=" + categoryName;
    }

    @PostMapping("/moveCategory")
    public String moveCategory(@RequestParam Integer newParentId, @RequestParam Integer movedId){
        categoryService.moveCategory(newParentId, movedId);
        return "redirect:/categories" ;
    }

}
