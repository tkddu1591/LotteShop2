package com.example.kmarket.util;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class MaskingUid {

    public String maskingUid(String writer) {
        StringBuilder maskingUid = new StringBuilder(writer);
        int length = writer.length();
        if (length > 1) {
            for (int i = 1; i < Math.max(2, length - 1); i++) {
                maskingUid.setCharAt(i, '*');
            }
        }
        return maskingUid.toString();
    }
}
