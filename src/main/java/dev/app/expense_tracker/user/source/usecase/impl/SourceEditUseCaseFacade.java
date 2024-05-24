package dev.app.expense_tracker.user.source.usecase.impl;

import dev.app.expense_tracker.user.profile.api.service.CurrentUserProfileApiService;
import dev.app.expense_tracker.user.profile.model.UserProfile;
import dev.app.expense_tracker.user.source.mapper.SourceEditRequestToSourceMapper;
import dev.app.expense_tracker.user.source.mapper.SourceToSourceResponseMapper;
import dev.app.expense_tracker.user.source.model.Source;
import dev.app.expense_tracker.user.source.service.SourceService;
import dev.app.expense_tracker.user.source.usecase.SourceEditUseCase;
import dev.app.expense_tracker.user.source.web.model.SourceEditRequest;
import dev.app.expense_tracker.user.source.web.model.SourceResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class SourceEditUseCaseFacade implements SourceEditUseCase {

    SourceEditRequestToSourceMapper sourceEditRequestToSourceMapper;
    SourceToSourceResponseMapper sourceToSourceResponseMapper;
    SourceService sourceService;
    CurrentUserProfileApiService currentUserProfileApiService;

    @Override
    public SourceResponse editSource(SourceEditRequest sourceEditRequest) {

        UserProfile actor = currentUserProfileApiService.getCurrentUserProfile();

        UserProfile owner = sourceService
                .findSourceById(sourceEditRequest.id())
                .map(Source::getUserProfile)
                .orElseThrow(() -> {
                    String errorMessage = String.format("Source with id = %d not found", sourceEditRequest.id());
                    return new RuntimeException(errorMessage);
                });

        if (!actor.equals(owner)) {
            String errorMessage = String.format(
                    "Editing source with id = %d not possible as %s is not its owner.",
                    sourceEditRequest.id(),
                    actor.getName());
            throw new RuntimeException(errorMessage);
        }

        Source source = sourceEditRequestToSourceMapper.map(sourceEditRequest);
        Source updatedSource = sourceService.updateSource(source);

        return sourceToSourceResponseMapper.map(updatedSource);
    }
}
