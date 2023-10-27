package com.example.kmarket.util;

import lombok.extern.log4j.Log4j2;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

@Log4j2
@Service
public class FileUtil {

    @Value("${file.dir}")
    private static String realPath;

    public String uploadFile(MultipartFile file) throws Exception {
        String uploadFileName = "";

        UUID uuid = UUID.randomUUID();
        String oName = file.getOriginalFilename();
        String sName = uuid.toString().replace("_", "");
        log.info("처리 전 uuid : " + sName);
        sName += "-" + (oName.replace("-", " "));
        log.info("처리 후 uuid : " + sName);

        String datePath = clacPath(realPath);
        File f = new File(realPath + datePath, sName);
        file.transferTo(f);

        // 업로드 된 확장자
        String formatName
                = oName.substring(oName.lastIndexOf(".") + 1);
        log.info("formatName : " + formatName);

        if(MediaUtils.getMediaType(formatName) != null) {
            // 이미지 파일이면 썸네일 만들어서 보여주기
            uploadFileName = makeThumbnail(realPath, datePath, sName);
        }else {
            // 일반 파일이면 그냥 보여줌
            uploadFileName = makeFileName(realPath, datePath, sName);
        }
        log.info("uploadFileName : " + uploadFileName);
        return uploadFileName;
    }

    // 이미지가 아닌 일반 파일 URL 경로로 변경하여 반환
    private static String makeFileName(String realPath, String datePath, String sName) {
        String fileName = "";
        fileName = datePath + File.separator + sName;
        fileName = fileName.replace(File.separatorChar, '/');
        return fileName;
    }

    // 썸네일 생성 후 URL 경로로 썸네일 이미지 경로 반환
    private static String makeThumbnail(String realPath, String datePath, String sName) throws IOException {
        String name = "";
        // 썸네일 이미지 생성
        File file = new File(realPath + datePath + sName);
        // 지정된 위치의 이미지 정보를 buffer 달아서 반환
        BufferedImage image = ImageIO.read(file);
        
        String thumbnailImage
                = realPath + datePath + File.separator + "s_" + sName;
        String ext
                = sName.substring(sName.lastIndexOf(".") + 1);
        ImageIO.write(image, ext, new File(thumbnailImage));
        
        return name;
    }

    private static String clacPath(String realPath) {
        String datePath = "";
        Calendar cal = Calendar.getInstance();
        String year = File.separator + cal.get(Calendar.YEAR);
        String month = File.separator
                + new DecimalFormat("00")
                    .format(cal.get(Calendar.MONTH) + 1);
        datePath = month + File.separator
                    + new DecimalFormat("00")
                        .format(cal.get(Calendar.DATE));
        log.info("datePath : " + datePath);
        mkDir(realPath, year, month, datePath);
        return datePath;
    }

    private static void mkDir(String realPath, String... path) {
        if(new File(realPath + path[path.length - 1]).exists()) {
            return;
        }

        for(String p : path) {
            String mkDir = realPath + p;
            log.info("mkDir : " + mkDir);
            File file = new File(mkDir);
            if(!file.exists()) {
                file.mkdirs();
            }
        }
    }

    public static boolean deleteFile(String realPath, String fileName) {
        boolean isDeleted = false;

        // 일반 파일 -> 파일 삭제
        // 이미지 파일 -> 원본 + 썸네일 삭제
        String formatName
                = fileName.substring(fileName.lastIndexOf(".") + 1);
        fileName = fileName.replace(File.separatorChar, '/');

        // 일반 파일 or 썸네일 이미지 삭제
        isDeleted = new File(realPath + fileName).delete();

        if(MediaUtils.getMediaType(formatName) != null) {
            // 이미지 파일이면 원본 파일도 삭제
            fileName = fileName.replace("s_", "");
            isDeleted = new File(realPath + fileName).delete();
        }
        return isDeleted;
    }
    
    // 요청한 파일 정보를 byte[]로 반환
    public static byte[] getBytes(String realPath, String fileName) throws IOException {
        File file = new File(realPath + fileName);
        InputStream is = new FileInputStream(file);
        
        // IOUtils : commons-fileupload 라이브러리 이용
        return IOUtils.toByteArray(is);
    }

    // 다운로드 파일 header 정보(MIME type)
    public static HttpHeaders getMIMEtype(String fileName) throws IOException {
        HttpHeaders header = new HttpHeaders();

        // octet-stream : 8bit -> 1byte 단위의 이진 데이터를 의미
        // header.add("Content-Type", "application/octet-stream"); 이거 해주는거임
        header.setContentType(MediaType.APPLICATION_OCTET_STREAM);

        // 원본 파일 이름
        fileName = fileName.substring(fileName.lastIndexOf("_") + 1);
        
        // content-diposition : 부가 정보 
        // 브라우저 마다 환경이 다운로드시 인코딩이 다른데 크롬일 경우 셋팅은 이럼
        // 그냥 전달하면 인코딩이 ISO임
        header.add("content-disposition", 
                "attachment;fileName=\"" +
                new String(fileName.getBytes("UTF-8"), 
                        "ISO-8859-1") +"\"");

        return header;
    }
}
