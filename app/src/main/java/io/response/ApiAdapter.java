package io.response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

public class ApiAdapter {

    private static  final String BASE_URL = " http://46.101.208.101:8080/";
    private static ApiAdapter mInstance;
    private Retrofit retrofit;

    Retrofit ApiAdapter = new Retrofit.Builder()
            .baseUrl("http://localhost:8086/") // Reemplaza con la URL base de tu servidor
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

    ApiService apiService = retrofit.create(ApiService.class);

    public static synchronized ApiAdapter getInstance() {
        if (mInstance == null) {
            mInstance = new ApiAdapter();
        }
        return mInstance;
    }
    public ApiService getAPI () {
        return retrofit.create(ApiService.class);
    }


}
