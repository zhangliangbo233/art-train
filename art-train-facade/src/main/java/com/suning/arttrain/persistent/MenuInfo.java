package com.suning.arttrain.persistent;


import com.suning.arttrain.dto.MenuInfoAttribute;
import com.suning.arttrain.dto.MenuInfoChild;

import java.security.SecureRandom;
import java.util.Date;
import java.util.List;

/**
 * 菜单信息实体
 * @author zhanglb
 *
 */
public class MenuInfo {

	private long id;

    /**
     * 菜单名称
     */
    private String  text;

	/**
	 * 上级菜单id
	 */
	private String  parentId;

    /**
     * 是否正常在用 0:否 1：是
     */
    private int isDelete;

    /**
     * 是否展开 默认是closed
     */
    private String state;

    /**
     * 图标
     */
    private String iconCls;

    private List<MenuInfoChild> children;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public String getText() {
        return text;

    }

    public void setText(String text) {
        this.text = text;
    }

    public List<MenuInfoChild> getChildren() {
        return children;
    }

    public void setChildren(List<MenuInfoChild> children) {
        this.children = children;
    }
}
