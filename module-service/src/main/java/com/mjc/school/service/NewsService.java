package com.mjc.school.service;

import com.mjc.school.repository.Repository;
import com.mjc.school.service.dtos.NewsDtoRequest;
import com.mjc.school.service.dtos.NewsDtoResponse;
import com.mjc.school.service.mapper.NewsMapper;

import java.util.List;

public class NewsService {
    private final Repository repository;

    private static NewsService instance;
    private NewsService() {
        repository = Repository.getInstance();
    }

    public static NewsService getInstance(){
        if (instance == null) {
            instance = new NewsService();
        }
        return instance;
    }
    public List<NewsDtoResponse> getAll(){
        return NewsMapper.INSTANCE.newsListToDtoList(repository.getAll());
    }

    public NewsDtoResponse getById(long id){
        return NewsMapper.INSTANCE.newsToDto(repository.getById(id));
    }

    public NewsDtoResponse create(NewsDtoRequest news){
        return NewsMapper.INSTANCE.newsToDto(repository.create(NewsMapper.INSTANCE.dtoToNews(news)));
    }

    public NewsDtoResponse update(NewsDtoRequest news){
        return NewsMapper.INSTANCE.newsToDto(repository.update(NewsMapper.INSTANCE.dtoToNews(news)));
    }

    public boolean delete(long id){
        return repository.delete(id);
    }
}
