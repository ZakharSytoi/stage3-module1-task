package com.mjc.school.repository.data;

import com.mjc.school.repository.model.AuthorModel;
import com.mjc.school.repository.model.NewsModel;
import com.mjc.school.repository.util.DataReader;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NewsData {
    private static final String CONTENT_FILE_NAME = "content";
    private static final String NEWS_FILE_NAME = "news";
    private static NewsData instance;
    private final List<NewsModel> newsList;

    private NewsData() {
        newsList = new ArrayList<>();
        List<AuthorModel> authors = AuthorData.getInstance().getAuthorList();
        List<String> content = DataReader.read(CONTENT_FILE_NAME);
        List<String> titles = DataReader.read(NEWS_FILE_NAME);
        Random rnd = new Random();
        for (long i = 1; i <= 20; i++) {
            newsList.add(new NewsModel(
                    i,
                    titles.get(rnd.nextInt(titles.size())),
                    content.get(rnd.nextInt(content.size())),
                    LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS), LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS),
                    authors.get(rnd.nextInt(authors.size())).getId()));
        }
    }


    public static NewsData getInstance() {
        if (instance == null) instance = new NewsData();
        return instance;
    }

    public List<NewsModel> getNewsList() {
        return newsList;
    }
}
