package com.mimi.auth.library.controller;


import com.mimi.auth.library.model.LoginViewModel;
import com.mimi.auth.library.security.JwtGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin
public class AuthenticationController {
    final static Logger logger  = LogManager.getLogger(AuthenticationController.class);
    private JwtGenerator jwtGenerator;

    public AuthenticationController( JwtGenerator jwtGenerator ) {
        this.jwtGenerator = jwtGenerator;
    }


    @PostMapping("/login")
    public String login(@RequestBody LoginViewModel viewModel, HttpServletResponse response ) throws Exception {
       logger.info(" In AuthenticationController: Username: " + viewModel.getUsername() + " password: " + viewModel.getPassword());


       return jwtGenerator.generate( viewModel, response );
    }
}
