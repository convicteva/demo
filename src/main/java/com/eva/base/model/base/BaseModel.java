package com.eva.base.model.base;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Jamin.Ma on 2017/5/20.
 */
public class BaseModel implements Serializable {

    private long id;

    private String remark;

    private Date createTime;

    private int status;


    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
