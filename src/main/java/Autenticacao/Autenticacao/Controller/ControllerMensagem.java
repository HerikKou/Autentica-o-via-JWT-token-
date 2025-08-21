package Autenticacao.Autenticacao.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Autenticacao.Autenticacao.DTO.MensagemDto;
import Autenticacao.Autenticacao.Model.Mensagens;
import Autenticacao.Autenticacao.Service.MensagemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api")
public class ControllerMensagem {
    @Autowired
    private MensagemService service;
    @PostMapping("/enviar")
    public ResponseEntity<Mensagens> enviar(@RequestBody MensagemDto dto) throws Exception {
        Mensagens mensagens = service.send(dto);
        if(mensagens != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(mensagens);
        }
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }
    
}
