package com.lvxin.elasticsearchdemo.Service;

import org.elasticsearch.action.search.SearchResponse;

/**
 * Created by lvxin
 */
//复合查询
public interface CompoundQueries {

    public SearchResponse boolQuery_noNot(String field, String value,String value_filter);

    public SearchResponse boolQuery(String field, String value,String value_not,String value_filter);

}

