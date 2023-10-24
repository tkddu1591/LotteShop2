package com.example.kmarket.service.admin;

import com.example.kmarket.dto.product.KmProductDTO;
import com.example.kmarket.mapper.admin.KmAdminRegisterMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;


@Log4j2
@Service
public class KmAdminRegisterService {

    @Autowired
    KmAdminRegisterMapper  kmAdminRegisterMapper;

    public int insertProduct(KmProductDTO dto) {

        // 파일 업로드
        List<String> saveNames = fileUpload(dto);

        dto.setThumb1(saveNames.get(0));
        dto.setThumb2(saveNames.get(1));
        dto.setThumb3(saveNames.get(2));
        dto.setDetail(saveNames.get(3));

        return kmAdminRegisterMapper.insertProduct(dto);
    }

    public KmProductDTO selectProduct(int prodNo) {
        return kmAdminRegisterMapper.selectProduct(prodNo);
    }

    public List<KmProductDTO> selectProducts(){
        return kmAdminRegisterMapper.selectProducts();
    }
    public int updateProduct(KmProductDTO dto){
        return kmAdminRegisterMapper.updateProduct(dto);
    }
    public int deleteProduct(int prodNo){
        return kmAdminRegisterMapper.deleteProduct(prodNo);

    }

    @Value("${spring.servlet.multipart.location}")
    private String filePath;

    public List<String> fileUpload(KmProductDTO dto) {
        filePath += dto.getProdCate1() + "/" + dto.getProdCate2() + "/";
        // 파일 첨부 경로
        String path = new File(filePath).getAbsolutePath();
        log.info("fileUpload...3 : " + path);

        // 첨부파일 리스트화
        List<MultipartFile> files = Arrays.asList(
                dto.getFileThumb1(),
                dto.getFileThumb2(),
                dto.getFileThumb3(),
                dto.getFileDetail()
        );

        List<String> saveNames = new ArrayList<>();

        for (MultipartFile file:files) {
            // 파일명 변경
            String oName = file.getOriginalFilename();
            String ext = oName.substring(oName.lastIndexOf("."));
            String sName = UUID.randomUUID().toString() + ext;
            log.info("fileUpload...4 : " + oName);
            saveNames.add(sName);

            try {
                log.info("fileUpload...5");
                // 업로드 파일에 saveFile이라는 껍데기 입힘
                file.transferTo(new File(path, sName)); // 저장할 폴더 이름, 저장할 파일 이름
                log.info("fileUpload...6");
            } catch (IOException e) {
                log.error(e.getMessage());
            }
            log.info("fileUpload...7");
        }
        return saveNames;
    }

}
