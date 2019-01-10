package com.lvxin.elasticsearchdemo.Service;

import com.lvxin.elasticsearchdemo.Service.impl.CompoundQueriesImpl;
import org.elasticsearch.action.search.SearchResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by lvxin
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CompoundQueriesImplTest {
    @Autowired
    CompoundQueriesImpl compoundQueriesImpl;

    @Test
    public void test_bool_noNot(){
        SearchResponse response=compoundQueriesImpl.boolQuery("content","中国","","1147020961789",true);
        System.out.println(response.toString());
    }

}
