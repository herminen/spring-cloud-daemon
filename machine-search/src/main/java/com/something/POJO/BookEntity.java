package com.something.POJO;

import lombok.Data;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.annotation.TypeAlias;
//import org.springframework.data.elasticsearch.annotations.DateFormat;
//import org.springframework.data.elasticsearch.annotations.Document;
//import org.springframework.data.elasticsearch.annotations.Field;
//import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

@Data
//@Document(indexName = "books", shards = 3)
public class BookEntity {

//    @Id
    private String id;

//    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String name;

//    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String nickName;

//    @Field(type = FieldType.Integer)
    private Integer pageCount;

//    @Field(type = FieldType.Date, format = DateFormat.date_hour_minute_second)
    private Date publish;

//    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String summery;
}
