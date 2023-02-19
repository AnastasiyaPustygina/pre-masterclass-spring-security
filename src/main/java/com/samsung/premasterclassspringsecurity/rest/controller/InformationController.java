package com.samsung.premasterclassspringsecurity.rest.controller;

import com.samsung.premasterclassspringsecurity.service.InformationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class InformationController {

    private final InformationService informationService;

    @GetMapping(path = "/information/admin")
    public String getAdminInformation() throws IOException {
        return informationService.getAdminInformation();
    }

    @GetMapping(path = "/information/user")
    public String getUserInformation() throws IOException {
        return informationService.getUserInformation();
    }

}
