package com.lvxin.elasticsearchdemo.Dao;

import org.elasticsearch.action.search.MultiSearchResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by lvxin
 */
//Search API
@Repository
public class SearchDao {

    private final Logger logger=LoggerFactory.getLogger(SearchDao.class);

    @Autowired
    TransportClient client;

    //查询所有
    public void matchAll(){
        SearchResponse  response=client.prepareSearch("news")
//                .highlighter()
                .get();

        //输出指定字段
        SearchHits hits=response.getHits();
        for (SearchHit hit:hits){
            System.out.println(hit.field("content"));
        }
    }
    //查询索引  (可多个)
    public String matchIndex(String...indexs){
        SearchResponse response=client.prepareSearch(indexs).get();
        System.out.println(response.toString());
        return response.toString();
    }

    public String  matchContent(String index,String type,String name,String text){

        QueryBuilder queryBuilder=QueryBuilders.matchPhraseQuery(name,text);

        SearchResponse response=client.prepareSearch(index)
                .setTypes(type)
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setQuery(queryBuilder)
                .execute()
                .actionGet();
//                .setFrom(0).setSize(60).setExplain(true)
        logger.info("Search response staus:::",response.status());
        System.out.println(response.toString());
        return response.toString();
    }
    //多个查询
    public void multiSearcch(String qsq,String name,String text){
        SearchRequestBuilder srb1=client.prepareSearch().setQuery(QueryBuilders.queryStringQuery(qsq)).setSize(1);
        SearchRequestBuilder srb2=client.prepareSearch().setQuery(QueryBuilders.matchQuery(name,text)).setSize(1);

        MultiSearchResponse multiSearchResponse=client.prepareMultiSearch()
                .add(srb1)
                .add(srb2)
                .get();

        long nbHits=0;
        for (MultiSearchResponse.Item item :multiSearchResponse.getResponses()){
            SearchResponse searchResponse=item.getResponse();
            nbHits+=searchResponse.getHits().getTotalHits();
        }
    }

    //查询模板
    public void searchTemplate(){

    }

}
