package com.example.kmarket.service.cs;

import com.example.kmarket.dto.PageRequestDTO;
import com.example.kmarket.dto.PageResponseDTO;
import com.example.kmarket.dto.cs.KmCsQnaDTO;
import com.example.kmarket.dto.cs.CsPageRequestDTO;
import com.example.kmarket.dto.cs.CsPageResponseDTO;
import com.example.kmarket.dto.member.KmMemberPointDTO;
import com.example.kmarket.entity.cs.KmCsCateEntity;
import com.example.kmarket.entity.cs.KmCsQnaEntity;
import com.example.kmarket.entity.member.KmMemberPointEntity;
import com.example.kmarket.mapper.cs.KmCsQnaMapper;
import com.example.kmarket.mapper.cs.MybatisCSMapper;
import com.example.kmarket.repository.cs.KmCsQnaRepository;
import com.example.kmarket.util.Util;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2

public class KmQnaService {

    private final KmCsQnaRepository kmCsQnaRepository;
    private final KmCsQnaMapper kmCsQnaMapper;
    private final Util util;
    private final MybatisCSMapper mybatisCsMapper;

    public CsPageResponseDTO findByCate(CsPageRequestDTO csPageRequestDTO) {
        Pageable pageable = csPageRequestDTO.getPageable("qnaNo");
        Page<KmCsQnaEntity> result
            = kmCsQnaRepository.findByKmCsCateEntity_Cate(csPageRequestDTO.getCate(), pageable);

        List<KmCsQnaDTO> qnaList
                = result.getContent()
                    .stream()
                    .map(kmCsQnaMapper::toDTO)
                    .toList();
        int total = (int) result.getTotalElements();

        for(KmCsQnaDTO qna : qnaList) {
            // TODO 나중에 여기서 Uid 오솔라이즈 잡아서 처리 해주는 로직 달기
            qna.setWriter(util.maskingUid(qna.getWriter()));
        }
        log.info(qnaList.toString());

        return CsPageResponseDTO.builder()
                .qnaList(qnaList)
                .csPageRequestDTO(csPageRequestDTO)
                .total(total)
                .build();
    }

    public List<KmCsCateEntity> findByTypeLessThan(int type){
        log.info("!!!!!!!!!!!!!!!!!!!!!!" + type);
        List<KmCsCateEntity> cateList
                = mybatisCsMapper.findTypeForCate(type);
//        log.info("@@@@@@@@@@@@@@@@@"+cateList.toString());

        return cateList;
    }

    public void save(KmCsQnaDTO dto){
        log.info(dto.toString());
        KmCsQnaEntity entity = kmCsQnaMapper.toEntity(dto);
        log.info("qna service save entity : " + entity);
        log.info(entity.getKmCsCateEntity());
        log.info(entity.getKmCsTypeEntity());
        kmCsQnaRepository.save(entity);
    }

    public PageResponseDTO findByWriter(PageRequestDTO pageRequestDTO){
        //Order By 정렬할 컬럼명 Desc
        //getPageableDesc 내림차순 getPageableAsc 오름차순 ("정렬할 컬럼명")
        //pg , size 가공해서 같이 ordet by랑 섞어줌
        Pageable pageable = pageRequestDTO.getPageableDesc("qnaNo");

        //Page
        Page<KmCsQnaEntity> result = null;
        //dtoList
        //findBy머시기 by뒤가 where절이라고 보면 됨니다.
        result = kmCsQnaRepository.findByWriter(pageRequestDTO.getMemberUid(), pageable);

        result.getContent(); // Entity
        result.getTotalElements(); // 숫자 형이 double -> int변경해줘야함

        // content를 dto로 변환 해주는 역할
        List<KmCsQnaDTO> dtoList = result.getContent()
                .stream()
                .map(kmCsQnaMapper::toDTO)
                .toList();

        int totalElement = (int) result.getTotalElements();

        return PageResponseDTO.builder()
                .pageRequestDTO(pageRequestDTO)
                .qnaDTOS(dtoList)
                .total(totalElement)
                .build();
    }

    public int countByUid(String memberUid) {
        return kmCsQnaRepository.countByWriterAndAnswerCompleteBetween(memberUid, 0, 1);
    }
}
