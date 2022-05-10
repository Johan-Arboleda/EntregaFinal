package com.example.noticiasj;

import com.example.noticiasj.Modelos.TutularesDeNoticias;

import java.util.List;

public interface OyenteBusquedaDatos<APIRespuesta>{
    void onfetchData(List<TutularesDeNoticias> lista, String mansaje);
    void error(String mensaje);
}
