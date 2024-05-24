package dev.app.expense_tracker.user.source.mapper.impl;

import dev.app.expense_tracker.user.source.mapper.SourceEditRequestToSourceMapper;
import dev.app.expense_tracker.user.source.model.Source;
import dev.app.expense_tracker.user.source.service.SourceService;
import dev.app.expense_tracker.user.source.web.model.SourceEditRequest;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class SourceEditRequestToSourceMapperImpl implements SourceEditRequestToSourceMapper {

    SourceService sourceService;

    @Override
    public Source map(SourceEditRequest sourceEditRequest) {

        Source currentSource = sourceService
                .findSourceById(sourceEditRequest.id())
                .orElseThrow(() -> {
                    String errorMessage = String.format("Source with id = %d not found", sourceEditRequest.id());
                    return new RuntimeException(errorMessage);
                });


        currentSource.setName(sourceEditRequest.name());
        currentSource.setHex(sourceEditRequest.hex());
        currentSource.setBalance(sourceEditRequest.balance());
        currentSource.setCurrency(sourceEditRequest.currency());

        return currentSource;
    }
}
