package com.royb.artemiskeeper;

import com.royb.artemiskeeper.config.Config;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Component
public class WebScrapper {

    //TODO - log to file
    private Logger logger = LoggerFactory.getLogger(WebScrapper.class);

    @Autowired
    private Config config;

    @PostConstruct
    public void init() {
        logger.info("Initializing web scrapper...");
        for(String url : config.getUrls()) {
            logger.info(url);
        }
    }

    public void scrape() {
        try {
            for (String url : config.getUrls()) {
                Document doc = Jsoup.connect(url).get();
                Elements repositories = doc.getElementsByClass("col-lg-2");
                logger.info("Title: " + doc.title() + ", list items: " + repositories.size());
                for (Element repo : repositories) {
                    repo.getAllElements();
                    Elements items = repo.getElementsByClass("item_masonry");
                    for (Element item : items) {
                        logger.info(item.text());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
