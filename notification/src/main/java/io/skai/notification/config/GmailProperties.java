package io.skai.notification.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "spring.mail")
@Getter
@Setter
public class GmailProperties {

    private String debug                 = "false";
    private String socketFactoryClass    = "javax.net.ssl.SSLSocketFactory";
    private String socketFactoryPort     = "465";

    private String host;
    private Integer port;
    private String username;
    private String password;
    private String smtpAuth;
}
