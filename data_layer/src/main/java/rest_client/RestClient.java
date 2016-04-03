package rest_client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import services.PostService;

public class RestClient {
    Retrofit retrofit;


    public RestClient(){
        // we initialize the gson builder
        Gson gson = new GsonBuilder()
                .serializeNulls()
                .create();

        // it's really useful
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        int cacheSize = 10 * 1024 * 1024; // 10 MiB


        // okhttp3 client
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        // create Retrofit
        retrofit = new Retrofit.Builder()
                .baseUrl(RestEndpoint.ENDPOINT)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }

    public PostService getPostService() {
        return retrofit.create(PostService.class);
    }
}
