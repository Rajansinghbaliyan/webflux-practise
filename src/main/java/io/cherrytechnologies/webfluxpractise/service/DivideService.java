package io.cherrytechnologies.webfluxpractise.service;

import io.cherrytechnologies.webfluxpractise.dto.DivideRequestDto;
import io.cherrytechnologies.webfluxpractise.dto.ResponseDto;
import io.cherrytechnologies.webfluxpractise.exception.BadInputException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;

@Service
public class DivideService {

    private Logger logger = LoggerFactory.getLogger(DivideService.class);

    public Mono<ResponseDto<Integer>> divide(Mono<DivideRequestDto> mono){
        return mono
                .subscribeOn(Schedulers.boundedElastic())
                .delayElement(Duration.ofMillis(100))
                .doOnNext(m -> logger.debug("Entered the divide method"))
                .doOnNext( m -> {
                    if (m.getFirst() == 0 || m.getSecond() == 0)
                        throw new BadInputException("Please provide both value to be not 0");
                })
                .doOnError(BadInputException.class, e -> logger.error(e.getMessage()))
                .map( m -> m.getFirst() / m.getSecond())
                .map(ResponseDto::new);
    }
}
