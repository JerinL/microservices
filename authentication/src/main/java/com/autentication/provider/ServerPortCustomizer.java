package com.autentication.provider;

import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;

public class ServerPortCustomizer implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {
    @Override
    public void customize(ConfigurableServletWebServerFactory factory) {
        String portStr = System.getenv("X_ZOHO_CATALYST_LISTEN_PORT");
        int listenPort = (portStr != null && !portStr.isEmpty()) ? Integer.parseInt(portStr) : 8001;
        factory.setPort(listenPort);
    }
}
