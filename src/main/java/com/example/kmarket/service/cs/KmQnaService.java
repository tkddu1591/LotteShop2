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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

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
            // TODO 나중에 여기서 Uid 오솔라이즈 잡아서 처리 해주는 로직 달기
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


    /*public KmCsFileDTO fileUpload(MultipartFile[] uploadFiles){

        String uploadFolder = "C:\\Temp";

        File uploadPath = new File(uploadFolder, getFolder());
        log.info("upload path : "+uploadPath);

        if(!uploadPath.exists()) {
            uploadPath.mkdirs();
        }

        for(MultipartFile file : uploadFiles) {
            log.info("===============================");
            log.info("Upload File Name : " + file.getOriginalFilename());
            log.info("Upload File Size : " + file.getSize());

            String uploadFileName = file.getOriginalFilename();

            uploadFileName = uploadFileName
                    .substring(uploadFileName.lastIndexOf("\\") + 1);
            log.info("upload File Name : " + uploadFileName);

            UUID uuid = UUID.randomUUID();
            uploadFileName = uuid.toString() + "_" + uploadFileName;
            log.info("uuid File Name : " + uploadFileName);

            File saveFile = new File(uploadPath, uploadFileName);

            try{
                file.transferTo(saveFile);
            }catch (Exception e) {
                log.error(e.getMessage());
            }
        }

        return null;
    }

    private String getFolder() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String str = formatter.format(date);

        // File.separator - UNIX에서는 `:`, windows에서는 `;`
        return str.replace("-", File.separator);

    }*/

    public void save(KmCsQnaDTO dto){
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
