package com.example.kmarket.service.cs;

import com.example.kmarket.dto.PageRequestDTO;
import com.example.kmarket.dto.PageResponseDTO;
import com.example.kmarket.dto.cs.KmCsQnaDTO;
import com.example.kmarket.dto.cs.CsPageRequestDTO;
import com.example.kmarket.dto.cs.CsPageResponseDTO;
import com.example.kmarket.entity.cs.KmCsCateEntity;
import com.example.kmarket.entity.cs.KmCsQnaEntity;
import com.example.kmarket.mapper.cs.KmCsQnaMapper;
import com.example.kmarket.mapper.cs.MybatisCSMapper;
import com.example.kmarket.repository.cs.KmCsQnaRepository;

import com.example.kmarket.util.MaskingUid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Log4j2
public class KmQnaService {

    private final KmCsQnaRepository kmCsQnaRepository;
    private final KmCsQnaMapper kmCsQnaMapper;

    private final MybatisCSMapper mybatisCsMapper;
    private final MaskingUid maskingUid;

    public CsPageResponseDTO findByCate(CsPageRequestDTO csPageRequestDTO) {
        Pageable pageable = csPageRequestDTO.getPageable("qnaNo");
        Page<KmCsQnaEntity> result
            = kmCsQnaRepository.findByKmCsCateEntity_CateOrderByRdateDesc(csPageRequestDTO.getCate(), pageable);

        List<KmCsQnaDTO> qnaList
                = result.getContent()
                    .stream()
                    .map(kmCsQnaMapper::toDTO)
                    .toList();
        int total = (int) result.getTotalElements();

        for(KmCsQnaDTO qna : qnaList) {
            qna.setWriter(maskingUid.maskingUid(qna.getWriter()));
        }
        log.info(qnaList.toString());

        return CsPageResponseDTO.builder()
                .qnaList(qnaList)
                .csPageRequestDTO(csPageRequestDTO)
                .total(total)
                .build();
    }

    // cate로 type 가져오기(type이 90이상은 notice라서 제외)
    public List<KmCsCateEntity> findByTypeLessThan(int type){
        log.info("!!!!!!!!!!!!!!!!!!!!!!" + type);
        List<KmCsCateEntity> cateList
                = mybatisCsMapper.findByTypeLessThan(type);
//        log.info("@@@@@@@@@@@@@@@@@"+cateList.toString());

        return cateList;
    }

    public List<KmCsQnaDTO> indexQnaList(){
        List<KmCsQnaDTO> qnaList = mybatisCsMapper.indexQnaList();
        log.info("@@@@@@@@@@@@@@@@@@@@@@qnaList : " + qnaList);
        for(KmCsQnaDTO qna : qnaList) {
            qna.setWriter(maskingUid.maskingUid(qna.getWriter()));
        }

/*        return qnaList.stream()
                .map(kmCsQnaMapper::toDTO)
                .toList();*/
        return qnaList;
    }

    @Value("${file.dir}")
    private String filePath;

    public List<String> fileUpload(KmCsQnaDTO dto) {
        String filePathCopy = filePath +dto.getCate() + "/" + dto.getType() + "/";
        log.info("++++++++++++++++++++++++++++++++++++++++++++++++");
        log.info("dto : " + dto);
        // 파일 첨부 경로(절대 경로 잡는거임)
        String path = new File(filePathCopy).getAbsolutePath();
        log.info("qna fileUpload path : " + path);


        // 첨부파일 리스트화
        List<MultipartFile> files = Arrays.asList(
                dto.getMFile1()
/*                dto.getFile1(),
                dto.getFile2(),
                dto.getFile3(),
                dto.getFile4()*/
        );
        log.info("files : " + files);

        // 저장된 파일명 리스트 초기화
        List<String> saveNames = new ArrayList<>();

        for (MultipartFile file : files) {
            log.info("여기는 들어오니?");
            // 파일명 변경
            String oName = file.getOriginalFilename();
            String ext = oName.substring(oName.lastIndexOf("."));
            String sName = UUID.randomUUID().toString() + ext;
            log.info("qna fileUpload oName : " + oName);
            saveNames.add(sName);
            saveNames.add(oName);

            try {
                log.info("try 안에 있는 구문");
                // 저장할 폴더 이름, 저장할 파일 명
                File f = new File(path, sName);
                if(!f.exists()){
                    f.mkdirs();
                }
                file.transferTo(f);
                log.info("transferTo 완료");
            } catch (IOException e) {
                log.error("qna fileUpload error :  " + e.getMessage());
            }
        }
        return saveNames;
    }

    public void save(KmCsQnaDTO dto){

        log.info("========================================");
        log.info("save dto : " + dto);
        if (dto.getMFile1() != null
                && !dto.getMFile1().isEmpty()) {
            List<String> saveNames = fileUpload(dto);
            log.info("saveNames : " + saveNames);

            if(saveNames.size() >= 2){
                dto.setFile1(saveNames.get(0));
                dto.setFile2(saveNames.get(1));
            }
        }
        KmCsQnaEntity entity = kmCsQnaMapper.toEntity(dto);

        if(entity.getKmProductOrderItemEntity().getOrderItemId() == 0) {
            entity.setKmProductOrderItemEntity(null);
        }
        log.info("qna service save entity : " + entity);
        log.info(entity.getKmCsCateEntity());
        log.info(entity.getKmCsTypeEntity());
        kmCsQnaRepository.save(entity);
    }

    public KmCsQnaDTO findById(int qnaNo){
        KmCsQnaEntity entity = kmCsQnaRepository.findById(qnaNo).get();
        KmCsQnaDTO dto = kmCsQnaMapper.toDTO(entity);
        dto.setWriter(maskingUid.maskingUid(dto.getWriter()));

        return dto;
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
