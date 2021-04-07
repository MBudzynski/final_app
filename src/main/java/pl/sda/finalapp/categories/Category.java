package pl.sda.finalapp.categories;


import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
@NoArgsConstructor
public class  Category {

    private String categoryName;
    private Integer id;
    private Integer parentId;
    private Integer depth;
    private static Integer counter = 0;

    public static Category createFromText(String text) {
        Category category = new Category();
        category.categoryName = text.trim();
        category.id = ++counter;
        category.depth = calculateDepth(text);
        return category;
    }

    public static Category createFromNameAndParentId(String text, Integer parentId){
        Category category = new Category();
        category.categoryName = text.trim();
        category.id = ++counter;
        category.parentId = parentId;
        return category;
    }

    private static int calculateDepth(String text) {
        if (text.startsWith(" ")) {
            return text.split("\\S+")[0].length();
        }
        return 0;

    }

    public void applyParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public void applyDepth(Integer depth) {
        this.depth = depth;
    }

    public CategoryDto toDto() {
        return new CategoryDto(
                this.id,
                this.categoryName,
                this.parentId);
    }

    public CategoryWithIdDto toCategoryWithIdDto() {
        return new CategoryWithIdDto(this.id, this.categoryName);
    }
}
