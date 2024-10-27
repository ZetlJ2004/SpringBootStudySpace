package org.example.springmvcexamples.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.springmvcexamples.component.JWTComponent;
import org.example.springmvcexamples.service.UserService;
import org.example.springmvcexamples.dox.User;
import org.example.springmvcexamples.exception.Code;
import org.example.springmvcexamples.vo.ResultVO;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/")
public class LoginController {

    private final UserService userService;
    private final JWTComponent jwtComponent;
    private final PasswordEncoder passwordEncoder;
    @PostMapping("login")
    public ResultVO login(@RequestBody User user, HttpServletResponse response){
        User userL = userService.getUserByAccount(user.getAccount());
        if(userL == null || !passwordEncoder.matches(user.getPassword(), userL.getPassword())){
            return ResultVO.error(Code.LOGIN_ERROR);
        }
        String token = jwtComponent.encode(Map.of("uid",userL.getId(),"role",userL.getRole()));
        response.setHeader("token",token);
        response.setHeader("role",userL.getRole());
        return ResultVO.success(userL);
    }
}
