package com.royb.artemiskeeper;

import com.royb.artemiskeeper.config.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class WebScrapper {

    //TODO - log to file
    private Logger logger = LoggerFactory.getLogger(WebScrapper.class);

    @Autowired
    private Config config;

    WebScrapper() {
        logger.info("Initializing web scrapper...");
        for(String url : config.getUrls()) {
            logger.info(url);
        }
//        try {
//
//        }
//        catch (IOException ex) {
//            logger.error(ex.getMessage(), ex);
//        }
    }

}
