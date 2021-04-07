package pl.sda.finalapp.products;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sda.finalapp.categories.CategoryService;

import java.math.BigDecimal;
import java.util.Optional;

@Controller
@RequestMapping
public class ProductController {


    private final ProductService productService;
    private final CategoryService categoryService;



    public ProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping("/products")
    String productList(@RequestParam(value = "query", required = false) String query,
                       @RequestParam(value = "productType", required = false) ProductType productType,
                       @RequestParam(value = "categoryId", required = false) Integer categoryId,
                       Model model) {
        model.addAttribute("productsList", productService.findProducts(query, productType, categoryId));
        model.addAttribute("searchText", query);
        model.addAttribute("productType", productType);
        model.addAttribute("productTypes", ProductType.values());
        model.addAttribute("categoriesWithId", categoryService.prepareCategoriesWithId());
        model.addAttribute("selectedCategoryId", categoryId);
        return "productsPage";
    }

    @PostMapping("/products")
    String addProduct(@RequestParam String title,
                      @RequestParam String pictureUrl,
                      @RequestParam BigDecimal price,
                      @RequestParam ProductType productType,
                      @RequestParam Integer categoryId){

        ProductDto dto = new ProductDto(title, pictureUrl, price, productType, categoryId);
        productService.addProduct(dto);
        return "redirect:/products";
    }

    @GetMapping("/products/{id}")
    String editProduct(@PathVariable Integer id, Model model){
        Optional<ProductDto> productById = productService.findProductById(id);
        if(productById.isEmpty()){
            return "redirect:/products";
        }
        model.addAttribute("product", productById.get());
        model.addAttribute("productTypeList", ProductType.values());
        model.addAttribute("categoryWithIdList", categoryService.prepareCategoriesWithId());

        return "editProductPage";
    }

    @PostMapping("/products/{id}")
    String editProduct(@ModelAttribute ProductDto product, @PathVariable Integer id){
        if(product.getId().equals(id)){
            productService.update(product);
        } else{
            throw new RuntimeException("Id produktu nie jst zgodne z Id elementu");
        }
        return "redirect:/products";
    }


}
