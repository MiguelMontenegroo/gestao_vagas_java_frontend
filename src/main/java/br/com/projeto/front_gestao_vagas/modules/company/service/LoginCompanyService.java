package br.com.projeto.front_gestao_vagas.modules.company.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.projeto.front_gestao_vagas.modules.candidate.dto.Token;


@Service
public class LoginCompanyService {
  
public Token execute(String username, String password) {
     RestTemplate rt = new RestTemplate();

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);

    Map<String, String> data = new HashMap<>();
    data.put("username", username);
    data.put("password", password);

    HttpEntity<Map<String, String>> request = new HttpEntity<>(data, headers);

    var result = rt.postForObject("http://localhost:8080/company/auth",request, Token.class);

     System.out.println("Resultado da API: " + result);


    if (result != null) {
        System.out.println("Access Token: " + result.getAccess_token());
        System.out.println("Roles: " + result.getRoles());
        System.out.println("Expires In: " + result.getExpires_in());
    } else {
        System.out.println("A resposta da API é nula.");
    }

    return result;
}
}
