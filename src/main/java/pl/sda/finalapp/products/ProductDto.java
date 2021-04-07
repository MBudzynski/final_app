package pl.sda.finalapp.products;

import java.math.BigDecimal;

public class ProductDto {

    private Integer id;
    private String title;
    private String pictureUrl;
    private BigDecimal price;
    private ProductType productType;
    private Integer CategoryId;

    public ProductDto() {
    }

    public ProductDto(Integer id, String title, String pictureUrl, BigDecimal price, ProductType productType, Integer categoryId) {
        this(title, pictureUrl, price, productType, categoryId);
        this.id = id;
    }

    public ProductDto(String title, String pictureUrl, BigDecimal price, ProductType productType, Integer categoryId) {
        this.title = title;
        this.pictureUrl = pictureUrl;
        this.price = price;
        this.productType = productType;
        CategoryId = categoryId;
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

    public Integer getCategoryId() {
        return CategoryId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public void setCategoryId(Integer categoryId) {
        CategoryId = categoryId;
    }
}
