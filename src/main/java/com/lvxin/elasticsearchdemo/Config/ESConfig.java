package com.lvxin.elasticsearchdemo.Config;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;


/**
 * Created by lvxin
 */
@Configuration
public class ESConfig {

    //通过TCP形式，连接到ES集群
    @Bean
    public TransportClient client() throws UnknownHostException{
        //new一个节点，并初始化

        //9300为默认api访问端口
        InetSocketTransportAddress node =new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"),9300);

        Settings settings= Settings.builder()
                //集群名称,默认为elasticsearch，如果想换要到yml文件下添加集群名称
                .put("cluster.name","elasticsearch")
                .put("client.transport.sniff", true)
                .build();

        TransportClient client =new PreBuiltTransportClient(settings);
        client.addTransportAddress(node);
        return  client;

    }
}
