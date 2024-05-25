package dev.app.expense_tracker.user.source.mapper.impl;

import dev.app.expense_tracker.user.source.mapper.SourcePageToSourcePageResponseMapper;
import dev.app.expense_tracker.user.source.mapper.SourceToSourceResponseMapper;
import dev.app.expense_tracker.user.source.model.Source;
import dev.app.expense_tracker.user.source.web.model.SourcePageResponse;
import dev.app.expense_tracker.user.source.web.model.SourceResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class SourcePageToSourcePageResponseMapperImpl implements SourcePageToSourcePageResponseMapper {

    SourceToSourceResponseMapper sourceToSourceResponseMapper;

    @Override
    public SourcePageResponse map(Page<Source> sources) {

        Collection<SourceResponse> sourcePageResponses = sources
                .stream()
                .map(sourceToSourceResponseMapper::map)
                .toList();

        return new SourcePageResponse(
                sources.getTotalElements(),
                sources.isFirst(),
                sources.isLast(),
                sourcePageResponses);
    }
}
