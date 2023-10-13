package com.example.crud_project.mapper;

import com.example.crud_project.dto.ArticleDTO;
import com.example.crud_project.entity.ArticleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ArticleMapper {
    public ArticleDTO toDTO(ArticleEntity articleEntity);
    public ArticleEntity toEntity(ArticleDTO articleDTO);
}

