package com.lvxin.elasticsearchdemo.Service.impl;

import com.lvxin.elasticsearchdemo.Service.CompoundQueries;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.Operator;
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
    public SearchResponse boolQuery(String field, String value,String value_not,String time_filter,Boolean number) {
        if (number==false) {
            QueryBuilder qb = QueryBuilders.boolQuery()
                    .must(matchQuery(field, value).operator(Operator.AND))
                    .mustNot(matchQuery(field, value_not))
                    .filter(rangeQuery("pubTime").gte(time_filter));
//                    .filter(rangeQuery("pubTime").format("yyyy-mm-dd").gte(time_filter));
            SearchResponse response=client.prepareSearch("zutnlp_index_v1")
                    .setQuery(qb)
                    .setSize(1)   //设置返回数据总数   默认为10
                    .get();
            return response;
        }
        else{
            QueryBuilder qb = QueryBuilders.boolQuery()
                    .must(matchQuery(field, value))
                    .mustNot(matchQuery(field, value_not))
//                    .filter(rangeQuery("pubTime").format("yyyy-mm-dd").gte(time_filter));
                    .filter(rangeQuery("pubTime").gte(time_filter));
            SearchResponse response=client.prepareSearch("zutnlp_index_v1")
                    .setQuery(qb)
                    .setSize(1)
                    .get();
            return response;
        }
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
