package com.hwi.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class) //테스트 진행시 내장된 실행자 외 다른 실행자를 실행. 스프링부트 테스트와 JUnit사이를 연결
@WebMvcTest(controllers = HelloController.class)//Web에만 집중할 수 있는 어노테이션
public class HelloControllerTest {
    
    @Autowired
    private MockMvc mvc;
    
    @Test
    public void helloIsReturned() throws Exception{
        String hello = "hello";
        mvc.perform(get("/hello"))///hello주소로 HTTP GET요청
                .andExpect(status().isOk())//Header 의 status 를 검증.200,404,500의 상태인지 검증
                .andExpect(content().string(hello));// 응답 본문의 내용을 검증
    }

    @Test
    public void helloDto가_리턴된다() throws Exception{
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                get("/hello/dto")
                .param("name", name)
                .param("amount", String.valueOf(amount))) //파라미터 설정. String값으로만 가능.
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.name", is(name))) //JSON응답값을 필드별로 검증.
            .andExpect(jsonPath("$.amount", is(amount)));
    }
}
