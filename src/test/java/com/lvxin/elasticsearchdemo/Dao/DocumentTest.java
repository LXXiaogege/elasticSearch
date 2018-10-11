package com.lvxin.elasticsearchdemo.Dao;

import com.alibaba.fastjson.JSON;
import com.lvxin.elasticsearchdemo.domain.News;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by lvxin
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class DocumentTest {

    private final Logger logger=LoggerFactory.getLogger(DocumentTest.class);

    @Autowired
    DocumentDao documentDao;

    @Test
    public void documentTest(){
        News news1=new News("t","test","I don't konw");
        News news2=new News("人性的弱点","与人交流","卡耐基");
        String data1= JSON.toJSONString(news1);
        String data2=JSON.toJSONString(news2);
        documentDao.addDate(data1,"news","happy","3");
//        documentDao.addDate(data2,"news","happy","4");
//        documentDao.UpdateIndexById(data2,"news","happy","1");
//        documentDao.DeleteIndex("aa");
        documentDao.GetIndexById("news","happy","1");
    }
}
