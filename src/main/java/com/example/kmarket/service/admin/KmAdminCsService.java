package com.example.kmarket.service.admin;

import com.example.kmarket.dto.PageRequestDTO;
import com.example.kmarket.dto.PageResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class KmAdminCsService {

    private final KmAdminCsService kmAdminCsRepository;

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
