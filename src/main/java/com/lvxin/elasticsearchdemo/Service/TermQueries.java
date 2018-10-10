package com.lvxin.elasticsearchdemo.Service;

import org.elasticsearch.action.search.SearchResponse;

/**
 * Created by lvxin
 */
//术语级别查询
public interface TermQueries {

    //查找包含指定字段中指定的确切术语的文档。
    SearchResponse Term_Query();

    //查找包含指定字段中指定的任何确切术语的文档。
    SearchResponse Terms_Query();

    //查找指定字段包含指定范围内的值（日期，数字或字符串）的文档。
    SearchResponse Range_Query();

    //查找指定字段包含任何非空值的文档。
    SearchResponse Exists_Query();

    //查找指定字段包含具有指定的确切前缀的术语的文档。
    SearchResponse Prefix_Query();

    //查找指定字段包含与指定模式匹配的术语的文档，其中模式支持单字符通配符（?）和多字符通配符（*）
    SearchResponse WildCard_Query();

    //查找指定字段包含与指定的正则表达式匹配的术语的文档。
    SearchResponse Regexp_Query();

    //查找指定字段包含与指定术语模糊相似的术语的文档。模糊度是以Levenshtein编辑距离 1或2 来衡量的 。
    SearchResponse Fuzzy_Query();

    //查找指定类型的文档
    SearchResponse Type_Query();

    //查找具有指定类型和ID的文档。
    SearchResponse Ids_Query();
}
