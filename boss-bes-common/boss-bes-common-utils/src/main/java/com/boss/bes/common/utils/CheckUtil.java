package com.boss.bes.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 提供一些对象有效性校验的方法
 * @author Song
 * @date 2019/8/13 17:38
 */
public final class CheckUtil {

    /**
     * 判断字符串是否是符合指定格式的时间
     *
     * @param date   时间字符串
     * @param format 时间格式
     * @return 是否符合
     */
    public final static boolean isDate(String date, String format) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            sdf.parse(date);
            return true;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 判断字符串有效性
     */
    public final static boolean valid(String src) {
        return !(src == null || "".equals(src.trim()));
    }

    /**
     * 判断一组字符串是否有效
     *
     * @param src
     * @return
     */
    public final static boolean valid(String... src) {
        for (String s : src) {
            if (!valid(s)) {
                return false;
            }
        }
        return true;
    }


    /**
     * 判断一个对象是否为空
     */
    public final static boolean valid(Object obj) {
        if(obj == null){
            return false;
        }else {
            return true;
        }
    }

    /**
     * 判断一组对象是否有效
     *
     * @param objs
     * @return
     */
    public final static boolean valid(Object... objs) {
        if (objs != null && objs.length != 0) {
            return true;
        }
        return false;
    }

    /**
     * 判断集合的有效性
     */
    public final static boolean valid(Collection col) {
        return !(col == null || col.isEmpty());
    }

    /**
     * 判断一组集合是否有效
     *
     * @param cols
     * @return
     */
    public final static boolean valid(Collection... cols) {
        for (Collection c : cols) {
            if (!valid(c)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断map是否有效
     *
     * @param map
     * @return
     */
    public final static boolean valid(Map map) {
        return !(map == null || map.isEmpty());
    }

    /**
     * 判断一组map是否有效
     *
     * @param maps 需要判断map
     * @return 是否全部有效
     */
    public final static boolean valid(Map... maps) {
        for (Map m : maps) {
            if (!valid(m)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 使用正则表达式校验手机号码
     * @param telNum
     * @return boolean
     **/
    public static boolean isMobileNum(String telNum){
        String regex = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(telNum);
        return m.matches();
    }
}
