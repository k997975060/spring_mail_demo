package com.offcn.Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;
import java.io.File;


public class SendMail02 {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext-mail.xml");
        //创建发送邮件的对象
        JavaMailSenderImpl mailSender =(JavaMailSenderImpl) context.getBean("mailSender");

        MimeMessage mimeMessage = mailSender.createMimeMessage();

        //创建发送邮件的助手类
        try {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,true);
            messageHelper.setFrom("kchenqikun@163.com");
            messageHelper.setTo("kchenqikun@163.com");
            messageHelper.setSubject("suibianshishi");
            messageHelper.setText("hello mail");

            File file1 = new File("C:\\Users\\kchen\\Desktop\\1.jpg");
            File file2 = new File("C:\\Users\\kchen\\Desktop\\2.txt");

            messageHelper.addAttachment("test1.jpg",file1);
            messageHelper.addAttachment("test2.txt",file2);


            //执行发送邮件
            mailSender.send(mimeMessage);

            System.out.println("发送邮件成功");
        } catch (Exception e) {
            e.printStackTrace();
        }






    }
}
