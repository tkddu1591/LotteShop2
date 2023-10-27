package com.example.kmarket.mapper.cs;

import com.example.kmarket.dto.cs.KmCsFaqDTO;
import com.example.kmarket.dto.cs.KmCsNoticeDTO;
import com.example.kmarket.dto.cs.KmCsQnaDTO;
import com.example.kmarket.dto.cs.KmCsTypeDTO;
import com.example.kmarket.entity.cs.*;

import com.example.kmarket.entity.cs.KmCsCateEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MybatisCSMapper {
    List<KmCsCateEntity> findByTypeLessThan(int type);

    List<KmCsNoticeDTO> indexNoticeList();
    List<KmCsQnaDTO> indexQnaList();

    List<KmCsFaqDTO> selectFaqList(String cate);
    List<KmCsTypeDTO> findByTypeForCate(String cate);
}
