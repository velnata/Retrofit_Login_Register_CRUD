package farid.example.com.retrofitrecyclerview.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Farid on 09/05/2017.
 */

public class ApiCLient {
    public static final String BASE_URL = "http://192.168.43.179/logincrud/index.php/api/";

    public static Retrofit  retrofit;

    public static Retrofit getCLient() {
        if (retrofit == null){

            retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
