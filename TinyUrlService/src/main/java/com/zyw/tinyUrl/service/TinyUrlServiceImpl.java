package com.zyw.tinyUrl.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyw.tinyUrl.mapper.TinyUrlMappingMapper;
import com.zyw.tinyUrl.model.TinyUrlMapping;

@Service(value="tinyUrlService")
public class TinyUrlServiceImpl implements TinyUrlService{
	
	@Autowired
	private TinyUrlMappingMapper tinyUrlMappingMapper;

	@Override
	public String tinyUrlConvert(String type,String url) {
		TinyUrlMapping record=new TinyUrlMapping();
		String result="";
		if("01".equalsIgnoreCase(type)){
			result=UUID.randomUUID().toString().substring(0, 7);
			record.setShortUrl(result);
			record.setLongUrl(url);
			tinyUrlMappingMapper.insert(record);
		}else if("02".equalsIgnoreCase(type)){
			TinyUrlMapping tum=tinyUrlMappingMapper.selectByPrimaryKey(url);
			result=tum.getLongUrl();
			tum.setTotal(tum.getTotal()==null?0:(tum.getTotal()+1));
			tinyUrlMappingMapper.updateByPrimaryKey(tum);
		}else{
			
		}
		
		return result;
		
	}

}
