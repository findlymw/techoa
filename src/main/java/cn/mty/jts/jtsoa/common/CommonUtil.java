package cn.mty.jts.jtsoa.common;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

public class CommonUtil {
    /**
     * 单位为分的long型数字进行小数点保留两位的元单位的转换，返回字符串
     * @param account
     * @return
     */
    public static String getPriceFormat(long account) {
        DecimalFormat df2 =new DecimalFormat("#.00");
        return df2.format(new BigDecimal(account).divide(new BigDecimal(100)));
    }

    /**
     * 由long型转为时间字符串
     * @param times
     * @return
     */
    public static String timeFormat(long times){
       // SimpleDateFormat dateformat2=new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        SimpleDateFormat dateformat2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateformat2.format(new Timestamp(times));
    }
}
