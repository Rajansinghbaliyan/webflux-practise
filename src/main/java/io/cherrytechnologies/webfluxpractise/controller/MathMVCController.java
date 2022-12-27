package io.cherrytechnologies.webfluxpractise.controller;

import io.cherrytechnologies.webfluxpractise.dto.ResponseDto;
import io.cherrytechnologies.webfluxpractise.service.MathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mvc")
public class MathMVCController {

    @Autowired
    private MathService mathService;

    @GetMapping("/{number}")
    public ResponseEntity<ResponseDto<Integer>> getSquare(@PathVariable int number){
        return ResponseEntity.ok(mathService.findSquare(number));
    }

    @GetMapping("/table/{number}")
    public List<ResponseDto<String>> getTable(@PathVariable int number){
        return mathService.getTable(number);
    }

}
