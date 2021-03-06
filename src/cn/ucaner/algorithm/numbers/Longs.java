/**
 * <html>
 * <body>
 *  <P> Copyright 1994-2018 JasonInternational </p>
 *  <p> All rights reserved.</p>
 *  <p> Created on 2018年4月10日 上午9:46:32</p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.algorithm.numbers;

import java.math.BigDecimal;

/**
* @Package：cn.ucaner.algorithm.numbers   
* @ClassName：Longs   
* @Description：   <p> Longs </p>
* @Author： - Jason   
* @CreatTime：2018年5月9日 上午9:25:11   
* @Modify By：   
* @ModifyTime：  2018年5月9日
* @Modify marker：   
* @version    V1.0
 */
public class Longs {

    /**
     * toBinaryUsingDivideAndModulus
     * @param numberToConvert
     * @return
     */
    public static final String toBinaryUsingDivideAndModulus(long numberToConvert) {
        long longNumber = numberToConvert;
        if (longNumber<0) {
            throw new IllegalArgumentException("Method argument cannot be negative. number="+longNumber);
        }
        StringBuilder builder = new StringBuilder();
        long temp = 0l;
        while (longNumber > 0) {
            temp = longNumber;
            longNumber = temp / 2;
            builder.append(temp % 2);
        }
        return builder.reverse().toString();
    }

    /**
     * toBinaryUsingShiftsAndModulus
     * @param numberToConvert
     * @return
     */
    public static final String toBinaryUsingShiftsAndModulus(long numberToConvert) {
        long longNumber = numberToConvert;
        if (longNumber<0) {
            throw new IllegalArgumentException("Method argument cannot be negative. number="+longNumber);
        }
        StringBuilder builder = new StringBuilder();
        long temp = 0l;
        while (longNumber > 0) {
            temp = longNumber;
            longNumber = (temp >> 1);
            builder.append(temp % 2);
        }
        return builder.reverse().toString();
    }

    /**
     * toBinaryUsingBigDecimal
     * @param numberToConvert
     * @return
     */
    public static final String toBinaryUsingBigDecimal(long numberToConvert) {
        long longNumber = numberToConvert;
        if (longNumber<0) {
            throw new IllegalArgumentException("Method argument cannot be negative. number="+longNumber);
        }
        StringBuilder builder = new StringBuilder();
        BigDecimal zero = new BigDecimal(0);
        BigDecimal two = new BigDecimal(2);
        BigDecimal number = new BigDecimal(longNumber);
        BigDecimal[] decimals = null;
        while (number.compareTo(zero) > 0) {
            decimals = number.divideAndRemainder(two);
            number = decimals[0];
            builder.append(decimals[1]);
        }
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(toBinaryUsingBigDecimal(10));
        System.out.println(toBinaryUsingShiftsAndModulus(0));
        System.out.println(toBinaryUsingDivideAndModulus(03));
    }
}
