package cn.mty.jts.jtsoa.pojo;

public class Base {
    private Integer id;
    private long createTime;
    private long creteaTimeString;

    public long getCreteaTimeString() {
        return creteaTimeString;
    }

    public void setCreteaTimeString(long creteaTimeString) {
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
