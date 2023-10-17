package com.example.kmarket.service;

import com.example.kmarket.dto.KmAdminNoticeDTO;
import com.example.kmarket.dto.PageRequestDTO;
import com.example.kmarket.dto.PageResponseDTO;
import com.example.kmarket.entity.KmAdminNoticeEntity;
import com.example.kmarket.repository.KmAdminCsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@RequiredArgsConstructor
@Service
public class KmAdminCsService {

    private final KmAdminCsRepository kmAdminCsRepository;

    public PageResponseDTO findByCate(PageRequestDTO pageRequestDTO) {


        /*

        Page<KmAdminNoticeEntity> result = kmAdminCsRepository.findAll()
        List<KmAdminNoticeDTO> dtoList = result.getContent()
                .stream()
                .map(entity -> modelMapper.map(entity, KmAdminNoticeDTO.class))
                .toList();

         */
        return null;
    }
    }
