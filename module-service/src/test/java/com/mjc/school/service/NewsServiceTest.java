package com.mjc.school.service;

import com.mjc.school.service.dtos.NewsDtoRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class NewsServiceTest {
    static NewsService newsService;

    @BeforeAll
    public static void setService() {
        newsService = NewsService.getInstance();
    }

    @Test
    void getAllTest() {
        Assertions.assertEquals(20, newsService.getAll().size());
    }

    @Test
    void create() {
        NewsDtoRequest news = new NewsDtoRequest(1L, "Test Title", "Test Content", 10L);
        newsService.create(news);
        Assertions.assertAll(() -> Assertions.assertEquals(21, newsService.getAll().get(newsService.getAll().size() - 1).id()),
                () -> Assertions.assertEquals(news.title(), newsService.getAll().get(newsService.getAll().size() - 1).title()),
                () -> Assertions.assertEquals(news.content(), newsService.getAll().get(newsService.getAll().size() - 1).content()),
                () -> Assertions.assertEquals(news.authorId(), newsService.getAll().get(newsService.getAll().size() - 1).authorId()));
    }

    @Test
    void getById() {
        NewsDtoRequest news = new NewsDtoRequest(1L, "Test Title", "Test Content", 10L);
        newsService.create(news);
        Assertions.assertAll(() -> Assertions.assertEquals(21, newsService.getById(21).id()),
                () -> Assertions.assertEquals(news.title(), newsService.getById(21).title()),
                () -> Assertions.assertEquals(news.content(), newsService.getById(21).content()),
                () -> Assertions.assertEquals(news.authorId(), newsService.getById(21).authorId()));
    }


    @Test
    void update() {
        NewsDtoRequest news = new NewsDtoRequest(10L, "Test Title", "Test Content", 10L);
        newsService.update(news);
        Assertions.assertAll(() -> Assertions.assertEquals(10, newsService.getById(10).id()),
                () -> Assertions.assertEquals(news.title(), newsService.getById(10).title()),
                () -> Assertions.assertEquals(news.content(), newsService.getById(10).content()),
                () -> Assertions.assertEquals(news.authorId(), newsService.getById(10).authorId()));
    }

    @Test
    void delete() {
        newsService.delete(1);
        Assertions.assertEquals(19, newsService.getAll().size());
    }
}