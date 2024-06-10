package dev.app.expense_tracker.user.subcategory.web;

import dev.app.expense_tracker.user.subcategory.usecase.SubcategoryAddUseCase;
import dev.app.expense_tracker.user.subcategory.usecase.SubcategoryDeleteUseCase;
import dev.app.expense_tracker.user.subcategory.usecase.SubcategoryEditUseCase;
import dev.app.expense_tracker.user.subcategory.usecase.SubcategoryFindUseCase;
import dev.app.expense_tracker.user.subcategory.web.model.SubcategoryAddRequest;
import dev.app.expense_tracker.user.subcategory.web.model.SubcategoryEditRequest;
import dev.app.expense_tracker.user.subcategory.web.model.SubcategoryResponse;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/subcategories")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class SubcategoryController {

    SubcategoryAddUseCase subcategoryAddUseCase;
    SubcategoryEditUseCase subcategoryEditUseCase;
    SubcategoryDeleteUseCase subcategoryDeleteUseCase;
    SubcategoryFindUseCase subcategoryFindUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SubcategoryResponse createSubcategory(@Valid @RequestBody SubcategoryAddRequest subcategoryAddRequest) {
        return subcategoryAddUseCase.addSubcategory(subcategoryAddRequest);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public SubcategoryResponse updateSubcategory(@Valid @RequestBody SubcategoryEditRequest subcategoryEditRequest) {
        return subcategoryEditUseCase.editSubcategory(subcategoryEditRequest);
    }

    @DeleteMapping("/{subcategoryId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteSubcategory(@PathVariable("subcategoryId") Long subcategoryId) {
        subcategoryDeleteUseCase.deleteSubcategory(subcategoryId);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<SubcategoryResponse> findCategorySubcategories(@RequestParam("categoryId") Long categoryId) {
        return subcategoryFindUseCase.findCategorySubcategories(categoryId);
    }

}
