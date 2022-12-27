package io.cherrytechnologies.webfluxpractise.controller;

import io.cherrytechnologies.webfluxpractise.dto.DivideRequestDto;
import io.cherrytechnologies.webfluxpractise.dto.ResponseDto;
import io.cherrytechnologies.webfluxpractise.service.DivideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/divide")
public class ReactiveDivideController {

    @Autowired
    private DivideService service;

    @PostMapping()
    public Mono<ResponseDto<Integer>> divide(@RequestBody Mono<DivideRequestDto> mono){
        return service.divide(mono);
    }
}
