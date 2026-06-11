package org.acme.neptune.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class BaseResponse {

    private final String code;
    private final String message;
}
