package com.example.hello.controller;

import com.example.hello.dto.MemberDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {

    private final Logger LOGGER = LoggerFactory.getLogger(GetController.class);

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getHello() {
        LOGGER.info("getHello method execute");
        return "Hello World";
    }

    @GetMapping("/name")
    public String getName() {
        LOGGER.info("getName method execute");
        return "Flature";
    }

    @GetMapping("/variable1/{variable}")
    public String getVariable1(@PathVariable String variable) {
        LOGGER.info("@PathVariable을 통해 들어온 값 : {}", variable);
        return variable;
    }

    // variable과 var의 값을 다르게 하고 싶을 경우
    @GetMapping("/variable2/{variable}")
    public String getVariable2(@PathVariable("variable") String var) {
        var = "connection";
        return var;
    }

    @ApiOperation(value = "Get 메서드 예제", notes = "@RequestParam을 활용한 GET Method")
    @GetMapping("/request1")
    public String getRequestParam1(
            @ApiParam(value = "이름", required = true) @RequestParam String name,
            @ApiParam(value = "이메일", required = true) @RequestParam String email,
            @ApiParam(value = "회사", required = true) @RequestParam String organization) {
        return name + " " + email + " " + organization;
    }

    @GetMapping("/request2")
    public String getRequestParam2(
            @RequestParam Map<String, String> param) {
        StringBuilder sb = new StringBuilder();
        param.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });
        return sb.toString();
    }

    @GetMapping("/request3")
    public String getRequestParam3(MemberDto memberDto) {
        return memberDto.toString();
    }
}
