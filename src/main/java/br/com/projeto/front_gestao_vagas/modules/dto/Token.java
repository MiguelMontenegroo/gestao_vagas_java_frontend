package br.com.projeto.front_gestao_vagas.modules.dto;

import java.util.List;

import lombok.Data;

@Data
public class Token {
  
  private String access_token;
  private List<String> roles; 
  private Long expires_in;



}
