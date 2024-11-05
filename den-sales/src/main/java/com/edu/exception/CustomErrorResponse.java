package com.edu.exception;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public record CustomErrorResponse(
        ZonedDateTime dateTime,
        String message,
        String path
) {
}
