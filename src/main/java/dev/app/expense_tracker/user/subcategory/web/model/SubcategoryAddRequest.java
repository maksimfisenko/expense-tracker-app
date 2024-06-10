package dev.app.expense_tracker.user.subcategory.web.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record SubcategoryAddRequest(
        @NotBlank @Size(min = 1, max = 100) String name,
        @NotNull Long categoryId
) {
}
