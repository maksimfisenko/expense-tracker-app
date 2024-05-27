package dev.app.expense_tracker.user.source.usecase.impl;

import dev.app.expense_tracker.common.exception.ExpenseTrackerException;
import dev.app.expense_tracker.user.profile.api.service.CurrentUserProfileApiService;
import dev.app.expense_tracker.user.profile.model.UserProfile;
import dev.app.expense_tracker.user.source.mapper.SourceEditRequestToSourceMapper;
import dev.app.expense_tracker.user.source.mapper.SourceToSourceResponseMapper;
import dev.app.expense_tracker.user.source.model.Source;
import dev.app.expense_tracker.user.source.service.SourceService;
import dev.app.expense_tracker.user.source.usecase.SourceDeleteUseCase;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class SourceDeleteUseCaseFacade implements SourceDeleteUseCase {

    SourceEditRequestToSourceMapper sourceEditRequestToSourceMapper;
    SourceToSourceResponseMapper sourceToSourceResponseMapper;
    SourceService sourceService;
    CurrentUserProfileApiService currentUserProfileApiService;

    @Override
    public void deleteSource(Long sourceId) {

        UserProfile actor = currentUserProfileApiService.getCurrentUserProfile();

        UserProfile owner = sourceService
                .findSourceById(sourceId)
                .map(Source::getUserProfile)
                .orElseThrow(() -> {
                    String errorMessage = String.format("Source with id = %d not found", sourceId);
                    return new ExpenseTrackerException(errorMessage);
                });

        if (!actor.equals(owner)) {
            String errorMessage = String.format(
                    "Deleting source with id = %d not possible as %s is not its owner.",
                    sourceId,
                    actor.getName());
            throw new ExpenseTrackerException(errorMessage);
        }

        sourceService.deleteSource(sourceId);
    }
}
