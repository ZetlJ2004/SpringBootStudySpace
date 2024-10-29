package org.example.springmvcexamples.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.springmvcexamples.vo.ResultVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/user/")
public class UserController {
    @GetMapping("info")
    public ResultVO getInfo(@RequestParam("uid") String uid) {
        log.debug(uid);
        return ResultVO.success(Map.of("uid",uid));
    }
}
