package com.crawler.imagefinder.controllers;

import com.crawler.imagefinder.models.Website;
import com.crawler.imagefinder.services.WebsiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:3000")
@Controller
public class WebsiteController {

    private final WebsiteService websiteService;

    @Autowired
    public WebsiteController(WebsiteService websiteService) {
        this.websiteService = websiteService;
    }

    @QueryMapping
    public Website websiteById(@Argument UUID id) {
        return websiteService.getWebsiteById(id);
    }

    @QueryMapping
    public List<Website> websites() {
        return websiteService.getAllWebsites();
    }

    @QueryMapping
    public Website findImages(@Argument Website website) {
        return websiteService.upsertImages(website);
    }
}
