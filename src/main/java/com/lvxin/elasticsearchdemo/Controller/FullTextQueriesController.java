package com.lvxin.elasticsearchdemo.Controller;

import org.elasticsearch.client.transport.TransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lvxin
 */
@RestController
public class FullTextQueriesController {

    @Autowired
    TransportClient client;


}
