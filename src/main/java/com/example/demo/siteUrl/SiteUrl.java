package com.example.demo.siteUrl;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
public class SiteUrl {
  @Id
  @SequenceGenerator(
      name = "siteUrl_sequence",
      sequenceName = "siteUrl_sequence",
      allocationSize = 1
  )
  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "siteUrl_sequence"
  )
  private Long id;
  private String url;
  private String shortenUrl;
  private LocalDate createdAt;
  private LocalDate updatedAt;

  public SiteUrl() {}
  public SiteUrl(String url, String shortenUrl) {
    this.url = url;
    this.shortenUrl = shortenUrl;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getShortenUrl() {
    return shortenUrl;
  }

  public void setShortenUrl(String shortenUrl) {
    this.shortenUrl = shortenUrl;
  }

  public LocalDate getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDate createdAt) {
    this.createdAt = createdAt;
  }

  public LocalDate getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(LocalDate updatedAt) {
    this.updatedAt = updatedAt;
  }
}
