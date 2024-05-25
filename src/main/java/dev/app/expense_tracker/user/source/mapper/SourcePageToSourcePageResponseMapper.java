package dev.app.expense_tracker.user.source.mapper;

import dev.app.expense_tracker.security.mapper.Mapper;
import dev.app.expense_tracker.user.source.model.Source;
import dev.app.expense_tracker.user.source.web.model.SourcePageResponse;
import org.springframework.data.domain.Page;

public interface SourcePageToSourcePageResponseMapper extends Mapper<SourcePageResponse, Page<Source>> {
}
