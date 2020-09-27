package com.lilei.cn.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lilei.cn.util.MailUtils;



/**
 * @author lilei
 *
 * 2020年9月9日
 */
@Controller
@RequestMapping("/util")
public class UtilController extends BaseController{
	
//	/**
//	 * 获取tel验证码
//	 * @return
//	 * @throws IOException 
//	 */
//	@RequestMapping(value="Telcode",method = RequestMethod.GET)
//	@ResponseBody
//	private Map<String,Object> Telcode(@RequestParam String tel){
//		String skin = "3";//登录
//		response.setCharacterEncoding("utf-8");
//		String code = null;
//		Map<String,Object> modelMap=new HashMap<>();
//		if(tel!=null) 
//		{
//			if(tel.length()==11) 
//			{
//				String sign = "1";//签名
//				code = PhoneCodeUtil.main(tel,skin,sign);
//			}
//		}
//		if(code!=null) 
//		{
//			modelMap.put("message", "验证码发送成功");
//			modelMap.put("code", code);
//		}else 
//		{
//			modelMap.put("message", "验证码发送失败");
//		}
//		
//		return modelMap;
//	}
	/**
	 * 获取email信息
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value="Message",method = RequestMethod.GET)
	@ResponseBody
	private Map<String,Object> Emailcode(@RequestParam String name,@RequestParam String connect_information,@RequestParam String msg){
		response.setCharacterEncoding("utf-8");
		int result = 0;
		Map<String,Object> modelMap=new HashMap<>();
		if(connect_information!=null && name!=null && msg!=null) 
		{
			System.out.println(connect_information);
			System.out.println(name);
			System.out.println(msg);
			result = MailUtils.sendMailMessage(name, msg, connect_information);
		}
		if(result!=0) 
		{
			modelMap.put("message", "信息发送成功");
		}else 
		{
			modelMap.put("message", "信息发送失败");
		}
		
		return modelMap;
	}
}
