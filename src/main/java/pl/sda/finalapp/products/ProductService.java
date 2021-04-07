package pl.sda.finalapp.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.finalapp.categories.CategoryService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryService categoryService;

    public List<ProductListDto> findProducts(String query, ProductType productType, Integer categoryId) {
        List<Product> products;
        if (isSearchAll(query, productType, categoryId)) {
            products = productRepository.findAll();
        } else if (isSearchByTitleAndProductType(query, productType, categoryId))  {
            products = productRepository.findByProductTypeAndTitle(query, productType);
        } else if(isSearchByTitleCategoryIdAndProductType(query, productType, categoryId)){
            products = productRepository.findByProductTypeAndTitleAndCategoryId(query, productType,categoryId);
        } else if(isSearchByProductTypeAndCategoryId(query, productType, categoryId)) {
            products = productRepository.findByProductTypeAndCategoryId(productType,categoryId);
        } else if(isSearchByTitleAndCategoryId(query, productType, categoryId)){
            products = productRepository.findByTitleAndCategoryId(query,categoryId);
        } else if (isSearchOnlyByProductType(productType)) {
            products = productRepository.findByProductType(productType);
        } else if (isSearchOnlyByCategoryId(categoryId)) {
            products = productRepository.findByCategoryId(categoryId);
        } else {
            products = productRepository.findByTitle(query);
        }
        return products.stream()
                .map(p -> createProductListDto(p))
                .collect(Collectors.toList());
    }

    private boolean isSearchOnlyByCategoryId(Integer categoryId) {
        return categoryId != null;
    }

    private boolean isSearchOnlyByProductType(ProductType productType) {
        return productType != null;
    }

    private boolean isSearchByTitleAndCategoryId(String query, ProductType productType, Integer categoryId) {
        return (query != null && !query.isBlank()) &&  productType == null && categoryId != null;
    }

    private boolean isSearchByProductTypeAndCategoryId(String query, ProductType productType, Integer categoryId) {
        return productType != null && categoryId != null && (query == null || query.isBlank());
    }

    private boolean isSearchByTitleCategoryIdAndProductType(String query, ProductType productType, Integer categoryId) {
        return productType != null && (query != null && !query.isBlank()) && categoryId != null;
    }

    private boolean isSearchByTitleAndProductType(String query, ProductType productType, Integer categoryId) {
        return productType != null && (query != null && !query.isBlank()) && categoryId == null;
    }

    private boolean isSearchAll(String query, ProductType productType, Integer categoryId) {
        return (query == null || query.isBlank()) && productType == null && categoryId == null;
    }


    private ProductListDto createProductListDto(Product p) {
       String categoryName=  categoryService.findCategoryNameById(p.getCategoryId())
               .orElseGet(()-> createErrorText(p));
        return p.toListDto(categoryName);
    }


    private String createErrorText(Product p) {
        return "Błąd " + p.getCategoryId();
    }

    public void addProduct(ProductDto dto) {
        Product product = Product.fromDto(dto);
        productRepository.save(product);
    }

    public Optional<ProductDto> findProductById(Integer id) {
        return productRepository.findById(id).map(p-> p.toDto());
    }

    public void update(ProductDto dto) {
        Product product = productRepository.findById(dto.getId())
                .orElseThrow(()-> new RuntimeException("Nie znaleziono produktu o id: " + dto.getId()));
        product.apply(dto);
        productRepository.save(product);
    }
}
