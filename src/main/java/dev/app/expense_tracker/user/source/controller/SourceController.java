package dev.app.expense_tracker.user.source.controller;

import dev.app.expense_tracker.user.source.usecase.SourceAddUseCase;
import dev.app.expense_tracker.user.source.web.model.SourceAddRequest;
import dev.app.expense_tracker.user.source.web.model.SourceResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/sources")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class SourceController {

    SourceAddUseCase sourceAddUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SourceResponse createSource(@RequestBody SourceAddRequest sourceAddRequest) {
        return sourceAddUseCase.addSource(sourceAddRequest);
    }

}
