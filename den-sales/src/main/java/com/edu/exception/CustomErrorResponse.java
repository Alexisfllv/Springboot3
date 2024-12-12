package com.edu.exception;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public record CustomErrorResponse(
        LocalDateTime dateTime,
        String message,
        String path
) {
}
