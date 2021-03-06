package com.boss.bes.common.utils;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import com.boss.bes.common.utils.constants.CommonCacheConstants;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;

/**
 * @author likang
 * @date 2019/8/15 14:52
 */
public class TokenUtil {

    /**
     * 从request里面解密出放入JWT_token的自定义集合数据
     * JWT_token中的数据暂时只存入了用户ID
     * @return Map<String,String> OR null
     */
    public static Map<String,String> getCommonParamsFromToken(){
        Map<String,String> stringMap = null;
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (requestAttributes != null){
            HttpServletRequest request = requestAttributes.getRequest();
            String token = request.getHeader(CommonCacheConstants.REQUEST_TOKEN);
            if (StrUtil.isNotEmpty(token)) {
                stringMap = JwtUtil.verifyToken(token);
            }
        }
        return stringMap;
    }

    /**
     * 从request中获取token中封装的数据
     * @param request request
     * @return Map<String,String> OR null
     */
    public static Map<String,String> getCommonParamsFromToken(HttpServletRequest request){
        Map<String,String> stringMap = null;
        String token = request.getHeader(CommonCacheConstants.REQUEST_TOKEN);
        if (StrUtil.isNotEmpty(token)) {
            stringMap = JwtUtil.verifyToken(token);
        }
        return stringMap;
    }

    /**
     * 获取每个用户在redis里面缓存的公用数据
     * @param userId 用户编号，redis里面的Key
     * @param stringRedisTemplate RedisTemplate处理字符串的类
     * @return JSONObject OR null
     */
    public static JSONObject getCommonParamsFromRedis(String userId, StringRedisTemplate stringRedisTemplate){
        String data = stringRedisTemplate.opsForValue().get(userId);
        return StrUtil.isNotEmpty(data)?JSON.parseObject(data):null;
    }

    /**
     * 获取request的body
     * @param request  request
     * @return String
     * @throws IOException IOException
     */
    public static String getRequestBody(HttpServletRequest request) throws IOException {
        BufferedReader br = request.getReader();
        String str = "";
        StringBuilder listString = new StringBuilder();
        while ((str = br.readLine()) != null) {
            listString.append(str);
        }
        return listString.toString();
    }

    /**
     * 获取公用缓存中的数据
     * @param request 请求，用于获取token
     * @param stringRedisTemplate redis
     * @return JSONObject OR null
     */
    public static JSONObject getUserCommonCache(HttpServletRequest request, StringRedisTemplate stringRedisTemplate){
        String token = request.getHeader(CommonCacheConstants.REQUEST_TOKEN);
        if (StrUtil.isNotEmpty(token)) {
            Map<String, String> map = JwtUtil.verifyToken(token);
            return getCommonParamsFromRedis(map.get(CommonCacheConstants.USER_ID), stringRedisTemplate);
        }else{
            return null;
        }
    }

    /**
     * 获取JSONObject从request和Redis
     * @return JSONObject OR null
     */
    public static JSONObject getJsonObject(StringRedisTemplate stringRedisTemplate) throws IOException {
        Map<String, String> commonParamsFromToken = TokenUtil.getCommonParamsFromToken();
        if (commonParamsFromToken!=null){
            String userId = commonParamsFromToken.get(CommonCacheConstants.USER_ID);
            if (StrUtil.isNotEmpty(userId)) {
                return TokenUtil.getCommonParamsFromRedis(userId, stringRedisTemplate);
            }
        }
        return null;
    }
}
