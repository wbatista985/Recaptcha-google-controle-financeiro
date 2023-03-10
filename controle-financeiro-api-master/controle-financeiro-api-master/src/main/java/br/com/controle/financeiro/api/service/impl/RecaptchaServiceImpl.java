package br.com.controle.financeiro.api.service.impl;

import br.com.controle.financeiro.api.model.RecaptchaResponseDTO;
import br.com.controle.financeiro.api.service.RecaptchaService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;


@Service
public class RecaptchaServiceImpl implements RecaptchaService {

    private final RestTemplate restTemplate;
    private final String siteVerifyUrl;
    private final String secretKey;

    public RecaptchaServiceImpl(@Value("${google.recaptcha.site-key}")String siteKey,
                                @Value("${google.recaptcha.secret-key}")String secretKey,
                                @Value("${google.recaptcha.verify-url}")String verifyUrl) {
        this.siteVerifyUrl = verifyUrl;
        this.secretKey = secretKey;
        this.restTemplate = new RestTemplate();
    }


    @Override
    public boolean verifyRecaptcha(String userResponse, String remoteIp) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
        map.add("secret", secretKey);
        map.add("response", userResponse);
        map.add("remoteip", remoteIp);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

        RecaptchaResponseDTO response = restTemplate.postForObject(siteVerifyUrl, request, RecaptchaResponseDTO.class);
        return response.isSuccess();
    }
}
