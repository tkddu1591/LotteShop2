package com.example.kmarket.service.admin;

import com.example.kmarket.dto.product.KmProductDTO;
import com.example.kmarket.mapper.admin.KmAdminRegisterMapper;
import com.example.kmarket.mapper.product.KmProductMapper;
import com.example.kmarket.repository.product.KmProductRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;


@Log4j2
@Service
public class KmAdminRegisterService {

    @Autowired
    KmAdminRegisterMapper kmAdminRegisterMapper;
    @Autowired
    KmProductMapper kmProductMapper;
    @Autowired
    KmProductRepository kmProductRepository;

    public void insertProduct(KmProductDTO dto) {

        // 파일 업로드
        List<String> saveNames = fileUpload(dto);
        dto.setScore(0);
        if (dto.getSeller() == null)
            dto.setSeller("seller2");
        dto.setThumb1(saveNames.get(0));
        dto.setThumb2(saveNames.get(1));
        dto.setThumb3(saveNames.get(2));
        dto.setDetail(saveNames.get(3));
        dto.setRdate(LocalDateTime.now());
        log.info(dto.toString());

        kmProductRepository.save(kmProductMapper.toEntity(dto));
    }

    public KmProductDTO selectProduct(int prodNo) {
        return kmAdminRegisterMapper.selectProduct(prodNo);
    }

    public List<KmProductDTO> selectProducts() {
        return kmAdminRegisterMapper.selectProducts();
    }

    public int updateProduct(KmProductDTO dto) {
        return kmAdminRegisterMapper.updateProduct(dto);
    }

    public int deleteProduct(int prodNo) {
        return kmAdminRegisterMapper.deleteProduct(prodNo);

    }

    @Value("${thumb.dir}")
    private String filePath;

    public List<String> fileUpload(KmProductDTO dto) {
        String filePathCopy = filePath +dto.getProdCate1() + "/" + dto.getProdCate2() + "/";
        // 파일 첨부 경로
        String path = new File(filePathCopy).getAbsolutePath();
        log.info("fileUpload...3 : " + path);


        // 첨부파일 리스트화
        List<MultipartFile> files = Arrays.asList(
                dto.getFileThumb1(),
                dto.getFileThumb2(),
                dto.getFileThumb3(),
                dto.getFileDetail()
        );

        List<String> saveNames = new ArrayList<>();

        for (MultipartFile file : files) {
            // 파일명 변경
            String oName = file.getOriginalFilename();
            String ext = oName.substring(oName.lastIndexOf("."));
            String sName = UUID.randomUUID().toString() + ext;
            log.info("fileUpload...4 : " + oName);
            saveNames.add(dto.getProdCate1() + "/" + dto.getProdCate2() + "/" + sName);

            try {
                log.info("fileUpload...5");
                // 업로드 파일에 saveFile이라는 껍데기 입힘
                File f = new File(path, sName);
                if (!f.exists()) {
                    f.mkdirs();
                }
                log.info(f);
                file.transferTo(f); // 저장할 폴더 이름, 저장할 파일 이름

                log.info("fileUpload...6");
            } catch (IOException e) {
                log.error(e.getMessage());
            }
            log.info("fileUpload...7");
        }
        return saveNames;
    }

}
