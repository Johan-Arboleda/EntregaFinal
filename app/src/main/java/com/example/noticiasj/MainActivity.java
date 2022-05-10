package com.example.noticiasj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.noticiasj.Modelos.APIRespuesta;
import com.example.noticiasj.Modelos.TutularesDeNoticias;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      llamadaAPI llamada = new llamadaAPI(this);
      llamada.getTutularesDeNoticias(listener, "general",null);
    }

    private final OyenteBusquedaDatos<APIRespuesta> listener = new OyenteBusquedaDatos<APIRespuesta>() {
        @Override
        public void onfetchData(List<TutularesDeNoticias> lista, String mansaje) {
            showNews(lista);
        }

        @Override
        public void error(String mensaje) {

        }
    };

    private void showNews(List<TutularesDeNoticias> lista) {
        recyclerView= findViewById(R.id.recyclet_main);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
        adapter= new Adapter(this, lista);
        recyclerView.setAdapter(adapter);
    }
}