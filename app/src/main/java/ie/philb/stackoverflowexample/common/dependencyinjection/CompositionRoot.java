package ie.philb.stackoverflowexample.common.dependencyinjection;

import ie.philb.stackoverflowexample.common.Constants;
import ie.philb.stackoverflowexample.network.StackOverflowApi;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CompositionRoot {

    private Retrofit retrofit;

    public StackOverflowApi getStackOverflowApi() {
       return getRetrofit().create(StackOverflowApi.class);
    }

    private Retrofit getRetrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(Constants.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }

        return retrofit;
    }
}
