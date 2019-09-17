package com.boss.bes.common.utils;

/**
 * @author Song
 * @date 2019/8/19 18:33
 */
public final class GenerateRandomCode {

    /**
     * 生成四位登录随机验证码
     * @return int
     **/
    public static int generate(){
        /**
         * Math.random()的取值应该是0-1（事实上取不到0和1）之间的随机小数,
         * 乘以9就是得到0到9之间的数，加上1就是1到10，即（1，10），乘以1000再取整就是(1000,10000)之间的整数
         */
        return (int) ((Math.random() * 9 + 1) * 1000);
    }
}
