package io.cherrytechnologies.webfluxpractise.controller;

import io.cherrytechnologies.webfluxpractise.dto.ResponseDto;
import io.cherrytechnologies.webfluxpractise.service.ReactiveMathService;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.awt.*;

@RestController
@RequestMapping("/reactive")
public class MathReactiveController {

    @Autowired
    private ReactiveMathService service;

    @GetMapping("/{number}")
    public Mono<ResponseDto<Integer>> getSquare(@PathVariable int number){
        return service.getSquare(number);
    }

    @GetMapping("/table/{number}")
    public Flux<ResponseDto<String>> getMultiplication(@PathVariable int number){
        return service.multiplicationTable(number);
    }

    @GetMapping(value = "/table/stream/{number}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ResponseDto<String>> getMultiplicationStream(@PathVariable int number){
        return service.multiplicationTable(number);
    }
}
