package cn.mty.jts.jtsoa.pojo;

import java.math.BigDecimal;

public class ExecutePOJO {

    private Integer userId;
    private Integer opType;
    private Integer amount;
    private String userName;
    private String desc;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getOpType() {
        return opType;
    }

    public void setOpType(Integer opType) {
        this.opType = opType;
    }

    public Integer getAmount() {
        BigDecimal amt = new BigDecimal(amount).multiply(new BigDecimal(100));
        return amt.intValue();
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
