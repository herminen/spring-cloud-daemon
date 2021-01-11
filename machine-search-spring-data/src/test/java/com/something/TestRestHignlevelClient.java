package com.something;

import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetMappingsRequest;
import org.elasticsearch.client.indices.GetMappingsResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRestHignlevelClient {

    @Resource
    RestHighLevelClient restHighLevelClient;

    @Test
    public void TestHignLevelClient() throws IOException {
        GetMappingsRequest getMappingsRequest = new GetMappingsRequest().indices("books");
        GetMappingsResponse mapping = restHighLevelClient.indices().getMapping(getMappingsRequest, RequestOptions.DEFAULT);
        System.out.println(mapping.mappings());
    }
}
