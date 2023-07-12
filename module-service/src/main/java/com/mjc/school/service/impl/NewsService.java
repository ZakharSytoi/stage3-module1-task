package com.mjc.school.service.impl;

import com.mjc.school.repository.impl.Repository;
import com.mjc.school.repository.model.NewsModel;
import com.mjc.school.service.dtos.NewsDtoRequest;
import com.mjc.school.service.dtos.NewsDtoResponse;
import com.mjc.school.service.exception.ValidatorException;
import com.mjc.school.service.mapper.NewsMapper;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static com.mjc.school.service.exception.ExceptionConstants.NEWS_ID_DOES_NOT_EXIST;

public class NewsService {
    public final Repository newsRepository;

    private static NewsService instance;

    public Validator newsValidator;

    public NewsService() {
        newsRepository = Repository.getInstance();
    }

    public static NewsService getInstance() {
        if (instance == null) {
            instance = new NewsService();
        }
        return instance;
    }

    public List<NewsDtoResponse> readAll() {
        return NewsMapper.INSTANCE.newsListToDtoList(newsRepository.readAll());
    }

    public NewsDtoResponse readById(Long id) {
        Validator.validateNewsId(id);
        validateNewsExistence(id);
        return NewsMapper.INSTANCE.newsToDto(newsRepository.readById(id));
    }

    public NewsDtoResponse create(NewsDtoRequest news) {
        Validator.validateDtoRequest(news);
        NewsModel model = NewsMapper.INSTANCE.dtoToNews(news);
        model.setCreateDate(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
        model.setLastUpdateDate(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
        return NewsMapper.INSTANCE.newsToDto(newsRepository.create(model));
    }

    public NewsDtoResponse update(NewsDtoRequest news) {
        Validator.validateDtoRequest(news);
        NewsModel model = NewsMapper.INSTANCE.dtoToNews(news);
        model.setLastUpdateDate(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
        return NewsMapper.INSTANCE.newsToDto(newsRepository.update(model));
    }

    public Boolean delete(Long id) {
        validateNewsExistence(id);
        return newsRepository.delete(id);
    }

    private void validateNewsExistence(long id) {
        if (!newsRepository.ifIdExist(id)) {
            throw new ValidatorException(String.format(NEWS_ID_DOES_NOT_EXIST.getCodeMsg(), id));
        }
    }
}
