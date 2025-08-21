package Autenticacao.Autenticacao.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Autenticacao.Autenticacao.DTO.MensagemDto;
import Autenticacao.Autenticacao.Model.Mensagens;
import Autenticacao.Autenticacao.Repository.MensagemRepository;

@Service
public class MensagemService {
   @Autowired
   private MensagemRepository repository; 
   public Mensagens send(MensagemDto dto) throws Exception{
    if(dto.getMensagem() == null|| dto.getMensagem().isEmpty()){
        throw new Exception("Mensagem inválida");
    }
    Mensagens mensagens = new Mensagens();
    mensagens.setMensagem(dto.getMensagem());
    return repository.save(mensagens);
   }
}
