package system.crm.service;


import system.crm.web.dto.auth.JwtRequest;
import system.crm.web.dto.auth.JwtResponse;

public interface AuthService {

    JwtResponse login(
            JwtRequest loginRequest
    );

    JwtResponse refresh(
            String refreshToken
    );

}
