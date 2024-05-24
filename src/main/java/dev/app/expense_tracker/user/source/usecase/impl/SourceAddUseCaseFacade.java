package dev.app.expense_tracker.user.source.usecase.impl;

import dev.app.expense_tracker.user.source.mapper.SourceAddRequestToSourceMapper;
import dev.app.expense_tracker.user.source.mapper.SourceToSourceResponseMapper;
import dev.app.expense_tracker.user.source.model.Source;
import dev.app.expense_tracker.user.source.service.SourceService;
import dev.app.expense_tracker.user.source.usecase.SourceAddUseCase;
import dev.app.expense_tracker.user.source.web.model.SourceAddRequest;
import dev.app.expense_tracker.user.source.web.model.SourceResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class SourceAddUseCaseFacade implements SourceAddUseCase {

    SourceAddRequestToSourceMapper sourceAddRequestToSourceMapper;
    SourceToSourceResponseMapper sourceToSourceResponseMapper;
    SourceService sourceService;

    @Override
    public SourceResponse addSource(SourceAddRequest sourceAddRequest) {
        Source mappedSource = sourceAddRequestToSourceMapper.map(sourceAddRequest);
        Source createdSource = sourceService.createSource(mappedSource);
        return sourceToSourceResponseMapper.map(createdSource);
    }
}
