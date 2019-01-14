package com.example.demo.page;

import java.util.HashMap;
import java.util.Map;

public class PageParam {

    private Integer start;
    private Integer length;
    private Integer draw;
    private Map<String, Object> param = new HashMap<String, Object>();

    public PageParam() {
    }


    public PageParam(Integer start) {
        this.start = start;
        this.length = 10;
    }

    public PageParam(Integer start, Integer length) {
        this.start = start;
        this.length = length;
    }

    public void setParam(String name, Object value) {
        param.put(name, value);
    }

    public Map<String, Object> getParam() {
        return param;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getDraw() {
        return draw;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }
}
