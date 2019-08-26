package com.boss.bes.common.utils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * 该短信接口采用HaoService提供的短信API服务，详细接口信息见  http://www.haoservice.com/docs/17
 * @author Song
 * @date 2019/8/19
 */
public final class MessageUtil {

    /**
     * 聚合数据短信AppKey
     **/
    private static final String APP_KEY="0587b5df665f45b1b6a0cb51f7dc3dd0";

    /**
     *请求url  "http://apis.haoservice.com/sms/sendv2"
     **/
    private static final String URL="http://apis.haoservice.com/sms/sendv2";

    /**
     *请求USER_AGENT
     **/
    private static final String USER_AGENT="Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36";

    /**
     * 模版id
     **/
    private static final String TPL_ID="5225";

    /**
     * 默认字符集
     **/
    private static final String DEF_CHARSET = "UTF-8";

    /**
     * 超时设置
     **/
    private static final int DEF_CONN_TIMEOUT = 30000;
    private static final int DEF_READ_TIMEOUT = 30000;

    /**
     * 发送短信
     * @param phoneNum
     * @param code     可以调用工具类中的GenerateRandomCode产生4位验证码
     */
    public static void mobileQuery(String phoneNum,int code){
        String result = null;
        /**
         * 添加请求参数
         * 接受短信的用户手机号码
         * 申请的短信模板ID，可以根据实际情况修改
         * 设置的模板变量，即随机四位验证码
         * 应用APP_KEY
         */
        Map params = new HashMap();
        params.put("mobile",phoneNum);
        params.put("tpl_id",TPL_ID);
        params.put("tpl_value","#code#="+code);
        params.put("key",APP_KEY);
        try {
            result = net(URL, params, "GET");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param strUrl 请求地址
     * @param params 请求参数
     * @param method 请求方法
     * @return  网络请求字符串
     * @throws Exception
     */
    public static String net(String strUrl, Map params,String method) throws Exception {
        HttpURLConnection conn = null;
        BufferedReader reader = null;
        String rs = null;
        try {
            StringBuffer sb = new StringBuffer();
            if(method==null || "GET".equals(method)){
                strUrl = strUrl+"?"+urlencode(params);
            }
            java.net.URL url = new URL(strUrl);
            conn = (HttpURLConnection) url.openConnection();
            if(method==null || "GET".equals(method)){
                conn.setRequestMethod("GET");
            }else{
                conn.setRequestMethod("POST");
                conn.setDoOutput(true);
            }
            conn.setRequestProperty("User-agent",USER_AGENT);
            conn.setUseCaches(false);
            conn.setConnectTimeout(DEF_CONN_TIMEOUT);
            conn.setReadTimeout(DEF_READ_TIMEOUT);
            conn.setInstanceFollowRedirects(false);
            conn.connect();
            if (params!= null && "POST".equals(method)) {
                try {
                    DataOutputStream out = new DataOutputStream(conn.getOutputStream());
                    out.writeBytes(urlencode(params));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            InputStream is = conn.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is,DEF_CHARSET));
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sb.append(strRead);
            }
            rs = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (conn != null) {
                conn.disconnect();
            }
        }
        return rs;
    }

    /**
     * 将map型转为请求参数型,API请求格式如下
     *   http://apis.haoservice.com/sms/sendv2?mobile=手机号
     *   &tpl_id=2&content=%e3%80%90haoservice%e3%80%91%e6%82%a8%e7%9a%84%e%e6%9c%ac%e7%9f%ad%e4%bf%a1
     *   &key=您申请的APPKEY
     * @param data
     * @return java.lang.String
     **/
    public static String urlencode(Map<String,String> data) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry i : data.entrySet()) {
            try {
                sb.append(i.getKey()).append("=").append(URLEncoder.encode(i.getValue()+"","UTF-8")).append("&");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }


}
