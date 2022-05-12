package com.example.noticiasj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.view.View;
import android.widget.Button;

import com.example.noticiasj.Modelos.APIRespuesta;
import com.example.noticiasj.Modelos.TutularesDeNoticias;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SeleccionarlistaItems, View.OnClickListener{
    RecyclerView recyclerView;
    Adapter adapter;
    ProgressDialog dialog;
    Button b1,b2,b3,b4,b5,b6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dialog = new ProgressDialog(this);
        dialog.setTitle("Cargando noticias...");
        dialog.show();

        b1=findViewById(R.id.b1);
        b1.setOnClickListener(this);
        b2=findViewById(R.id.b2);
        b2.setOnClickListener(this);
        b3=findViewById(R.id.b3);
        b3.setOnClickListener(this);
        b4=findViewById(R.id.b4);
        b4.setOnClickListener(this);
        b5=findViewById(R.id.b5);
        b5.setOnClickListener(this);
        b6=findViewById(R.id.b6);
        b6.setOnClickListener(this);


      llamadaAPI llamada = new llamadaAPI(this);
      llamada.getTutularesDeNoticias(listener, "general",null);
    }

    private final OyenteBusquedaDatos<APIRespuesta> listener = new OyenteBusquedaDatos<APIRespuesta>() {
        @Override
        public void onfetchData(List<TutularesDeNoticias> lista, String mansaje) {
            showNews(lista);
            dialog.dismiss();
        }

        @Override
        public void error(String mensaje) {

        }
    };

    private void showNews(List<TutularesDeNoticias> lista) {
        recyclerView= findViewById(R.id.recyclet_main);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
        adapter= new Adapter(this, lista, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void OnNewClicked(TutularesDeNoticias titulares) {
        startActivity(new Intent(MainActivity.this,DetallesNoticia.class)
            .putExtra("datos",titulares));
    }

    @Override
    public void onClick(View view) {
        Button button = (Button) view;
        String category = button.getText().toString();
        dialog.setTitle("Cargando las noticias de"+category);
        dialog.show();
        llamadaAPI llamada = new llamadaAPI(this);
        llamada.getTutularesDeNoticias(listener, category,null);
    }
}