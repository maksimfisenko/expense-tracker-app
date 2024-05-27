package dev.app.expense_tracker.user.source.mapper;

import dev.app.expense_tracker.common.mapper.Mapper;
import dev.app.expense_tracker.user.source.model.Source;
import dev.app.expense_tracker.user.source.web.model.SourceResponse;

public interface SourceToSourceResponseMapper extends Mapper<SourceResponse, Source> {
}
