package com.something.entity;

import com.frameworkset.orm.annotation.*;
import lombok.Data;
import org.frameworkset.elasticsearch.entity.ESBaseData;

import java.util.Date;

@ESIndex(name = "books", type = "_doc")
@Data
public class BookEntity {

    @ESId
    private String id;

    @ESSource
    private String name;

    private String nickName;

    private Integer pageCount;

    private Date publish;

    private String summery;
}
