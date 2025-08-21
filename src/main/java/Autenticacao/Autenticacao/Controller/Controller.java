package Autenticacao.Autenticacao.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Autenticacao.Autenticacao.DTO.UserDto;
import Autenticacao.Autenticacao.Model.User;

import Autenticacao.Autenticacao.Service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api")
public class Controller {
    @Autowired
    private UserService service;
    
   @PostMapping("/register")
   public ResponseEntity<User> register(@RequestBody UserDto dto) throws Exception{
       User user = service.Register(dto);
       if(user != null){
       return  ResponseEntity.status(HttpStatus.CREATED).body(user);
       }
       else{
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
       }
   }
   @PostMapping("/login")
   public ResponseEntity<?> postMethodName(@RequestBody UserDto user) throws Exception {
     UserDto usuarios = service.login(user);
     if(usuarios != null){
     
        return ResponseEntity.ok(usuarios);
     }
     return ResponseEntity.status(401).body("usaurio ou senha invalida");
   }
   
   
}
