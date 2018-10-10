package com.lvxin.elasticsearchdemo.Service.impl;

import com.lvxin.elasticsearchdemo.Service.FullTextQueries;
import org.elasticsearch.action.search.SearchResponse;

/**
 * Created by lvxin
 */
public class FullTextQueriesImpl implements FullTextQueries {

    @Override
    public SearchResponse matchQuery() {
        return null;
    }

    @Override
    public SearchResponse multiMatchQuery() {
        return null;
    }

    @Override
    public SearchResponse common_Terms_Query() {
        return null;
    }

    @Override
    public SearchResponse query_String_Query() {
        return null;
    }

    @Override
    public SearchResponse simple_Query_String() {
        return null;
    }
}
