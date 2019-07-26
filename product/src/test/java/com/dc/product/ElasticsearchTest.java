package com.dc.product;

import com.dc.api.domain.User;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ElasticsearchTest {

    @Resource
    private JestClient jestClient;
//    @Resource
//    private UserRepository userRepository;

    @Test
    public void jestPost() {
        User user = new User();
        user.setId(1);
        user.setUsername("dc");
        user.setPwd("123");
        Index index = new Index.Builder(user).index("demo").type("people").id("No.1").build();
        try {
            jestClient.execute(index);
        } catch (IOException e) {
            log.error("ES错误",e);
        }
    }

    @Test
    public void jestSearch() {
        String json = "{\n" +
                "\t\"query\": {\n" +
                "        \"match\": {\n" +
                "            \"username\": \"dc\"\n" +
                "         }\n" +
                "    }\n" +
                "}";
        Search search = new Search.Builder(json).addIndex("demo").addType("people").build();
        try {
            SearchResult result = jestClient.execute(search);
            log.info(result.getSourceAsString());
        } catch (IOException e) {
            log.error("ES错误",e);
        }
    }

//    @Test
//    public void dataSearch() {
//        User user = new User();
//        user.setUsername("zzz");
//        userRepository.index(user);
//    }
}
