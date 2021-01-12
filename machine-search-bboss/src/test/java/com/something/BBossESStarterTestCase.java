package com.something;

/**
 * Created with IntelliJ IDEA.
 * User: liuhai
 * Date: 2021/1/9
 * Time: 20:10
 * Description: No Description
 */
import org.frameworkset.elasticsearch.boot.BBossESStarter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 单集群演示功能测试用例，spring boot配置项以spring.elasticsearch.bboss开头
 * 对应的配置文件为application.properties文件
 * @author  yinbp [122054810@qq.com]
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BBossESStarterTestCase {
    @Autowired
    private BBossESStarter bbossESStarter;

    @Test
    public void testBbossESStarter() throws Exception {
        //判断索引类型是否存在，false表示不存在，正常返回true表示存在
        System.out.println(bbossESStarter.getRestClient().existIndiceType("twitter","tweet"));

        //判读索引是否存在，false表示不存在，正常返回true表示存在
        System.out.println(bbossESStarter.getRestClient().existIndice("testindex"));

        System.out.println(bbossESStarter.getRestClient().existIndice("agentinfo"));

    }

}
