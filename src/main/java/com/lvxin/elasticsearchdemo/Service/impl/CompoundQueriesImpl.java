package com.lvxin.elasticsearchdemo.Service.impl;

import com.lvxin.elasticsearchdemo.Service.CompoundQueries;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * Created by lvxin
 */
@Service
public class CompoundQueriesImpl implements CompoundQueries {

    @Autowired
    TransportClient client;

    @Override
    public SearchResponse boolQuery(String name, String value,String value_not,String name_filter,String value_filter) {
        QueryBuilder qb=QueryBuilders.boolQuery()
                .must(matchPhraseQuery(name,value))
                .mustNot(matchPhraseQuery(name,value_not))
                .filter(rangeQuery(name_filter).format(value_filter));
        SearchResponse response=client.prepareSearch("index")
                .setQuery(qb)
                .get();
        return response;
    }

    @Override
    public SearchResponse boolQueryMult(String name,String value_not,String name_filter,String value_filter,String...value_mult) {
        QueryBuilder qb=QueryBuilders.boolQuery()
                .must(multiMatchQuery(name,value_mult))
                .mustNot(matchPhraseQuery(name,value_not))
                .filter(rangeQuery(name_filter).format(value_filter));
        SearchResponse response=client.prepareSearch("index")
                .setQuery(qb)
                .get();
        return response;
    }

    @Override
    public SearchResponse boolQuery_noNot(String name, String value,String value_not,String name_filter,String value_filter) {
        QueryBuilder qb = QueryBuilders.boolQuery()
                .must(matchPhraseQuery(name, value))
                .filter(rangeQuery(name_filter).format(value_filter));
        SearchResponse response = client.prepareSearch("index")
                .setQuery(qb)
                .get();
        return response;
    }

//    @Override
//    public SearchResponse boolQuery(String name,String value) {
//        QueryBuilder qb=QueryBuilders.boolQuery()
//                .mustNot(termQuery(name,value));
//        SearchResponse response=client.prepareSearch("my_index")
//                .setQuery(qb)
//                .get();
//        SearchHits hits=response.getHits();
//        for (SearchHit hit:hits){
//            hit.field("content").toString();
//        }
////        AnalyzeRequest analyzeRequest=new AnalyzeRequest()
////                .text(content)
////                .analyzer("ik_max_word");
////        List<AnalyzeResponse.AnalyzeToken> tokens = client.admin().indices().analyze(analyzeRequest).actionGet().getTokens();
////        for (AnalyzeResponse.AnalyzeToken token : tokens){
////            QueryBuilder qb=QueryBuilders.boolQuery().mustNot()
////            System.out.println(token.getTerm()); // 在控制台输出
////        }
//
//        return response;
//    }
}
