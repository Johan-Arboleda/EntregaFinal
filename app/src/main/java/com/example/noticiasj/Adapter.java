package com.example.noticiasj;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.noticiasj.Modelos.TutularesDeNoticias;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<CstomViewHolder> {
    private Context context;
    private List<TutularesDeNoticias> titulares;
    private SeleccionarlistaItems seleccionarlistaItems;

    public Adapter(Context context, List<TutularesDeNoticias> titulares, SeleccionarlistaItems seleccionarlistaItems) {
        this.context = context;
        this.titulares = titulares;
        this.seleccionarlistaItems= seleccionarlistaItems;
    }

    @NonNull
    @Override
    public CstomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CstomViewHolder(LayoutInflater.from(context).inflate(R.layout.headline_list_items,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CstomViewHolder holder, int position) {
        holder.text_titulo.setText(titulares.get(position).getTitle());
        holder.text_fuente.setText(titulares.get(position).getSource().getName());

        if (titulares.get(position).getClass()!=null){
            Picasso.get().load(titulares.get(position).getUrlToImage()).into(holder.img);
        }


        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                seleccionarlistaItems.OnNewClicked(titulares.get(position) );
            }
        });
    }

    @Override
    public int getItemCount() {
        return titulares.size();
    }
}
