package com.mjc.school.service.dtos;


public record NewsDtoRequest(Long id, String title, String content, Long authorId) {
}
