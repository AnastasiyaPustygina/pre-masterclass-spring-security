package com.samsung.premasterclassspringsecurity.service;

import java.io.IOException;

public interface InformationService {
    String getUserInformation() throws IOException;

    String getAdminInformation() throws IOException;

}
