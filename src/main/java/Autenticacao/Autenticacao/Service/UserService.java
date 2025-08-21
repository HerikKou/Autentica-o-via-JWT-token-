package Autenticacao.Autenticacao.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import Autenticacao.Autenticacao.DTO.UserDto;
import Autenticacao.Autenticacao.Model.User;
import Autenticacao.Autenticacao.Repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;
  
    public User Register(UserDto dto) throws Exception{
        if(dto.getusername() == null || dto.getusername().isEmpty()){
            throw new Exception("Nome inválido");
        }
        else if(dto.getEmail() == null || dto.getEmail().isEmpty()){
            throw new Exception("Email inválido");
        }
        else if(repository.existsByEmail(dto.getEmail())){
            throw new Exception("Usuário já cadastro");
        }
        else if (dto.getPassword() == null || dto.getPassword().isEmpty()){
            throw new Exception("Senha inválida");
        }
        String hashSenha = passwordEncoder.encode(dto.getPassword());
        dto.setPassword(hashSenha);
        User user = new User();
        user.setUsername(dto.getusername());
        user.setEmail(dto.getEmail());
        user.setPassword(hashSenha);
         
        return repository.save(user);
    }
    public UserDto login(UserDto dto) throws Exception{
          if(dto.getEmail() == null || dto.getEmail().isEmpty()){
            throw new Exception("Email inválido");
        }
        else if (dto.getPassword() == null || dto.getPassword().isEmpty()){
            throw new Exception("Senha inválida");
        }
        User user = repository.findByEmail(dto.getEmail()).orElse(null);
        
     
            if(!passwordEncoder.matches(dto.getPassword() , user.getPassword())){
                throw new Exception("Senha incorreta");
            }
        String token = JwtUtil.generatedToken(user.getEmail());
        return new UserDto(user.getUsername(), user.getEmail(), token);
    }
   
   
}
