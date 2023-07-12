package com.mjc.school.repository.impl;

import com.mjc.school.repository.data.DataSource;
import com.mjc.school.repository.model.NewsModel;

import java.util.List;

public class Repository {

    private final DataSource dataSource;

    private static Repository instance;

    public Repository() {
        dataSource = DataSource.getInstance();
    }

    public static Repository getInstance() {
        if (instance == null) instance = new Repository();
        return instance;
    }

    public List<NewsModel> readAll() {
        return dataSource.getNewsList();
    }

    public NewsModel readById(Long id) {
        for (NewsModel inst : dataSource.getNewsList()) {
            if (inst.getId().intValue() == id) {
                return inst;
            }
        }
        return null;
    }

    public NewsModel create(NewsModel news) {
        news.setId(dataSource.getNewsList().get(dataSource.getNewsList().size() - 1).getId()+1);
        dataSource.getNewsList().add(news);
        return dataSource.getNewsList().get(dataSource.getNewsList().size() - 1);
    }

    public NewsModel update(NewsModel news) {
        NewsModel tmp = null;
        for (NewsModel inst : dataSource.getNewsList()) {
            if (inst.getId().intValue() == news.getId().intValue()) {
                tmp = inst;
            }
        }
        if (tmp != null) {
            tmp.setAuthorId(news.getAuthorId());
            tmp.setTitle(news.getTitle());
            tmp.setContent(news.getContent());
            tmp.setLastUpdateDate(news.getLastUpdateDate());
        } else throw new NullPointerException("There is no such id to update");

        for (NewsModel inst : dataSource.getNewsList()) {
            if (inst.getId().intValue() == news.getId().intValue()) {
                return inst;
            }
        }
        return null;
    }

    public boolean delete(long id) {

        for (int i = 0; i < dataSource.getNewsList().size(); i++) {
            if (dataSource.getNewsList().get(i).getId() == id) {
                dataSource.getNewsList().remove(i);
                return true;
            }
        }
        return false;
    }

    public Boolean ifIdExist(long id){
        for (NewsModel model :
                dataSource.getNewsList()) {
            if(model.getId() == id) return true;
        }
        return false;
    }
}
