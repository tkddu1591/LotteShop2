package com.example.kmarket.service.member;

import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import java.util.Random;

@Service
public class MailService implements EmailService{
    @Autowired
    JavaMailSender emailSender;

    public static String ePw;

    private MimeMessage createMessage(String to)throws Exception{
        ePw= createKey();
        System.out.println("보내는 대상 : "+ to);
        System.out.println("인증 번호 : "+ePw);
        MimeMessage  message = emailSender.createMimeMessage();

        message.addRecipients(MimeMessage.RecipientType.TO, to);//보내는 대상
        message.setSubject("LotteON 이메일 인증");//제목

        String msgg="";
        msgg+= "<div style.css='margin:20px;'>";
        msgg+= "<h1> 안녕하세요 LotteON입니다. </h1>";
        msgg+= "<br>";
        msgg+= "<p>아래 코드를 복사해 입력해주세요<p>";
        msgg+= "<br>";
        msgg+= "<p>감사합니다.<p>";
        msgg+= "<br>";
        msgg+= "<div align='center' style.css='border:1px solid black; font-family:verdana';>";
        msgg+= "<h3 style.css='color:blue;'>회원가입 인증 코드입니다.</h3>";
        msgg+= "<div style.css='font-size:130%'>";
        msgg+= "CODE : <strong>";
        msgg+= ePw+"</strong><div><br/> ";
        msgg+= "</div>";
        message.setText(msgg, "utf-8", "html");//내용
        message.setFrom(new InternetAddress("tkddu1591@gmail.com","tkddu1591@gmail.com"));//보내는 사람

        return message;
    }

    public static String createKey() {
        String tempPassword = "";

        for(int i=0; i<8; i++) {
            int rndVal = (int)(Math.random() * 62);
            if(rndVal < 10) {
                tempPassword += rndVal;
            } else if(rndVal > 35) {
                tempPassword += (char)(rndVal + 61);
            } else {
                tempPassword += (char)(rndVal + 55);
            }
        }
        return tempPassword;
    }
    @Override
    public String sendSimpleMessage(String to)throws Exception {
        // TODO Auto-generated method stub
        MimeMessage message = createMessage(to);
        try{//예외처리
            emailSender.send(message);
        }catch(MailException es){
            es.printStackTrace();
            throw new IllegalArgumentException();
        }
        return ePw;
    }
}