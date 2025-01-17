package br.com.projeto.front_gestao_vagas.modules.candidate.dto;




import lombok.Data;


@Data
public class CreateCandidateDTO {
  
  private String name;
  private String username;
  private String email;
  private String password;
  private String description;
}
