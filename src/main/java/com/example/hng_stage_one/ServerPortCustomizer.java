/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.hng_stage_one;

import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.stereotype.Component;

/**
 *
 * @author phang
 */

@Component
public class ServerPortCustomizer implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {
    @Override
    public void customize(ConfigurableServletWebServerFactory factory) {
        String port = System.getenv("X_ZOHO_CATALYST_LISTEN_PORT");
        int listenPort;

        if (port != null && !port.isEmpty()) {
            listenPort = Integer.parseInt(System.getenv("X_ZOHO_CATALYST_LISTEN_PORT"));
        } else {
            listenPort = 9000;
        }
        factory.setPort(listenPort);
    }
}

