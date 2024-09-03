package br.unipar.programacaointernet.servicecep.projetoframework.controller;

import br.unipar.programacaointernet.servicecep.projetoframework.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/login") // nosso caminho localhost:8080/login
    public String showLoginPage() {
        //retorna o nome do template .html
        //o spring boot vai procurar na pasta resources/templates
        // não precisa colocar a extensão .html
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String usuario, @RequestParam String senha, Model model) {

        boolean isValidUser = LoginService.autenticar(usuario, senha);

        if (isValidUser) {
            model.addAttribute("usuario", usuario);
            //return "welcome";
            return "redirect:/success";
        } else {
            model.addAttribute("error", "Credenciais inválidas!");
            return "login";
        }
    }
    @GetMapping("/success")//chama aqui!
    public String sucesso(){
    return "success";
    }
}