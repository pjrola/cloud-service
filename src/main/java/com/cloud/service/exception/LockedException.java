package com.cloud.service.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LockedException extends Exception {
    private final String property;
}
