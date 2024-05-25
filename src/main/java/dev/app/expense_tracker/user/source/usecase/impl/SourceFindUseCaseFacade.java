package dev.app.expense_tracker.user.source.usecase.impl;

import dev.app.expense_tracker.user.profile.api.service.CurrentUserProfileApiService;
import dev.app.expense_tracker.user.profile.model.UserProfile;
import dev.app.expense_tracker.user.source.mapper.SourcePageToSourcePageResponseMapper;
import dev.app.expense_tracker.user.source.model.Source;
import dev.app.expense_tracker.user.source.service.SourceService;
import dev.app.expense_tracker.user.source.usecase.SourceFindUseCase;
import dev.app.expense_tracker.user.source.web.model.SourceFindRequest;
import dev.app.expense_tracker.user.source.web.model.SourcePageResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import static dev.app.expense_tracker.user.source.model.Source_.CREATED_TIMESTAMP;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class SourceFindUseCaseFacade implements SourceFindUseCase {

    SourcePageToSourcePageResponseMapper sourcePageToSourcePageResponseMapper;
    SourceService sourceService;
    CurrentUserProfileApiService currentUserProfileApiService;

    @Override
    public SourcePageResponse findSources(SourceFindRequest sourceFindRequest) {

        UserProfile owner = currentUserProfileApiService.getCurrentUserProfile();

        Sort sort = Sort.by(Sort.Direction.ASC, CREATED_TIMESTAMP);
        Pageable pageable = PageRequest.of(sourceFindRequest.page(), sourceFindRequest.limit(), sort);

        Page<Source> pageableSourceResult = sourceService.findAllSources(owner, pageable);

        return sourcePageToSourcePageResponseMapper.map(pageableSourceResult);
    }
}
