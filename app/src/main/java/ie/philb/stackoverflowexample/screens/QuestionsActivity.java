package ie.philb.stackoverflowexample.screens;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import ie.philb.stackoverflowexample.common.Constants;
import ie.philb.stackoverflowexample.network.QuestionSchema;
import ie.philb.stackoverflowexample.network.QuestionsListResponseSchema;
import ie.philb.stackoverflowexample.network.StackOverflowApi;
import ie.philb.stackoverflowexample.questions.Question;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class QuestionsActivity extends AppCompatActivity implements QuestionsListViewImpl.Listener {

    private StackOverflowApi api;
    private QuestionsListViewImpl questionsListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.questionsListView = new QuestionsListViewImpl(LayoutInflater.from(this), null);
        this.questionsListView.registerListener(this);

        this.api = new Retrofit.
                Builder().
                baseUrl(Constants.BASE_URL).
                addConverterFactory(GsonConverterFactory.create()).
                build().
                create(StackOverflowApi.class);

        setContentView(this.questionsListView.getRootView());
    }

    @Override
    protected void onStart() {
        super.onStart();
        fetchQuestions();
    }

    private void fetchQuestions() {
        api.getQuestions(20).
                enqueue(new Callback<QuestionsListResponseSchema>() {
                    @Override
                    public void onResponse(Call<QuestionsListResponseSchema> call, Response<QuestionsListResponseSchema> response) {
                        if (response.isSuccessful()) {
                            setQuestions(response.body().getQuestions());
                        } else {
                            handleError("Response: " + response.toString());
                        }
                    }

                    @Override
                    public void onFailure(Call<QuestionsListResponseSchema> call, Throwable t) {
                        Log.e("Questions", "Error: Failed to retrieve questions", t);
                        handleError("Error: " + t.getMessage());
                    }
                });
    }

    private void setQuestions(List<QuestionSchema> questionsResponse) {
        List<Question> questions = new ArrayList<>();

        for (QuestionSchema qs : questionsResponse) {
            questions.add(new Question(qs.getId(), qs.getTitle()));
        }

        questionsListView.bindQuestions(questions);
    }

    private void handleError(String msg) {
        Toast.makeText(this, "Something went wrong: " + msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onQuestionClicked(Question question) {
        Toast.makeText(this, "Question clicked " + question.getTitle(), Toast.LENGTH_LONG).show();
    }
}