package ie.philb.stackoverflowexample.screens;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ie.philb.stackoverflowexample.R;
import ie.philb.stackoverflowexample.common.BaseMvcView;
import ie.philb.stackoverflowexample.common.BaseObservableMvcView;
import ie.philb.stackoverflowexample.common.ObservableMvcView;
import ie.philb.stackoverflowexample.questions.Question;


public class QuestionsListMvcViewImpl
        extends BaseObservableMvcView<QuestionsListMvcView.Listener>
        implements QuestionsRecyclerViewAdapter.OnQuestionClickListener, QuestionsListMvcView {

    private RecyclerView lstQuestions;
    private QuestionsRecyclerViewAdapter questionsAdapter;

    public QuestionsListMvcViewImpl(LayoutInflater inflater, ViewGroup parent) {
        setRootView(inflater.inflate(R.layout.layout_questions, parent, false));

        this.lstQuestions = findViewById(R.id.lstQuestions);
        this.lstQuestions.setLayoutManager(new LinearLayoutManager(getContext()));
        this.questionsAdapter = new QuestionsRecyclerViewAdapter(inflater, this);
        this.lstQuestions.setAdapter(this.questionsAdapter);
    }

    @Override
    public void bindQuestions(List<Question> questions) {
        questionsAdapter.bindQuestions(questions);
    }

    @Override
    public void onQuestionClicked(Question question) {
        for (Listener listener : getListeners()) {
            listener.onQuestionClicked(question);
        }
    }
}