package com.lvxin.elasticsearchdemo.domain;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * Created by lvxin
 */
//新闻实体
public class News {

    @JSONField(name="title")
    private String title;

    @JSONField(name = "content")
    private String content;

    @JSONField(name = "author")
    private String author;

    @JSONField(name="pubtime")
    private Date pubtime;

    @JSONField(name="source")
    private String source;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPubtime() {
        return pubtime;
    }

    public void setPubtime(Date pubtime) {
        this.pubtime = pubtime;
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

    public News(String title, String content, String author, Date pubtime, String source) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.pubtime = pubtime;
        this.source = source;
    }

    public void toJson(News news){
        String json= JSON.toJSONString(news);
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
