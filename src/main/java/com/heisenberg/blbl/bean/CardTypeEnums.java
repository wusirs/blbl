package com.heisenberg.blbl.bean;

import java.util.Arrays;

public enum CardTypeEnums {
    CREDIT_CARD(0, "信用卡"),
    DEBIT_CARD(1, "储蓄卡");


    private Integer code;
    private String label;
    CardTypeEnums(Integer code, String label) {
        this.code = code;
        this.label = label;
    }

    public Integer getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }

    public static CardTypeEnums byCode(Integer code){
        return Arrays.stream(values()).filter(t -> t.getCode().equals(code)).findFirst().orElse(CREDIT_CARD);
    }
}
