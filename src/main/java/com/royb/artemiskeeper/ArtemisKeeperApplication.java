package com.royb.artemiskeeper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ArtemisKeeperApplication {
    public static void main(String[] args) {
        SpringApplication.run(ArtemisKeeperApplication.class, args);
        printBanner();
        initApplication();
    }

    private static void initApplication() {
        WebScrapper webScrapper = new WebScrapper();
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