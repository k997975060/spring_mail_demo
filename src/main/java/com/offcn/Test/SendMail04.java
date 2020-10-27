package com.offcn.Test;

import org.apache.commons.io.IOUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.FileInputStream;


public class SendMail04 {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext-mail.xml");
        //创建发送邮件的对象
        JavaMailSenderImpl mailSender = (JavaMailSenderImpl) context.getBean("mailSender");

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        //创建发送邮件的助手类
        try {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, "GBK");
            messageHelper.setFrom("kchenqikun@163.com");
            messageHelper.setTo("kchenqikun@163.com");
            messageHelper.setSubject("ceshimuban");

            String html = IOUtils.toString(new FileInputStream("C:\\Users\\kchen\\Desktop\\test.html"), "UTF-8");

            messageHelper.setText(html, true);

            messageHelper.addInline("aaa",new File("C:\\Users\\kchen\\Desktop\\3.jpg"));
            //执行发送邮件
            mailSender.send(mimeMessage);

            System.out.println("发送邮件成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
