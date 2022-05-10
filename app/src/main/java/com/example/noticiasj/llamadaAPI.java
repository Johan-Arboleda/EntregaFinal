package com.example.noticiasj;

import android.content.Context;
import android.widget.Toast;

import com.example.noticiasj.Modelos.APIRespuesta;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class llamadaAPI {
    Context context;

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();


    public void getTutularesDeNoticias(OyenteBusquedaDatos listener, String category, String query){
        llamadaNweAPI llamadaNweAPI=retrofit.create(llamadaAPI.llamadaNweAPI.class);
        Call<APIRespuesta> call = llamadaNweAPI.llamarTitulares("co", category,query,context.getString(R.string.api_key));

        try{
            call.enqueue(new Callback<APIRespuesta>() {
                @Override
                public void onResponse(Call<APIRespuesta> call, Response<APIRespuesta> response) {
                    if(response.isSuccessful()){
                        Toast.makeText(context, "error01!!", Toast.LENGTH_SHORT).show();
                    }
                    listener.onfetchData(response.body().getArticles(), response.message());
                }

                @Override
                public void onFailure(Call<APIRespuesta> call, Throwable t) {
                    listener.error("Consulta fallida");
                }
            });
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public llamadaAPI(Context context) {
        this.context = context;
    }

    public interface  llamadaNweAPI{
        @GET("top-headlines")
        Call<APIRespuesta> llamarTitulares(
                @Query("country") String country,
                @Query("category") String category,
                @Query ("q") String query,
                @Query("apiKey") String api_key
        );
    }
}
