package com.zyw.tinyUrl.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zyw.tinyUrl.service.TinyUrlService;
import com.zyw.utils.Base64;

@RestController
@RequestMapping("/")
public class TinyUrlController {
	
	public static final  Logger logger=LoggerFactory.getLogger(TinyUrlController.class);
	
	@Autowired
	private TinyUrlService tinyUrlService;
	
	/**
	 * 访问短链并计数
	 * @param request
	 * @param response
	 * @param url
	 */
	@RequestMapping(value="/s/{url}",method= {RequestMethod.GET},produces = {"application/json;charset=UTF-8"})
	public void tinyUrlQuery(HttpServletRequest request,HttpServletResponse response,@PathVariable String url) {
		String result="";
		try {
			result=tinyUrlService.tinyUrlConvert("02", url);
		}catch(Exception e){
			e.printStackTrace();
		}
		try {
			response.sendRedirect(Base64.decode(result, "utf-8"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 长链转短链
	 * @param request
	 * @param response
	 * @param type
	 * @param url
	 * @return
	 */
	@RequestMapping(value="/tinyUrlConvert/{url}",method= {RequestMethod.GET},produces = {"application/json;charset=UTF-8"})
	public Map tinyUrlConvert(HttpServletRequest request,HttpServletResponse response,@PathVariable String url) {
		Map resultMap=new HashMap();
		Map dataMap=new HashMap();
		String result="";
		try {
			result=tinyUrlService.tinyUrlConvert("01", url);
			dataMap.put("url", result);
		}catch(Exception e){
			e.printStackTrace();
			resultMap.put("errorCode", 10086);
		}
		resultMap.put("data", dataMap);
		resultMap.put("errorCode", 200);
		return resultMap;
		
	}

}
