package com.mjc.school.controller;

import com.mjc.school.service.impl.NewsService;
import com.mjc.school.service.dtos.NewsDtoRequest;
import com.mjc.school.service.dtos.NewsDtoResponse;

import java.util.List;

public class NewsController {

    private final NewsService newsService;

    public NewsController() {
        newsService = NewsService.getInstance();
    }

    public List<NewsDtoResponse> getAll() {
        return newsService.readAll();
    }

    public NewsDtoResponse getById(long id) {
        return newsService.readById(id);
    }

    public NewsDtoResponse create(NewsDtoRequest dtoRequest) {
        return newsService.create(dtoRequest);
    }

    public NewsDtoResponse update(NewsDtoRequest dtoRequest) {
        return newsService.update(dtoRequest);
    }

    public boolean delete(long id) {
        return newsService.delete(id);
    }

}
