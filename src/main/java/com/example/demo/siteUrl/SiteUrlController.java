package com.example.demo.siteUrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/url")
public class SiteUrlController {

  private final SiteUrlService siteUrlService;

  @Autowired
  public SiteUrlController(SiteUrlService siteUrlService) {
    this.siteUrlService = siteUrlService;
  }

  @GetMapping
  public List<SiteUrl> getUrls() {
    return siteUrlService.getUrlList();
  }

  @PostMapping
  public SiteUrl createShortenUrl(@RequestBody SiteUrl siteUrl) {
    final SiteUrl newSiteUrl = siteUrlService.addNewSite(siteUrl);
    return newSiteUrl;
  }
}
