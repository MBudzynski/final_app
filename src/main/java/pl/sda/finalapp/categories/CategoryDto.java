package pl.sda.finalapp.categories;


public class CategoryDto {

    private Integer id;
    private String categoryName;
    private Integer parentId;
    private Boolean selected;
    private Boolean open;

    public CategoryDto(Integer id, String categoryName, Integer parentId) {
        this.id = id;
        this.categoryName = categoryName;
        this.parentId = parentId;
    }

    public Integer getId() {
        return id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void applySelected(Boolean selected) {
        this.selected = selected;
    }

    public void applyOpen(boolean open) {
        this.open = open;
    }

    public String getText() {
        return this.id + ". " + this.categoryName;
    }

    public String getParent() {
        if (this.parentId == null) {
            return "#";
        }
        return parentId.toString();
    }

    public CategoryState getState(){
        return new CategoryState(this.open, this.selected);
    }

}

class CategoryState{
    private Boolean open;
    private Boolean selected;

    public CategoryState() {
    }

    public CategoryState(Boolean open, Boolean selected) {
        this.open = open;
        this.selected = selected;
    }

    public Boolean getOpen() {
        return open;
    }

    public Boolean getSelected() {
        return selected;
    }
}
