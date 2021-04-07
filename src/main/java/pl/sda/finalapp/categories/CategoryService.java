package pl.sda.finalapp.categories;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private CategoryDao categoryDao = CategoryDao.getInstance();

    public List<CategoryDto> findCategories(String searchText) {
        List<CategoryDto> dtos = categoryDao.getCategoryList().stream()
                .map(c -> c.toDto())
                .collect(Collectors.toList());

        for (CategoryDto dto : dtos) {
            if (dto.getCategoryName().equals(searchText)) {
                dto.applySelected(true);
                openAllParents(dto.getParentId(), dtos);
            }
        }
        return dtos;
    }

    private void openAllParents(Integer parentId, List<CategoryDto> potentialParents) {
        if (parentId == null) {
            return;
        }
        potentialParents.stream()
                .filter(dto -> parentId.equals(dto.getId()))
                .forEach(dto -> {
                    dto.applyOpen(true);
                    openAllParents(dto.getParentId(), potentialParents);
                });
    }

    public void addCategory(String categoryName, Integer parentId) {
        categoryDao.addCategory(categoryName, parentId);
    }

    public void moveCategory(Integer newParentId, Integer movedId){
        if (newParentId == null) {
            categoryDao.getCategoryList().stream().filter(c -> c.getId().equals(movedId)).forEach(c -> {
                c.applyParentId(newParentId);
            });
        } else {
            boolean isNewParentExists = categoryDao.getCategoryList().stream()
                    .anyMatch(c -> newParentId.equals(c.getId()));

            if (isNewParentExists) {
                categoryDao.getCategoryList().stream().filter(c -> c.getId().equals(movedId)).forEach(c -> {
                    c.applyParentId(newParentId);
                    c.applyDepth(getParentDepth(newParentId) + 1);
                });
            }
        }
    }


    private Integer getParentDepth(Integer newParentId) {
         Optional<Category> parent = categoryDao.getCategoryList()
                .stream()
                .filter(c -> c.getId().equals(newParentId))
                .findFirst();

         return parent.get().getDepth();
    }

    public Optional<String> findCategoryNameById(Integer categoryId) {
        return categoryDao.findCategoryById(categoryId)
                .map(c -> c.getCategoryName());
    }

    public List<CategoryWithIdDto> prepareCategoriesWithId() {
       return categoryDao.getCategoryList().stream().map(c-> c.toCategoryWithIdDto()).collect(Collectors.toList());
    }
}
