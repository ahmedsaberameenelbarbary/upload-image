package com.picture.service.service.util;


import com.picture.service.dto.AuthResponseDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class SessionData {

    AuthResponseDTO authResponseDTO;

    public AuthResponseDTO getAuthResponseDTO() {
        return authResponseDTO;
    }

    public void setAuthResponseDTO(AuthResponseDTO authResponseDTO) {
        this.authResponseDTO = authResponseDTO;
    }
}
