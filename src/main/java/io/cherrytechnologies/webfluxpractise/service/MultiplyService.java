package io.cherrytechnologies.webfluxpractise.service;

import io.cherrytechnologies.webfluxpractise.dto.MultiplyRequestDto;
import io.cherrytechnologies.webfluxpractise.dto.ResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;


@Service
public class MultiplyService {

    private Logger logger = LoggerFactory.getLogger(MultiplyService.class);

    public Mono<ResponseDto<Integer>> multiplyNumbers(Mono<MultiplyRequestDto> monoDto) {
        return monoDto
                .subscribeOn(Schedulers.boundedElastic())
                .delayElement(Duration.ofMillis(100))
                .doOnNext(mono ->
                        logger.debug(String.format("Sleep for %d, %d", mono.getFirstNumber(), mono.getSecondNumber())))
                .map(mono -> mono.getFirstNumber() * mono.getSecondNumber())
                .map(ResponseDto::new);
    }
}
