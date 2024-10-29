package org.example.springmvcexamples.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.springmvcexamples.exception.Code;
import org.example.springmvcexamples.exception.XException;
import org.example.springmvcexamples.vo.ResultVO;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionController {
    @ExceptionHandler(XException.class)
    public ResultVO handlXException(XException e) {
        if(e.getCode() != null){
            return ResultVO.error(e.getCode());
        }
        return ResultVO.error(e.getNumber(), e.getMessage());
    }
    @ExceptionHandler(Exception.class)
    public ResultVO handlXException(Exception e) {
        return ResultVO.error(Code.ERROR_CODE, e.getMessage());
    }
}
