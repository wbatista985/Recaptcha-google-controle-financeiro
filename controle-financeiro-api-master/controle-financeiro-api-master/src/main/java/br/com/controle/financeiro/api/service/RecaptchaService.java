package br.com.controle.financeiro.api.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public interface RecaptchaService {
    boolean verifyRecaptcha(String userResponse, String remoteIp);
}
