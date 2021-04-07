package pl.sda.finalapp.categories;

public class CategoryWithIdDto {

    private Integer id;
    private String categoryName;

    public CategoryWithIdDto(Integer id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
    }

    public String getIdWithName() {
        return id + ". " + categoryName;
    }

    public Integer getId() {
        return id;
    }
}
