package com.something.entity;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * Created with IntelliJ IDEA.
 * User: liuhai
 * Date: 2021/1/5
 * Time: 22:38
 * Description: No Description
 */
@Data
@Document(indexName = "testindex", shards = 1)
public class TestIndexEntity {

    @Field(type = FieldType.Text)
    private String testindex;

    @Field(type = FieldType.Text)
    private String testfield;
}
