package com.pukhova;

import com.pukhova.ws.AuthorisationImpl;
import org.junit.Test;
import org.junit.runner.notification.RunListener;

import javax.xml.ws.Endpoint;

/**
 * Created by dish on 05.12.16.
 */

public class WsPublisher {

    @Test
    public void start() throws Exception {
        Endpoint.publish("http://localhost:1234/ws/auth", new AuthorisationImpl());
        Thread.sleep(3600000);
    }
}
