package com.pukhova.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by dish on 05.12.16.
 */

@WebService(endpointInterface = "com.pukhova.ws.Authorisation")
public class AuthorisationImpl implements Authorisation {

    @WebMethod
    public String registerUser(String username) {
        return "password";
    }

}
