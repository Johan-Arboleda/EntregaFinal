package com.example.noticiasj.Modelos;

import java.io.Serializable;

public class Fuente implements Serializable {
    String id="";
    String name="";
    String category="";

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
