package io.response;

import com.example.easydrip.model.Usuario;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {
    @POST("/login")
    static Call<String> loginUsuario(String nick, String contraseña) {

        Call<String> loginUsuario(@Query("nick") String nick, @Query("pass") String contraseña);
    }

    /*@GET("login")
    public call<Usuario> find(@)
    */
}

