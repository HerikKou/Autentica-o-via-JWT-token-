package Autenticacao.Autenticacao.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



@Entity
public class Mensagens {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Notblank
    private Long id;
    @NotNull
    private String mensagem;
    
    public Mensagens(Long id, String mensagem) {
        this.id = id;
        this.mensagem = mensagem;
      
    }
    public Mensagens(){}
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getMensagem() {
        return mensagem;
    }
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    

}
