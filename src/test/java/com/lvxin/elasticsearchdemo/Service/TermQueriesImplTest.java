package com.lvxin.elasticsearchdemo.Service;

import com.lvxin.elasticsearchdemo.Service.impl.TermQueriesImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;

/**
 * Created by lvxin
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TermQueriesImplTest {

    @Autowired
    TermQueriesImpl termQueriesImpl;

    @Test
    public void test()throws ParseException {
        termQueriesImpl.rangeQuery("number",6,8);
    }
}
