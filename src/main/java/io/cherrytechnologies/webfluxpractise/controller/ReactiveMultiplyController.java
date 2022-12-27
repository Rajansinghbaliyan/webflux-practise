package io.cherrytechnologies.webfluxpractise.controller;

import io.cherrytechnologies.webfluxpractise.dto.MultiplyRequestDto;
import io.cherrytechnologies.webfluxpractise.dto.ResponseDto;
import io.cherrytechnologies.webfluxpractise.service.MultiplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
@RequestMapping("/reactive/multiply")
public class ReactiveMultiplyController {

    @Autowired
    private MultiplyService service;

    @PostMapping()
    public Mono<ResponseDto<Integer>> multiply(
            @RequestBody Mono<MultiplyRequestDto> mono,
            @RequestHeader Map<String, String> headers
            ){
        System.out.println(headers);
        return service.multiplyNumbers(mono);
    }

}
