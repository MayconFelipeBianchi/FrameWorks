package br.unipar.programacaointernet.servicecep.projetoframework.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

    public static boolean autenticar(String usuario, String senha){
        return "admin".equals(usuario) && "admin".equals(senha);

    }
}
