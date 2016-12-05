package com.epam.bl;

import com.google.inject.Inject;
import com.pukhova.model.Configuration;
import com.pukhova.ws.client.Authorisation;
import com.pukhova.ws.client.AuthorisationImplService;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by dish on 05.12.16.
 */
public class WSAction implements BusinessFunction {

    public static final String WSDL_LOCATION = "wsdlLocation";
    private Configuration configuration;

    @Inject
    public WSAction(Configuration configuration) {
        this.configuration = configuration;
    }

    public void doAction() {

        try {
            Authorisation auth = getAuthorisationWS();
            JOptionPane.showMessageDialog(null, auth.registerUser("olga_pukhova"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }

    private Authorisation getAuthorisationWS() throws MalformedURLException {
        URL wsdlLocation = new URL(configuration.getParam(WSDL_LOCATION));
        AuthorisationImplService authorisationImplService = new AuthorisationImplService(wsdlLocation);
        return authorisationImplService.getAuthorisationImplPort();
    }

}
