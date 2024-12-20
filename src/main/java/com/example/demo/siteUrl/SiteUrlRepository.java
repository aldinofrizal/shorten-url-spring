package com.example.demo.siteUrl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SiteUrlRepository extends JpaRepository<SiteUrl, Long> {

  Optional<SiteUrl> findSiteUrlByShortenUrl(String shortenUrl);
}
