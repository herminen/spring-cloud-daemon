package com.something;

import com.something.index.BookEntity;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetMappingsRequest;
import org.elasticsearch.client.indices.GetMappingsResponse;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.common.xcontent.XContentGenerator;
import org.elasticsearch.script.mustache.MultiSearchTemplateRequest;
import org.elasticsearch.script.mustache.MultiSearchTemplateResponse;
import org.elasticsearch.script.mustache.SearchTemplateRequest;
import org.elasticsearch.script.mustache.SearchTemplateRequestBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.IndexOperations;
import org.springframework.data.elasticsearch.core.SearchOperations;
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

    @Test
    public void testSearch() throws IOException {
        SearchRequest searchRequest = new SearchRequest().indices("testindex");
        SearchResponse search = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        System.out.println(search);
    }

    @Resource
    ElasticsearchRestTemplate restTemplate;

    @Test
    public void testRestTemplate(){
        IndexOperations indexOperations = restTemplate.indexOps(BookEntity.class);
        System.out.println(indexOperations.create());
        System.out.println(indexOperations.putMapping(BookEntity.class));
    }

}
