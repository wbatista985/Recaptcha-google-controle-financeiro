package br.com.controle.financeiro.api.controller;

import br.com.controle.financeiro.api.service.RecaptchaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/conta")
@EnableSwagger2
public class RecaptchaController {


    private final RecaptchaService recaptchaService;

    public RecaptchaController(RecaptchaService recaptchaService) {
        this.recaptchaService = recaptchaService;
    }

    @PostMapping("/submit-form")
    public ResponseEntity<String> submitForm(HttpServletRequest request, @RequestParam("g-recaptcha-response") String recaptchaResponse) {
        boolean isValid = recaptchaService.verifyRecaptcha(recaptchaResponse, request.getRemoteAddr());
        if (isValid) {
            // reCAPTCHA validado com sucesso
            return ResponseEntity.ok("Formulário enviado com sucesso");
        } else {
            // reCAPTCHA inválido
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("reCAPTCHA inválido");
        }
    }


}
