package com.lvxin.elasticsearchdemo.Service;

import org.elasticsearch.action.search.SearchResponse;

/**
 * Created by lvxin
 */
//复合查询
public interface CompoundQueries {


    public SearchResponse boolQuery_noNot(String name, String value,String value_not,String name_filter,String value_filter);

    public SearchResponse boolQuery(String name, String value,String value_not,String name_filter,String value_filter);

    public SearchResponse boolQueryMult(String name,String value_not,String name_filter,String value_filter,String...value_mult);
}

