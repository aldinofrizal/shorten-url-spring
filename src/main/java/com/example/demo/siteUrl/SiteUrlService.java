package com.example.demo.siteUrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
public class SiteUrlService {
  private final SiteUrlRepository siteUrlRepository;

  @Autowired
  public SiteUrlService(SiteUrlRepository siteUrlRepository) {
    this.siteUrlRepository = siteUrlRepository;
  }

  public List<SiteUrl> getUrlList() {
    return siteUrlRepository.findAll();
  }

  public SiteUrl getByShortenUrl(String shortenUrl) {
    final Optional<SiteUrl> existingSiteUrl = siteUrlRepository.findSiteUrlByShortenUrl(shortenUrl);
    if (existingSiteUrl.isEmpty()) {
      throw new IllegalStateException("data not found");
    }
    return existingSiteUrl.get();
  }

  public SiteUrl addNewSite(SiteUrl siteUrl) {
    final Optional<SiteUrl> existingSiteUrl = siteUrlRepository.findSiteUrlByShortenUrl(siteUrl.getShortenUrl());
    if (existingSiteUrl.isPresent()) {
      throw new IllegalStateException("shorten url taken");
    }

    if (!this.validateUrl(siteUrl.getUrl())) {
      throw new IllegalStateException("url not valid");
    }

    siteUrl.setCreatedAt(LocalDate.now());
    siteUrl.setUpdatedAt(LocalDate.now());
    siteUrlRepository.save(siteUrl);
    return siteUrl;
  }

  private Boolean validateUrl(String url) {
    try {
      // Attempt to create a URL object
      new URL(url);
      return true; // If no exception, the URL is valid
    } catch (MalformedURLException e) {
      return false; // Invalid URL format
    }
  }
}
