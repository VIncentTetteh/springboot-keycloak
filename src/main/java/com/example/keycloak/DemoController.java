package com.example.keycloak;

import com.nimbusds.jwt.JWT;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/api/v1/demo")
public class DemoController {

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello from spring boot keycloak";
    }

    @GetMapping("/")
    public String greetings(){
        return "welcome to spring boot keycloak";
    }

    @GetMapping("/admin")
    public String adminHello(@AuthenticationPrincipal Jwt jwt) {
        return "Hello from spring boot keycloak - ADMIN " + jwt.getClaimAsString("name");
    }
}
