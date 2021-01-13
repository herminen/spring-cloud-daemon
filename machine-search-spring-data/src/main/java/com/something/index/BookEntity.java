package com.something.index;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.elasticsearch.annotations.*;

@Data
@TypeAlias("bookentity")
@Document(indexName = "books", shards = 3, refreshInterval = "3s")
public class BookEntity {

    @Id
    private Long id;
    @MultiField(
        mainField = @Field(name = "name", type = FieldType.Text, analyzer = "ik_max_word"),
        otherFields = {
                @InnerField(suffix = "keyword", type = FieldType.Keyword)
        }
    )
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
