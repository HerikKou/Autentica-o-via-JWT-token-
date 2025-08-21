package Autenticacao.Autenticacao.DTO;

public class MensagemDto {
    private String mensagem;
    
    public MensagemDto(String mensagem){
        this.mensagem = mensagem;
    }public MensagemDto(){}
    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
