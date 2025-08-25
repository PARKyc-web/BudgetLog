package io.github.parkyc.budgetlog.token.controller;

import io.github.parkyc.budgetlog.common.CommonDTO;
import io.github.parkyc.budgetlog.token.dto.JwtTokenDTO;
import io.github.parkyc.budgetlog.token.service.JwtTokenService;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/token")
@RequiredArgsConstructor
public class JwtTokenController {

    private final JwtTokenService tokenService;

    @PostMapping("/verify")
    public CommonDTO.Response<?> verifyToken(@RequestBody JwtTokenDTO tokenDTO){

        Claims claims = tokenService.verifyToken(tokenDTO.getAccessToken());

        return CommonDTO.Response.success(claims);
    }
}
