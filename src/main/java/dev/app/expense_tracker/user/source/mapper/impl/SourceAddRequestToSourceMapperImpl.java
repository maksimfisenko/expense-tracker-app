package dev.app.expense_tracker.user.source.mapper.impl;

import dev.app.expense_tracker.user.profile.api.service.CurrentUserProfileApiService;
import dev.app.expense_tracker.user.source.mapper.SourceAddRequestToSourceMapper;
import dev.app.expense_tracker.user.source.model.Source;
import dev.app.expense_tracker.user.source.web.model.SourceAddRequest;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class SourceAddRequestToSourceMapperImpl implements SourceAddRequestToSourceMapper {

    CurrentUserProfileApiService currentUserProfileApiService;

    @Override
    public Source map(SourceAddRequest sourceAddRequest) {
        Source source = new Source();
        source.setName(sourceAddRequest.name());
        source.setHex(sourceAddRequest.hex());
        source.setBalance(sourceAddRequest.balance());
        source.setCurrency(sourceAddRequest.currency());
        source.setUserProfile(currentUserProfileApiService.getCurrentUserProfile());
        return source;
    }
}
