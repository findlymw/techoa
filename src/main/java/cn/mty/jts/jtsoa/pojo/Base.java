package cn.mty.jts.jtsoa.pojo;

import cn.mty.jts.jtsoa.common.CommonUtil;

public class Base {
    private Integer id;
    private long createTime;
    private String creteaTimeString;

    public String getCreteaTimeString() {
        return CommonUtil.timeFormat(createTime);
    }

    public void setCreteaTimeString(String creteaTimeString) {
        this.creteaTimeString = creteaTimeString;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }
}
