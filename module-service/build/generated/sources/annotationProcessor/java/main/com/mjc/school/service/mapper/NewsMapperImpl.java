package com.mjc.school.service.mapper;

import com.mjc.school.repository.model.NewsModel;
import com.mjc.school.service.dtos.NewsDtoRequest;
import com.mjc.school.service.dtos.NewsDtoResponse;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-09T08:29:30+0200",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.2.jar, environment: Java 17.0.6 (Oracle Corporation)"
)
public class NewsMapperImpl implements NewsMapper {

    @Override
    public List<NewsDtoResponse> newsListToDtoList(List<NewsModel> newsLIst) {
        if ( newsLIst == null ) {
            return null;
        }

        List<NewsDtoResponse> list = new ArrayList<NewsDtoResponse>( newsLIst.size() );
        for ( NewsModel newsModel : newsLIst ) {
            list.add( newsToDto( newsModel ) );
        }

        return list;
    }

    @Override
    public NewsDtoResponse newsToDto(NewsModel news) {
        if ( news == null ) {
            return null;
        }

        Long id = null;
        String title = null;
        String content = null;
        LocalDateTime createDate = null;
        LocalDateTime lastUpdateDate = null;
        Long authorId = null;

        id = news.getId();
        title = news.getTitle();
        content = news.getContent();
        createDate = news.getCreateDate();
        lastUpdateDate = news.getLastUpdateDate();
        authorId = news.getAuthorId();

        NewsDtoResponse newsDtoResponse = new NewsDtoResponse( id, title, content, createDate, lastUpdateDate, authorId );

        return newsDtoResponse;
    }

    @Override
    public NewsModel dtoToNews(NewsDtoRequest newsRequest) {
        if ( newsRequest == null ) {
            return null;
        }

        String title = null;
        String content = null;
        Long authorId = null;
        Long id = null;

        title = newsRequest.title();
        content = newsRequest.content();
        authorId = newsRequest.authorId();
        id = newsRequest.id();

        LocalDateTime createDate = null;
        LocalDateTime lastUpdateDate = null;

        NewsModel newsModel = new NewsModel( id, title, content, createDate, lastUpdateDate, authorId );

        return newsModel;
    }
}
