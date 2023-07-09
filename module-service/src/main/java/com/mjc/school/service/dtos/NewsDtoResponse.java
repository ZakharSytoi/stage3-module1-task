package com.mjc.school.service.dtos;

import java.time.LocalDateTime;

public record NewsDtoResponse(Long id, String title, String content, LocalDateTime createDate, LocalDateTime lastUpdateDate, Long authorId) {
}
