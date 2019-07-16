package com.royb.artemiskeeper;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.cert.X509Certificate;

@SpringBootApplication
public class ArtemisKeeperApplication {

    @Autowired
    private static ApplicationContext applicationContext;

    public static void main(String[] args) {

        disableTlsCertValidation();

        applicationContext = SpringApplication.run(ArtemisKeeperApplication.class, args);
        SpringApplication.run(ArtemisKeeperApplication.class, args);
        printBanner();
        initApplication();
    }

    private static void disableTlsCertValidation() {
        TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return null;
            }

            public void checkClientTrusted(X509Certificate[] certs, String authType) {
            }

            public void checkServerTrusted(X509Certificate[] certs, String authType) {
            }
        } };

        try {
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        }
        catch (Exception e) {
        }
    }

    private static void initApplication() {
        var webScrapper = applicationContext.getBean(WebScrapper.class);
        webScrapper.scrape();
    }

    private static void printBanner() {
        System.out.println();
        System.out.println();
        System.out.println("        _____          __                 .__          ____  __.");
        System.out.println("       /  _  \\________/  |_  ____   _____ |__| ______ |    |/ _|____   ____ ______   ___________");
        System.out.println("      /  /_\\  \\_  __ \\   __\\/ __ \\ /     \\|  |/  ___/ |      <_/ __ \\_/ __ \\\\____ \\_/ __ \\_  __ \\");
        System.out.println("     /    |    \\  | \\/|  | \\  ___/|  Y Y  \\  |\\___ \\  |    |  \\  ___/\\  ___/|  |_> >  ___/|  | \\/");
        System.out.println("     \\____|__  /__|   |__|  \\___  >__|_|  /__/____  > |____|__ \\___  >\\___  >   __/ \\___  >__|");
        System.out.println("             \\/                 \\/      \\/        \\/          \\/   \\/     \\/|__|        \\/");
        System.out.println();
        System.out.println();
    }
}