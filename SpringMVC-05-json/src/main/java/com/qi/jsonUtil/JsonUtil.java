package com.qi.jsonUtil;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.SimpleDateFormat;
import java.util.Date;

public class JsonUtil {
    /**
     * 得到json字符串,并且定义好了时间格式为 yyyy-MM-dd HH:mm:ss
     * @param obj
     * @return
     * @throws JsonProcessingException
     */
    public static String getJson(Object obj) throws JsonProcessingException {
        return getJson(obj,"yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 自定义json字符串,格式需要自己来定义.
     * @param obj
     * @param dateFormat
     * @return
     * @throws JsonProcessingException
     */
    public static String getJson(Object obj,String dateFormat) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);
        mapper.setDateFormat(new SimpleDateFormat(dateFormat));
        return mapper.writeValueAsString(new Date());
    }
}
