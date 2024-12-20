package com.example.demo.common;

import com.example.demo.siteUrl.SiteUrl;
import com.example.demo.siteUrl.SiteUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class CommonController {
  private final SiteUrlService siteUrlService;

  @Autowired
  public CommonController(SiteUrlService siteUrlService) {
    this.siteUrlService = siteUrlService;
  }

  @GetMapping("/{shortenUrl}")
  public String getUrl(@PathVariable String shortenUrl) {
    SiteUrl siteUrl = siteUrlService.getByShortenUrl(shortenUrl);
    return siteUrl.getUrl();
  }
}
