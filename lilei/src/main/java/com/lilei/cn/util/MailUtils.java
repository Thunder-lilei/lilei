package com.lilei.cn.util;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

/**
 * JavaMail 版本: 1.6.0
 * JDK 版本: JDK 1.7 以上（必须）
 */
public class MailUtils {
	    public static int sendMailMessage(String name,String msg,String connect_information) {
	        try {
	            //邮箱服务器地址如：mail.qq.com
	            String hostName ="smtp.163.com";
	            // 帐号与密码
	            String userName ="15149039299@163.com";
	            String password = "OUEMSBDJJXPRGUEX";
	            // 发件人
	            String fromAddress ="15149039299@163.com";
	            // 发件人姓名
	            String fromName = name;
	            HtmlEmail email=new HtmlEmail();
	            email.setHostName(hostName);// 设置smtp服务器
	            email.setAuthentication(userName, password);// 设置授权信息
	            email.setCharset("utf-8");
	            email.setFrom(fromAddress, fromName, "utf-8");// 设置发件人信息
	            email.setSubject("lilei-contact");// 设置主题
	            email.setHtmlMsg(msg+" 联系方式："+connect_information);// 设置邮件内容
	            email.setSmtpPort(465);
	            email.setSSLOnConnect(true);
	            email.addTo("2586136016@qq.com", "lilei", "utf-8");
	            System.err.println(email.getSmtpPort());
	            System.err.println(email.getHostName());
	            String res = email.send();// 发送邮件
	            System.err.println(res);
	            return 1;
	        } catch (EmailException e) {
	            System.err.println("邮件发送失败");
	            e.printStackTrace();
	            return 0;
	        }
	    }
}
