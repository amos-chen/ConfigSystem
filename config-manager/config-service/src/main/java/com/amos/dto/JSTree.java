package com.amos.dto;

import java.util.List;

/**
 * Created by ${chenlunwei} on 2018/4/11.
 */
public class JSTree {

    private String id;

    private String text;

    private String icon;

    private boolean hasChild;

    private List<JSTree> children;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<JSTree> getChildren() {
        return children;
    }

    public void setChildren(List<JSTree> children) {
        this.children = children;
    }

    public boolean isHasChild() {
        return hasChild;
    }

    public void setHasChild(boolean hasChild) {
        this.hasChild = hasChild;
    }

    public JSTree(String id, String text, String icon, List<JSTree> children) {
        this.id = id;
        this.text = text;
        this.icon = icon;
        this.children = children;
    }

    public JSTree(String id, String text, String icon, boolean hasChild) {
        this.id = id;
        this.text = text;
        this.icon = icon;
        this.hasChild = hasChild;
    }

    @Override
    public String toString() {
        return "JSTree{" +
                "id='" + id + '\'' +
                ", text='" + text + '\'' +
                ", icon='" + icon + '\'' +
                ", state=" + children +
                '}';
    }
}

