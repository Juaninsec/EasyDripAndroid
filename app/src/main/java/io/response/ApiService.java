package io.response;

import android.widget.EditText;

import com.example.easydrip.model.Usuario;
import com.google.gson.JsonObject;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {


    @POST("/login")
    Call<Usuario> loginUsuario(@Query("nick") String nick, @Query("pass") String contrasena);



}

