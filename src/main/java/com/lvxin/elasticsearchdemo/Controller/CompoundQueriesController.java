package com.lvxin.elasticsearchdemo.Controller;


import com.lvxin.elasticsearchdemo.Service.impl.CompoundQueriesImpl;
import com.lvxin.elasticsearchdemo.domain.News;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lvixn
 * @date 2019/1/3 14:11
 */
@RestController
public class CompoundQueriesController {
    @Autowired
    TransportClient client;
    @Autowired
    CompoundQueriesImpl cqi;

    @GetMapping("/bool")
    public List<News> boolQuery(@RequestParam(name = "field")String field,
                                       @RequestParam(name="value")String  value,
                                       @RequestParam(name = "value_not")String value_not,
                                       @RequestParam(name = "time_filter")String time_filter,
                                       @RequestParam(name = "number")Boolean number){
        if (field==null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            return new ArrayList<>();
        }
        SearchResponse searchResponse =cqi.boolQuery(field,value,value_not,time_filter,number);
        SearchHits hits=searchResponse.getHits();
        List<News> news=new ArrayList<>();
        for(SearchHit hit:hits){
            News new1=new News();
            new1.setContent(hit.getSourceAsMap().get("content").toString());
            news.add(new1);
            System.out.println(news);
        }

        return  news;
    }


}
