package com.example.demo.page;

import java.util.List;

public class PageResult {

    private List<?> data;
    private Integer pageNo;

    private Integer recordsTotal;
    private Integer recordsFiltered;
    private Integer draw;
    private Integer length;

    public PageResult() {
    }

    public PageResult(List<?> data, Integer count, Integer length) {
        this.data = data;
        this.recordsTotal = count;
        this.recordsFiltered = count;
        this.length = length;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(Integer recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public Integer getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(Integer recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public Integer getDraw() {
        return draw;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }
}
