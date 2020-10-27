package com.offcn.Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;


public class SendMail01 {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext-mail.xml");
        //创建发送邮件的对象
        JavaMailSenderImpl mailSender =(JavaMailSenderImpl) context.getBean("mailSender");

        //创建邮件对象
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        //发送邮件的用户名
        mailMessage.setFrom("kchenqikun@163.com");
        //接收邮件的用户名
        mailMessage.setTo("kchenqikun@163.com");
        //发送邮件的主题
        mailMessage.setSubject("suibianshishi");
        //发送邮件的内容
        mailMessage.setText("hello mail");

        //执行发送邮件
        mailSender.send(mailMessage);

        System.out.println("发送邮件成功");
    }
}
