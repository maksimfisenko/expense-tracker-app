package dev.app.expense_tracker.user.source.usecase.impl;

import dev.app.expense_tracker.user.profile.api.service.CurrentUserProfileApiService;
import dev.app.expense_tracker.user.profile.model.UserProfile;
import dev.app.expense_tracker.user.source.mapper.SourceToSourceResponseMapper;
import dev.app.expense_tracker.user.source.model.Source;
import dev.app.expense_tracker.user.source.service.SourceService;
import dev.app.expense_tracker.user.source.usecase.SourceFindUseCase;
import dev.app.expense_tracker.user.source.web.model.SourceResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class SourceFindUseCaseFacade implements SourceFindUseCase {

    SourceToSourceResponseMapper sourceToSourceResponseMapper;
    SourceService sourceService;
    CurrentUserProfileApiService currentUserProfileApiService;


    @Override
    public Collection<SourceResponse> findSources() {

        UserProfile owner = currentUserProfileApiService.getCurrentUserProfile();
        Collection<Source> allOwnerSources = sourceService.findAllSources(owner);

        return allOwnerSources.stream().map(sourceToSourceResponseMapper::map).toList();
    }
}
