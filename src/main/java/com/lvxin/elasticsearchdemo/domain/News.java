package com.lvxin.elasticsearchdemo.domain;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by lvxin
 */
//新闻实体
public class News {

    @JSONField(name="标题")
    private String title;

    @JSONField(name = "内容")
    private String content;

    @JSONField(name = "作者")
    private String author;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public News(String title, String content, String author) {

        this.title = title;
        this.content = content;
        this.author = author;
    }

//    @Override
//    public String toString() {
//        final StringBuffer sb = new StringBuffer("{");
//        sb.append("\"title\":\"").append(title).append('\"');
//        sb.append(", \"content\":\"").append(content).append('\"');
//        sb.append(", \"author\":\"").append(author).append('\"');
//        sb.append('}');
//        return sb.toString();
//    }

}
