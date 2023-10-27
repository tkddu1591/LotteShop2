package com.example.kmarket.util;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MediaUtils {

    private static Map<String, MediaType> mediaMap;

    // 클래스 정보가 등록이 되고 나면 즉시 실행 됨
    static {
        mediaMap = new HashMap<>();
        mediaMap.put("JPG", MediaType.IMAGE_JPEG); // == JGP, image/jpeg
        mediaMap.put("JPEG", MediaType.IMAGE_JPEG);
        mediaMap.put("GIF", MediaType.IMAGE_GIF);
        mediaMap.put("PNG", MediaType.IMAGE_PNG);
    }

    // 확장자 명을 전달 받아 동일한 이름의 Media Type이 존재하는지 확인 후 반환
    public static MediaType getMediaType(String ext) {
        return mediaMap.get(ext.toUpperCase());
    }
}
