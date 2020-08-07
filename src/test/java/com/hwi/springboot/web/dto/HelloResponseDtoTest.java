package com.hwi.springboot.web.dto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void lombok_function_test(){

        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        assertThat(dto.getName()).isEqualTo(name); //메소드 체이닝이 지원. isEqualTo는 동등 비교 메소드
        assertThat(dto.getAmount()).isEqualTo(amount);

        /*assertThat의 장점
        * CoreMatchers와 달리 추가적인 라이브러리 불필요
        * 자동완성의 완성도
        * */

    }
}
