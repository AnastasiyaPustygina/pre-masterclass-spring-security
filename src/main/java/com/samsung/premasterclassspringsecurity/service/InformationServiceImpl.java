package com.samsung.premasterclassspringsecurity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
@RequiredArgsConstructor
public class InformationServiceImpl implements InformationService{
    @Override
    public String getUserInformation() throws IOException {

        return Files.readString(Paths.get("src/main/resources/information/user-information"));
    }

    @Override
    public String getAdminInformation() throws IOException {
        return Files.readString(Paths.get("src/main/resources/information/admin-information"));
    }
}
