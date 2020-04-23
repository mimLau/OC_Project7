package com.mimi.auth.library.model;

/*
    We will send a HTTP request to authenticate which will contain
    the username and password, will perform authentication against our database
    and if succeeded then we we'll build the JWT Token.
    In the first request we are going to send this model in the post method as JSON body
 */

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LoginViewModel {

    private String username;
    private String password;
}
