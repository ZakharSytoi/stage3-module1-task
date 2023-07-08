package com.mjc.school.repository;

import com.mjc.school.repository.model.NewsModel;
import com.mjc.school.repository.data.NewsData;

import java.util.List;

public class DataSource {

    private List<NewsModel> newsList;
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
