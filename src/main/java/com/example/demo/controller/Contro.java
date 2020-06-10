package com.example.demo.controller;

import com.example.demo.Mapper.ClientMapper;
import com.example.demo.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class Contro {

    @Autowired
    ClientMapper mapper;

    @RequestMapping(value = "/hello")
    public String clien(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession httpSession){
        Client client = new Client();
        client.setUsername(username);
        client.setPassword(password);
        int select = mapper.select(client);
        if(select>=1){
            httpSession.setAttribute("user",username);
            return "redirect:/index.html";
        }else{
            mapper.update(client);
            httpSession.setAttribute("user",username);
            return "redirect:/index.html";
        }
    }
}
