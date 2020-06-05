package ie.philb.stackoverflowexample.network;

import ie.philb.stackoverflowexample.common.Constants;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface StackOverflowApi {

    @GET("/questions?key=" + Constants.STACKOVERFLOW_API_KEY)
    Call<QuestionsListResponseSchema> foo();

    @GET("/questions?key=" + Constants.STACKOVERFLOW_API_KEY + "&sort=activity&order=desc&site=stackoverflow&filter=withbody")
    Call<QuestionsListResponseSchema> getQuestions(@Query("pagesize") Integer pageSize);

}
