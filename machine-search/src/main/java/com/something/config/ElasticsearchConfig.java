package com.something.config;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableConfigurationProperties(ElasticsearchProperties.class)
@Configuration
public class ElasticsearchConfig {

    @Autowired
    private ElasticsearchProperties elasticsearchProperties;

    @Bean
    public RestHighLevelClient restHighLevelClient(){
        String clusterNodes = elasticsearchProperties.getClusterNodes();
        String[] nodes = clusterNodes.split(",");
        HttpHost[] httpHosts = new HttpHost[nodes.length];
        for (int i = 0; i < nodes.length; i++) {
            String nodeInfo = nodes[i];
            String[] nodeInfoPart = nodeInfo.split(":");
            httpHosts[i] = new HttpHost(nodeInfoPart[0], NumberUtils.toInt(nodeInfoPart[1]),"http");
        }
        RestHighLevelClient client = new RestHighLevelClient(
                //如果是集群再配置多个
                RestClient.builder(httpHosts)
        );

        return client;
    }
}
