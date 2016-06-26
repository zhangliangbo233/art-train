package com.suning.arttrain.dto;


import java.util.List;

/**
 * 菜单信息实体
 * @author zhanglb
 *
 */
public class MenuInfoChild {

    private long id;

    /**
     * 菜单名称
     */
    private String  text;


    /**
     * 是否展开 默认是open
     */
    private String state;

    private MenuInfoAttribute attributes;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public MenuInfoAttribute getAttributes() {
        return attributes;
    }

    public void setAttributes(MenuInfoAttribute attributes) {
        this.attributes = attributes;
    }

}
