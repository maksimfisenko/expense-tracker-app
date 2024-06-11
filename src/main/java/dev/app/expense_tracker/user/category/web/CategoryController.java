package dev.app.expense_tracker.user.category.web;

import dev.app.expense_tracker.user.category.usecase.CategoryAddUseCase;
import dev.app.expense_tracker.user.category.usecase.CategoryDeleteUseCase;
import dev.app.expense_tracker.user.category.usecase.CategoryEditUseCase;
import dev.app.expense_tracker.user.category.usecase.CategoryFindUseCase;
import dev.app.expense_tracker.user.category.web.model.*;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/categories")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class CategoryController {

    CategoryAddUseCase categoryAddUseCase;
    CategoryEditUseCase categoryEditUseCase;
    CategoryDeleteUseCase categoryDeleteUseCase;
    CategoryFindUseCase categoryFindUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryResponse createCategory(@Valid @RequestBody CategoryAddRequest categoryAddRequest) {
        return categoryAddUseCase.addCategory(categoryAddRequest);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public CategoryResponse updateCategory(@Valid @RequestBody CategoryEditRequest categoryEditRequest) {
        return categoryEditUseCase.editCategory(categoryEditRequest);
    }

    @DeleteMapping("/{categoryId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteSource(@PathVariable("categoryId") Long categoryId) {
        categoryDeleteUseCase.deleteCategory(categoryId);
    }

    @GetMapping("/expenses")
    @ResponseStatus(HttpStatus.OK)
    public CategoryPageResponse findUserExpenseCategories(
            @RequestParam("page") int page,
            @RequestParam("limit") int limit) {
        CategoryFindRequest categoryFindRequest = new CategoryFindRequest(page, limit);
        return categoryFindUseCase.findExpenseCategories(categoryFindRequest);
    }

    @GetMapping("/income")
    @ResponseStatus(HttpStatus.OK)
    public CategoryPageResponse findUserIncomeCategories(
            @RequestParam("page") int page,
            @RequestParam("limit") int limit) {
        CategoryFindRequest categoryFindRequest = new CategoryFindRequest(page, limit);
        return categoryFindUseCase.findIncomeCategories(categoryFindRequest);
    }

}
