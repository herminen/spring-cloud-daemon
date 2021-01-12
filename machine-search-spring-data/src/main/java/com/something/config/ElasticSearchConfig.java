package com.something.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: liuhai
 * Date: 2021/1/12
 * Time: 21:05
 * Description: No Description
 */
@Configuration
public class ElasticSearchConfig {

    @Resource
    RestHighLevelClient restHighLevelClient;

    @Bean
    public ElasticsearchRestTemplate elasticsearchRestTemplate(){
        return new ElasticsearchRestTemplate(restHighLevelClient);
    }
}
