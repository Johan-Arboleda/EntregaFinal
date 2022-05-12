package com.example.noticiasj.Modelos;

import java.io.Serializable;

public class TutularesDeNoticias implements Serializable {
    Fuente source= null;
    String author="";
    String title="";
    String description="";
    String name="";
    String url="";
    String urlToImage="";
    String publishedAt="";
    String content="";

    public Fuente getSource() {
        return source;
    }

    public void setSource(Fuente source) {
        this.source = source;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Fuente getFuente() {
        return source;
    }

    public void setFuente(Fuente fuente) {
        this.source = fuente;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
