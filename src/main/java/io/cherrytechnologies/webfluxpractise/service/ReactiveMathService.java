package io.cherrytechnologies.webfluxpractise.service;

import io.cherrytechnologies.webfluxpractise.dto.ResponseDto;
import io.cherrytechnologies.webfluxpractise.util.SleepUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

@Service
public class ReactiveMathService {
    private Logger logger = LoggerFactory.getLogger(ReactiveMathService.class);

    public Mono<ResponseDto<Integer>> getSquare(int number) {
        return Mono.fromSupplier(() -> number * number)
                .subscribeOn(Schedulers.boundedElastic())
                .doOnNext(i -> SleepUtil.sleepSecond(100))
                .map(ResponseDto::new);
    }

    public Flux<ResponseDto<String>> multiplicationTable(int number) {
        return Flux.range(1, 10)
                .subscribeOn(Schedulers.boundedElastic())
                .doOnNext(i -> SleepUtil.sleepSecond(100))
                .doOnNext(i -> logger.debug(String.format("Sleep for %d ", i)))
                .map(i -> String.format("%d * %d = %d", number, i, number * i))
                .map(ResponseDto::new);
    }
}
