package com.something;

import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.DocWriteRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.action.support.ActiveShardCount;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
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

    @Test
    public void testIndex() throws IOException {
        CreateIndexRequest request = new CreateIndexRequest("books");
        request.settings(Settings.builder()
                .put("index.number_of_shards", 3)
                .put("index.number_of_replicas", 1));
        XContentBuilder builder = XContentFactory.jsonBuilder();
        builder.startObject();
        {
            builder.startObject("properties");
            {
                builder.startObject("id");
                {
                    builder.field("type", "long");
                }
                builder.endObject();
                builder.startObject("name");
                {
                    builder.field("type", "text");
                    builder.startObject("fields");
                    {
                        builder.startObject("keyword");
                        {
                            builder.field("type", "keyword");
                        }
                        builder.endObject();
                    }
                    builder.endObject();
                }
                builder.endObject();
                builder.startObject("author");
                {
                    builder.field("type", "text");
                    builder.startObject("fields");
                    {
                        builder.startObject("keyword");
                        {
                            builder.field("type", "keyword");
                        }
                        builder.endObject();
                    }
                    builder.endObject();
                }
                builder.endObject();
                builder.startObject("pagecount");
                {
                    builder.field("type", "long");
                }
                builder.endObject();
                builder.startObject("price");
                {
                    builder.field("type", "float");
                }
                builder.endObject();
                builder.startObject("summery");
                {
                    builder.field("type", "text");
                }
                builder.endObject();
            }
            builder.endObject();
        }
        builder.endObject();
        request.mapping("_doc", builder);
        request.waitForActiveShards(ActiveShardCount.from(2));
        request.waitForActiveShards(ActiveShardCount.DEFAULT);
        CreateIndexResponse indexResponse = restHighLevelClient.indices().create(request, RequestOptions.DEFAULT);
        System.out.println(indexResponse.index());
        System.out.println(indexResponse.isAcknowledged());
    }
}
