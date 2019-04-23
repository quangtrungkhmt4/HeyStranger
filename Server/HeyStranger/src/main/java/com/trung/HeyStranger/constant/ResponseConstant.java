package com.trung.HeyStranger.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseConstant {
    SUCCESS(200, "Success"),
    FAILED(500, "Failed"),
    BAD_REQUEST(400, "Bad request");

    private int code;
    private String message;
}
