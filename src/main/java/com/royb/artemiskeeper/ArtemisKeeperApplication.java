package com.royb.artemiskeeper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ArtemisKeeperApplication {

    @Autowired
    private static ApplicationContext applicationContext;

    public static void main(String[] args) {
        SpringApplication.run(ArtemisKeeperApplication.class, args);
        printBanner();
        initApplication();
    }

    private static void initApplication() {
        var webScrapper = applicationContext.getBean(WebScrapper.class);
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