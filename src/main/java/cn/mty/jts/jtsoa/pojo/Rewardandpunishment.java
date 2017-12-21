package cn.mty.jts.jtsoa.pojo;

public class Rewardandpunishment extends Base {
    private long userId;
    private long bonus;
    private long balance;
    private Integer rptype;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getBonus() {
        return bonus;
    }

    public void setBonus(long bonus) {
        this.bonus = bonus;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public Integer getRptype() {
        return rptype;
    }

    public void setRptype(Integer rptype) {
        this.rptype = rptype;
    }
}
