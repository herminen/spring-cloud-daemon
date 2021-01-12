package com.something.index;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * Created with IntelliJ IDEA.
 * User: liuhai
 * Date: 2021/1/11
 * Time: 22:36
 * Description: No Description
 */
@Data
@Document(indexName = "testindex", replicas = 1, shards = 1, refreshInterval = "3s")
public class IndexTest {

    @Field(name = "testindex", type = FieldType.Text)
    private String testIndex;

    @Field(name = "testfield", type = FieldType.Text)
    private String testField;
}
