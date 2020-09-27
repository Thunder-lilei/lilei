package com.lilei.cn.util;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class emailtest {
    public static void main(String[] args) {
        String msg="请与我联系！"+"15149039299@163.com";
        emailtest.sendMailMessage(msg);
    }
     /**
       * 发送邮件实现类
       * @param msg
       */
    public static void sendMailMessage(String msg) {
        try {
            //邮箱服务器地址如：mail.qq.com
            String hostName ="smtp.163.com";
            // 帐号与密码
            String userName ="15149039299@163.com";
            String password = "OUEMSBDJJXPRGUEX";
            // 发件人
            String fromAddress ="15149039299@163.com";
            // 发件人姓名
            String fromName = "游客";
            HtmlEmail email=new HtmlEmail();
            email.setHostName(hostName);// 设置smtp服务器
            email.setAuthentication(userName, password);// 设置授权信息
            email.setCharset("utf-8");
            email.setFrom(fromAddress, fromName, "utf-8");// 设置发件人信息
            email.setSubject("lilei-connect");// 设置主题
            email.setHtmlMsg(msg);// 设置邮件内容
            email.addTo("2586136016@qq.com", "lilei", "utf-8");
            System.err.println(email.getSmtpPort());
            System.err.println(email.getHostName());
            String res = email.send();// 发送邮件
            System.err.println(res);
        } catch (EmailException e) {
            System.err.println("邮件发送失败");
            e.printStackTrace();
        }
    }
}