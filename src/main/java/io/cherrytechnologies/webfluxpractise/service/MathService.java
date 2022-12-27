package io.cherrytechnologies.webfluxpractise.service;

import io.cherrytechnologies.webfluxpractise.dto.ResponseDto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MathService {
    public ResponseDto<Integer> findSquare(int number) {
        return new ResponseDto<>(number * number);
    }

    public ResponseDto<List<String>> getTable(int number) {
        return new ResponseDto<>(IntStream.rangeClosed(1, 10)
                .mapToObj(i -> String.format("%d * %d = %d", number, i, number * i))
                .collect(Collectors.toList()));
    }


}
