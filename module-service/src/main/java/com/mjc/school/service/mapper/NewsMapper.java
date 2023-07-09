package com.mjc.school.service.mapper;


import com.mjc.school.repository.model.NewsModel;
import com.mjc.school.service.dtos.NewsDtoRequest;
import com.mjc.school.service.dtos.NewsDtoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface NewsMapper {

    NewsMapper INSTANCE = Mappers.getMapper(NewsMapper.class);

    List<NewsDtoResponse> newsListToDtoList(List<NewsModel> newsLIst);

    NewsDtoResponse newsToDto(NewsModel news);

    @Mappings(value = {@Mapping(target = "createDate", ignore = true), @Mapping(target = "lastUpdateDate", ignore = true)})
    NewsModel dtoToNews(NewsDtoRequest newsRequest);
}


