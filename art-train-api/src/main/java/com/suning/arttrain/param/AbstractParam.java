package com.suning.arttrain.param;


import com.suning.arttrain.common.util.Page;

public abstract class AbstractParam{

    /**
     * 分页查询对象
     */
    private Page pg;

    public Page getPg() {
        return pg;
    }

    public void setPg(Page pg) {
        this.pg = pg;
    }
}
