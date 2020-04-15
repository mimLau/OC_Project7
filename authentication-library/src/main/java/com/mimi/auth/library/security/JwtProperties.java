package com.mimi.auth.library.security;

public class JwtProperties {

      public static final String SECRET = "MimiSecret"; //  The secret by which the token gets hashed
      public static final int EXPIRATION_TIME = 864000000; // 10 days
      public static final String TOKEN_PREFIX = "Bearer ";
      public static final String HEADER_STRING = "Authorization"; //Header in which will send the baerer token
}
