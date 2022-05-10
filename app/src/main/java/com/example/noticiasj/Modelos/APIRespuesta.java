package com.example.noticiasj.Modelos;

import java.util.List;

public class APIRespuesta {
    /* se crean objetos para el estado de la respuesta, otro para el total de resultados y otro para eñl articulo compelt*/
    String status;
    int totalResults;
    List<TutularesDeNoticias> articles;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public List<TutularesDeNoticias> getArticles() {
        return articles;
    }

    public void setArticles(List<TutularesDeNoticias> articles) {
        this.articles = articles;
    }
}
