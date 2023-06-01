package io.response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

public class ApiAdapter {


    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://localhost:8086/") // Reemplaza con la URL base de tu servidor
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

    ApiService apiService = retrofit.create(ApiService.class);



}
