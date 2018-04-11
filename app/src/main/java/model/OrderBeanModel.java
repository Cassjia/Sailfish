package model;

import java.math.BigDecimal;

public class OrderBeanModel {
    public String orderStatusTo(String status) {
        if (status.equals("待备货,已支付,已售后") || status.equals("已签收,已支付,已售后")
                || status.equals("已发货,已支付,已售后")) {

            return "已售后";
        } else if (status.equals("已签收,已支付,部分售后") || status.equals("待备货,已支付," +
                "部分售后")
                || status.equals("已发货,已支付,部分售后")) {

            return "部分售后";
        } else {
            return status;
        }
    }

    public String orderPriceTo(String amt,String coun){
        BigDecimal productAmt = new BigDecimal(amt);
        BigDecimal couponPay = new BigDecimal(coun);
        return "￥"+ productAmt.subtract(couponPay).toString();
    }
}
