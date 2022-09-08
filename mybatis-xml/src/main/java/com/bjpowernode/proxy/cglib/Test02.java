package com.bjpowernode.proxy.cglib;

import java.math.BigDecimal;
import java.text.NumberFormat;

/**
 * @program: SSM-SOURCECODE
 * @description:
 * @author: LZ
 * @create: 2022-08-26 13:18
 **/
public class Test02 {
    public static void main(String[] args) {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        NumberFormat percent = NumberFormat.getPercentInstance();  //建立百分比格式化引用
        percent.setMaximumFractionDigits(3); //百分比小数点最多3位

        BigDecimal interestRate = new BigDecimal("0.008"); //利率


        BigDecimal loanAmount = new BigDecimal("15000.48"); //贷款金额
        System.out.println("贷款金额:\t" + currency.format(loanAmount));
        System.out.println("利率:\t" + percent.format(interestRate));

    }
}
