package com.something.config;

import org.elasticsearch.client.transport.TransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

import javax.annotation.Resource;

@Configuration
public class ElasticsearchConfig {

    @Resource
    private TransportClient transportClient;

    @Bean
    public ElasticsearchTemplate elasticsearchTemplate(){
        ElasticsearchTemplate elasticsearchTemplate = new ElasticsearchTemplate(transportClient);
        return elasticsearchTemplate;
    }
}
