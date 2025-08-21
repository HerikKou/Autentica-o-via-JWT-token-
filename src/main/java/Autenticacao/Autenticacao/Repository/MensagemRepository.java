package Autenticacao.Autenticacao.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Autenticacao.Autenticacao.Model.Mensagens;

public interface  MensagemRepository extends JpaRepository<Mensagens, Long> {
    
}
