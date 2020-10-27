package com.offcn.Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;
import java.io.File;


public class SendMail03 {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext-mail.xml");
        //创建发送邮件的对象
        JavaMailSenderImpl mailSender =(JavaMailSenderImpl) context.getBean("mailSender");

        MimeMessage mimeMessage = mailSender.createMimeMessage();

        //创建发送邮件的助手类
        try {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,true,"GBK");
            messageHelper.setFrom("kchenqikun@163.com");
            messageHelper.setTo("kchenqikun@163.com");
            messageHelper.setSubject("ceshifujian");
            messageHelper.setText("<h1>hello mail</h1><br><img src='cid:www'>",true);
           messageHelper.addInline("www",new File("C:\\Users\\kchen\\Desktop\\1.jpg"));
            //执行发送邮件
            mailSender.send(mimeMessage);

            System.out.println("发送邮件成功");
        } catch (Exception e) {
            e.printStackTrace();
        }






    }
}
