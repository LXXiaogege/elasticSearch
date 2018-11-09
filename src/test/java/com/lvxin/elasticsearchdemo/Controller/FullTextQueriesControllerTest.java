package com.lvxin.elasticsearchdemo.Controller;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;


/**
 * @author lvixn
 * @date 2018/11/9 16:21
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class FullTextQueriesControllerTest {
    private  final Logger logger=LoggerFactory.getLogger(FullTextQueriesControllerTest.class);

    private MockMvc mvc;

    @Before
    public void testBefore(){
        logger.info("************Before test**********");
    }

//    @Test
//    public void test() throws Exception {
//        mvc.perform(MockMvcRequestBuilders.get("/str"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().string(''))
//    }
}
