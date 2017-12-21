package cn.mty.jts.jtsoa.pojo;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class TotalAccount extends Base{
    private long account;
    private String bAccount;

    public String getbAccount() {
        DecimalFormat df2 =new DecimalFormat("#.00");
        return df2.format(new BigDecimal(account).divide(new BigDecimal(100)));
    }

    public void setbAccount(String bAccount) {
        this.bAccount = bAccount;
    }

    public long getAccount() {
        return account;
    }

    public void setAccount(long account) {
        this.account = account;
    }
}
