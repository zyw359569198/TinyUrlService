package com.zyw.tinyUrl.mapper;

import com.zyw.tinyUrl.model.TinyUrlMapping;

public interface TinyUrlMappingMapper {
    int deleteByPrimaryKey(String shortUrl);

    int insert(TinyUrlMapping record);

    int insertSelective(TinyUrlMapping record);

    TinyUrlMapping selectByPrimaryKey(String shortUrl);

    int updateByPrimaryKeySelective(TinyUrlMapping record);

    int updateByPrimaryKey(TinyUrlMapping record);
}