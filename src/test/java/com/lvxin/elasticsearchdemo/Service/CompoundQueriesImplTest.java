package com.lvxin.elasticsearchdemo.Service;

import com.lvxin.elasticsearchdemo.Service.impl.CompoundQueriesImpl;
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
//        SearchResponse response=compoundQueriesImpl.boolQuery_noNot("content","中国 唐朝","2015-11-15");
//        System.out.println(response.toString());
    }

}
