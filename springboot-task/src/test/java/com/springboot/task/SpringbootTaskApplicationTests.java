package com.springboot.task;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootTaskApplicationTests {

    @Autowired
    JavaMailSenderImpl mailSender;
    @Test
    public void contextLoads() {
        //发送简单的邮件
        SimpleMailMessage message = new SimpleMailMessage();
        //设置邮件
        message.setSubject("开会");  //邮件标题
        message.setText("今晚七点开会，地点厚德楼");//邮件内容
        message.setTo("18877545427@163.com");//接收邮件对象
        message.setFrom("1558095899@qq.com");//发送者
       mailSender.send(message);
    }

    //发送复杂的邮件 如有附件
    @Test
    public void test() throws Exception{
        //创建复杂邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        //设置邮件
        helper.setSubject("开会");  //邮件标题
        helper.setText("今晚七点开会，地点厚德楼",true);//邮件内容
        helper.setTo("18877545427@163.com");//接收邮件对象
        helper.setFrom("1558095899@qq.com");//发送者
        //上传文件                              文件名         文件
        helper.addAttachment("2.png",new File("C:\\Users\\18877545427\\Pictures\\Saved Pictures\\oo\\2.png"));
        mailSender.send(mimeMessage);
    }
}
