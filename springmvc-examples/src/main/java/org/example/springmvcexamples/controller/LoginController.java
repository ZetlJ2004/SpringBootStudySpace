package org.example.springmvcexamples.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.springmvcexamples.service.UserService;
import org.example.springmvcexamples.dox.User;
import org.example.springmvcexamples.exception.Code;
import org.example.springmvcexamples.vo.ResultVO;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/")
public class LoginController {

    private final UserService userService;
    @PostMapping("login")
    public ResultVO login(@RequestBody User user){
        User userL = userService.getUserByAccount(user.getAccount(), user.getPassword());
        if(userL == null){
            return ResultVO.error(Code.LOGIN_ERROR);
        }
        return ResultVO.success(userL);
    }
}
