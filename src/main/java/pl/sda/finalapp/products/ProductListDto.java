package pl.sda.finalapp.products;


import java.math.BigDecimal;

public class ProductListDto {

    private Integer id;
    private String title;
    private String pictureUrl;
    private BigDecimal price;
    private ProductType productType;
    private String categoryName;


    public ProductListDto(Integer id, String title, String pictureUrl, BigDecimal price, ProductType productType, String categoryName) {
        this.id = id;
        this.title = title;
        this.pictureUrl = pictureUrl;
        this.price = price;
        this.productType = productType;
        this.categoryName = categoryName;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductType getProductType() {
        return productType;
    }

    public String getCategoryName() {
        return categoryName;
    }
}
