package com.example.noticiasj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.noticiasj.Modelos.TutularesDeNoticias;
import com.squareup.picasso.Picasso;

public class DetallesNoticia extends AppCompatActivity {
    TutularesDeNoticias titulares;
    TextView titulo, autor, time,detalles,contenido;
    ImageView img_noticia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_noticia);

        titulo= findViewById(R.id.text_detalle_titulo);
        autor=findViewById(R.id.text_detalles_autor);
        time=findViewById(R.id.text_detalles_time);
        detalles=findViewById(R.id.text_detalles_detalle);
        contenido=findViewById(R.id.text_detalles_contenido);
        img_noticia=findViewById(R.id.img_detalles);

        titulares= (TutularesDeNoticias) getIntent().getSerializableExtra("datos");

        titulo.setText(titulares.getTitle());
        autor.setText(titulares.getAuthor());
        time.setText(titulares.getPublishedAt());
        detalles.setText(titulares.getDescription());
        contenido.setText(titulares.getContent());
        Picasso.get().load(titulares.getUrlToImage()).into(img_noticia);
    }
}