package dev.app.expense_tracker.user.source.mapper.impl;

import dev.app.expense_tracker.user.source.mapper.SourceToSourceResponseMapper;
import dev.app.expense_tracker.user.source.model.Source;
import dev.app.expense_tracker.user.source.web.model.SourceResponse;
import org.springframework.stereotype.Component;

@Component
public class SourceToSourceResponseMapperImpl implements SourceToSourceResponseMapper {

    @Override
    public SourceResponse map(Source source) {
        return new SourceResponse(
                source.getId(),
                source.getName(),
                source.getHex(),
                source.getBalance(),
                source.getCurrency(),
                source.getCreatedTimestamp()
        );
    }
}
