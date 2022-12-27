package io.cherrytechnologies.webfluxpractise.service;

import io.cherrytechnologies.webfluxpractise.dto.ResponseDto;
import io.cherrytechnologies.webfluxpractise.util.SleepUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.SimpleTimeZone;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class MathService {

    private Logger logger = LoggerFactory.getLogger(MathService.class);

    public ResponseDto<Integer> findSquare(int number) {
        SleepUtil.sleepSecond(100);
        return new ResponseDto<>(number * number);
    }

    public List<ResponseDto<String>> getTable(int number) {
        return IntStream.rangeClosed(1, 10)
                .peek(i -> SleepUtil.sleepSecond(100))
                .peek(i -> logger.debug(String.format("Sleep for %d",i)))
                .mapToObj(i -> String.format("%d * %d = %d", number, i, number * i))
                .map(ResponseDto::new)
                .collect(Collectors.toList());
    }


}
