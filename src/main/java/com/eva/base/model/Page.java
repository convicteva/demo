package com.eva.base.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jamin.Ma on 2017/5/21.
 */
public class Page<T extends Serializable> {

    private int pageNo = 1;

    private int pageSize = 15 ;

    private int offset=0;

    private int count;

    protected List<T> resoult = new ArrayList<T>();

    public List<T> getResoult() {
        return resoult;
    }

    public void setResoult(List<T> resoult) {
        this.resoult = resoult;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
}
