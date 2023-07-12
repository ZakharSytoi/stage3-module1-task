package com.mjc.school.repository.data;

import com.mjc.school.repository.model.NewsModel;

import java.util.List;

public class DataSource {

    private final List<NewsModel> newsList;
    private static DataSource instance;

    DataSource(){
        newsList = NewsData.getInstance().getNewsList();
    }

    public static DataSource getInstance(){
        if (instance == null) instance = new DataSource();
        return instance;
    }

    public List<NewsModel> getNewsList() {
        return newsList;
    }
}
