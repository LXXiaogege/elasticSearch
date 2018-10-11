package com.lvxin.elasticsearchdemo.Service.impl;

import com.lvxin.elasticsearchdemo.Service.FullTextQueries;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by lvxin
 */
@Service
public class FullTextQueriesImpl implements FullTextQueries {

    private final Logger logger=LoggerFactory.getLogger(FullTextQueriesImpl.class);
    @Autowired
    TransportClient client;

    @Override
    public SearchResponse matchQuery(String index,String type,String name,String text) {
        QueryBuilder queryBuilder=QueryBuilders.matchQuery(name,text);
        SearchResponse response=client.prepareSearch(index)
                .setTypes(type)
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setQuery(queryBuilder)
                .get();
        logger.info("matchQuery Response Staus : ",response.status().toString());
        System.out.println(response.toString());
        return response;
    }

    @Override
    public SearchResponse matchPhraseQuery(String index, String type, String name, String text) {
        //slop(n)表示两个词之间可以隔着n个词
        QueryBuilder queryBuilder=QueryBuilders.matchPhraseQuery(name,text).slop(1);
        SearchResponse response=client.prepareSearch(index)
                .setTypes(type)
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setQuery(queryBuilder)
                .get();
        System.out.println(response.toString());
        return response;
    }


    @Override
    public SearchResponse multiMatchQuery(String name,String...text) {
        //  .operator
        QueryBuilder queryBuilder=QueryBuilders.multiMatchQuery(name,text);
        SearchResponse response=client.prepareSearch()
                .setQuery(queryBuilder)
                .get();
        System.out.println(response.toString());
        return response;
    }

    @Override
    public SearchResponse commonTermsQuery(String name,String text) {
        //  cutoffFrequency设置高频词score因子
        QueryBuilder queryBuilder=QueryBuilders.commonTermsQuery(name,text).cutoffFrequency(0.001f);
        SearchResponse response=client.prepareSearch()
                .setQuery(queryBuilder)
                .get();
        System.out.println(response.toString());
        return response;
    }

    @Override
    public SearchResponse queryStringQuery(String field,String text) {
        //field 为检索字段
        QueryBuilder queryBuilder=QueryBuilders.queryStringQuery(text).field(field);
        SearchResponse response=client.prepareSearch()
                .setQuery(queryBuilder)
                .get();
        System.out.println(response.toString());
        return response;
    }

    @Override
    public SearchResponse simpleQueryStringQuery(String field,String text) {
        QueryBuilder queryBuilder=QueryBuilders.simpleQueryStringQuery(text).field(field);
        SearchResponse response=client.prepareSearch()
                .setQuery(queryBuilder)
                .get();
        System.out.println(response.toString());
        return response;
    }
}
