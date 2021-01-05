package com.something;

import com.something.entity.BookEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MachineSearchApplication.class})
public class TestElasticSearchTemplate {
    @Resource
    private ElasticsearchTemplate template;

    @Test
    public void testEsTemplate(){
        Map mapping = template.getMapping(BookEntity.class);
        System.out.println(mapping);
    }
}
