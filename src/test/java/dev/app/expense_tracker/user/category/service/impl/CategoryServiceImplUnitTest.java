package dev.app.expense_tracker.user.category.service.impl;

import dev.app.expense_tracker.user.category.model.Category;
import dev.app.expense_tracker.user.category.repository.CategoryRepository;
import dev.app.expense_tracker.user.profile.model.UserProfile;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class CategoryServiceImplUnitTest {

    @InjectMocks
    private CategoryServiceImpl categoryService;
    @Mock
    private CategoryRepository categoryRepository;

    @Test
    void createCategory_shouldReturnNonEmptyCategory() {

        Category expectedCategory = new Category();
        expectedCategory.setName("category");
        expectedCategory.setHex("#ffffff");
        expectedCategory.setCurrency("USD");
        expectedCategory.setCreatedTimestamp(Instant.now());
        expectedCategory.setLastModifiedTimestamp(Instant.now());
        expectedCategory.setUserProfile(new UserProfile());

        Mockito.when(
                categoryRepository.save(expectedCategory)
        ).thenReturn(
                expectedCategory
        );

        Category actualResult = categoryService.createCategory(expectedCategory);

        assertEquals(expectedCategory, actualResult);
        Mockito.verify(
                categoryRepository,
                Mockito.times(1)
        ).save(expectedCategory);

    }

    @Test
    void updateCategory_shouldReturnNonEmptyCategory() {

        Category expectedCategory = new Category();
        expectedCategory.setName("category");
        expectedCategory.setHex("#ffffff");
        expectedCategory.setCurrency("USD");
        expectedCategory.setCreatedTimestamp(Instant.now());
        expectedCategory.setLastModifiedTimestamp(Instant.now());
        expectedCategory.setUserProfile(new UserProfile());

        Mockito.when(
                categoryRepository.save(expectedCategory)
        ).thenReturn(
                expectedCategory
        );

        Category actualResult = categoryService.createCategory(expectedCategory);

        assertEquals(expectedCategory, actualResult);
        Mockito.verify(
                categoryRepository,
                Mockito.times(1)
        ).save(expectedCategory);

    }

    @Test
    void findCategoryById_shouldReturnNonEmptyCategory() {

        Category expectedCategory = new Category();
        expectedCategory.setName("category");
        expectedCategory.setHex("#ffffff");
        expectedCategory.setCurrency("USD");
        expectedCategory.setCreatedTimestamp(Instant.now());
        expectedCategory.setLastModifiedTimestamp(Instant.now());
        expectedCategory.setUserProfile(new UserProfile());

        Mockito.when(
                categoryRepository.findById(expectedCategory.getId())
        ).thenReturn(
                Optional.of(expectedCategory)
        );

        Optional<Category> actualResult = categoryService.findCategoryById(expectedCategory.getId());

        assertEquals(Optional.of(expectedCategory), actualResult);
        Mockito.verify(
                categoryRepository,
                Mockito.times(1)
        ).findById(Mockito.any());

    }

    @Test
    void findCategoryById_shouldReturnEmptyCategory() {

        Category expectedCategory = new Category();
        expectedCategory.setName("category");
        expectedCategory.setHex("#ffffff");
        expectedCategory.setCurrency("USD");
        expectedCategory.setCreatedTimestamp(Instant.now());
        expectedCategory.setLastModifiedTimestamp(Instant.now());
        expectedCategory.setUserProfile(new UserProfile());

        Mockito.when(
                categoryRepository.findById(expectedCategory.getId())
        ).thenReturn(
                Optional.empty()
        );

        Optional<Category> actualResult = categoryService.findCategoryById(expectedCategory.getId());

        assertEquals(Optional.empty(), actualResult);
        Mockito.verify(
                categoryRepository,
                Mockito.times(1)
        ).findById(Mockito.any());

    }

    @Test
    void deleteCategory_shouldReturnVoid() {

        Category expectedCategory = new Category();
        expectedCategory.setName("category");
        expectedCategory.setHex("#ffffff");
        expectedCategory.setCurrency("USD");
        expectedCategory.setCreatedTimestamp(Instant.now());
        expectedCategory.setLastModifiedTimestamp(Instant.now());
        expectedCategory.setUserProfile(new UserProfile());

        assertDoesNotThrow(() -> categoryService.deleteCategory(expectedCategory.getId()));
        Mockito.verify(
                categoryRepository,
                Mockito.times(1)
        ).deleteById(Mockito.any());

    }

    @Test
    void findAllCategories_shouldReturnNonEmptyCategories() {
        // TODO: 
    }

}