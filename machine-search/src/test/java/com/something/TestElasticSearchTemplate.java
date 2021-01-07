package com.something;

import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MachineSearchApplication.class})
public class TestElasticSearchTemplate {

    @Autowired
    RestHighLevelClient restHighLevelClient;

    @Test
    public void testEsTemplate() throws IOException {
        System.out.println(restHighLevelClient.ping(RequestOptions.DEFAULT));
    }
}
