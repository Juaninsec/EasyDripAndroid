package io.response;

import android.widget.EditText;

import com.example.easydrip.model.Usuario;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    @POST("/login")
    public Call<Usuario> loginUsuario(@Query("nick") String nick, @Query("pass") String contraseña);



   /* @FormUrlEncoded
    @POST("update-status")
    Call<JsonObject> getUpdateStatus(@Field("token") String token, @Field("status") String status);


      @POST("/login")
      Call<String> loginUsuario(@Query("nick") String nick, @Query("pass") String contraseña);

*/


    /*@GET("login")
    public call<Usuario> find(@)
    */
}

