package br.com.controle.financeiro.api.config;

import br.com.controle.financeiro.api.service.RecaptchaService;
import br.com.controle.financeiro.api.service.impl.RecaptchaServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("recaptchaConfig")
public class RecaptchaConfig {

    @Value("${google.recaptcha.site-key}")
    private String siteKey;

    @Value("${google.recaptcha.secret-key}")
    private String secretKey;

    @Value("${google.recaptcha.verify-url}")
    private String verifyUrl;

    @Bean
    public RecaptchaService recaptchaService() {
        return new RecaptchaServiceImpl(siteKey, secretKey, verifyUrl);
    }
}
