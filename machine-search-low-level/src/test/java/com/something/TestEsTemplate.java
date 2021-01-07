package com.something;

import com.something.entity.BookEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestEsTemplate {

    @Autowired
    ElasticsearchTemplate template;

    @Test
    public void TestTemplate(){
        BookEntity bookEntity = new BookEntity();
        bookEntity.setId("1");
        bookEntity.setName("hadoop 大师");
        bookEntity.setNickName("xiaoT");
        bookEntity.setPageCount(540);
        bookEntity.setPublish(new Date());
        bookEntity.setSummery("这是大师级的著作，小白慎读。");
        IndexQuery indexQuery = new IndexQueryBuilder().withIndexName("books")
                .withType("_doc").withObject(bookEntity).build();
        System.out.println(template.index(indexQuery));
        System.out.println(template.getMapping(BookEntity.class));
    }

}
