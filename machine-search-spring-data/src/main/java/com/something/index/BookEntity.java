package com.something.index;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "books", shards = 3, replicas = 1,  refreshInterval = "3s")
public class BookEntity {

    @Id
    private Long id;
    @Field(name = "name", type = FieldType.Text, analyzer = "ik_max_word")
    private String name;
    @Field(name = "author", type = FieldType.Text, analyzer = "ik_max_word", store = true)
    private String author;
    @Field(name = "summery", type = FieldType.Text, analyzer = "ik_max_word")
    private String summery;
    @Field(name = "price", type = FieldType.Float)
    private Float price;
    @Field(name = "pagecount", type = FieldType.Long)
    private Long pageCount;
}
