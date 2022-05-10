package com.example.noticiasj;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class CstomViewHolder extends RecyclerView.ViewHolder {
    TextView text_titulo, text_fuente;
    ImageView img;
    CardView cardView;
    public CstomViewHolder(@NonNull View itemView) {
        super(itemView);

        text_titulo=itemView.findViewById(R.id.text_titulo);
        text_fuente=itemView.findViewById(R.id.text_fuente);
        img=itemView.findViewById(R.id.img_noticia);
        cardView=itemView.findViewById(R.id.main_container);
    }
}
