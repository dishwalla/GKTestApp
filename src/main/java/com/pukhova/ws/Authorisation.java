package com.pukhova.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * Created by dish on 05.12.16.
 */

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface Authorisation {

        @WebMethod
        String registerUser(String username);
}


