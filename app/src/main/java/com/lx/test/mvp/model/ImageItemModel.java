package com.lx.test.mvp.model;

/**
 * @author liuxu@gotokeep.com (Liu Xu)
 */
public class ImageItemModel {

    private String url;
    private String desc;

    public ImageItemModel(String url) {
        this.url = url;
        this.desc = url;
    }

    public ImageItemModel(String url, String desc) {
        this.url = url;
        this.desc = desc;
    }

    public String getUrl() {
        return url;
    }

    public String getDesc() {
        return desc;
    }
}
