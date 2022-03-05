package com.cn.shixun.common;

public class JsGriData {
    private Integer pageSize; // 每页大小，步长，前端传递
    private Integer pageIndex; // 页码，第几页，前端传递
    private Integer offset; // 偏移量，由pageSize和pageIndex计算得到
    private String queryParam; // 查询条件

    public String getQueryParam() {
        return queryParam;
    }

    public void setQueryParam(String queryParam) {
        this.queryParam = queryParam;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset() {
        this.offset = (this.pageIndex - 1) * this.pageSize;
    }
}
