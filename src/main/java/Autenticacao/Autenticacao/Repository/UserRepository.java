package Autenticacao.Autenticacao.Repository;


import org.springframework.stereotype.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import Autenticacao.Autenticacao.Model.User;



@Repository
public interface UserRepository extends JpaRepository<User,Long> {
  Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);  
  
}
