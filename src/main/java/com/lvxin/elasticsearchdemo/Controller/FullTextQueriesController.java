package com.lvxin.elasticsearchdemo.Controller;

import com.lvxin.elasticsearchdemo.Service.impl.FullTextQueriesImpl;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lvxin
 * @date 18-11-8 下午1:45
 */
@RestController
public class FullTextQueriesController {

    @Autowired
    TransportClient client;
    @Autowired
    FullTextQueriesImpl ftqi;

    @GetMapping
    public ResponseEntity<?> queryString(@RequestParam(name = "name")String name,
                                         @RequestParam(name="text")String  text){
        if (name==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        SearchResponse searchResponse =ftqi.queryStringQuery(name,text);
        SearchHits hits=searchResponse.getHits();
        String source=null;
        for(SearchHit hit:hits){
            source+=hit.getSourceAsString();
        }

        return  new ResponseEntity<>(source,HttpStatus.OK);
    }
}
