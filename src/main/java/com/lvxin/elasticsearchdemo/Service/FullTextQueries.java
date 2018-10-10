package com.lvxin.elasticsearchdemo.Service;

import org.elasticsearch.action.search.SearchResponse;

/**
 * Created by lvxin
 */
//全文查询
public interface FullTextQueries {

    //匹配查询，单字段
    SearchResponse matchQuery();

    //多文本查询
    SearchResponse multiMatchQuery();

    //更专业的查询,常用词查询
    //查询中忽略停用词，提高查询准确率
    SearchResponse common_Terms_Query();

    //支持紧凑的Lucene查询字符串语法，允许您在单个查询字符串中指定AND | OR | NOT条件和多字段搜索。仅限专家用户。
    //字符串语法查询
    SearchResponse query_String_Query();

    //一种更简单，更健壮的query_string语法版本，适合直接向用户公开。
    SearchResponse simple_Query_String();
}
