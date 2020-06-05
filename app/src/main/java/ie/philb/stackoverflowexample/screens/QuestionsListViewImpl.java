package ie.philb.stackoverflowexample.screens;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import ie.philb.stackoverflowexample.R;
import ie.philb.stackoverflowexample.questions.Question;


public class QuestionsListViewImpl implements QuestionsAdapter.OnQuestionClickListener, QuestionsListView {

    @Override
    public void registerListener(Listener l) {
        this.listeners.add(l);
    }

    @Override
    public void unRegisterListener(Listener l) {
        this.listeners.remove(l);
    }

    private final List<Listener> listeners = new ArrayList<>();
    private ListView lstQuestions;
    private QuestionsAdapter questionsAdapter;

    private final View rootView;

    public QuestionsListViewImpl(LayoutInflater inflater, ViewGroup parent) {
        rootView = inflater.inflate(R.layout.layout_questions, parent, false);

        this.questionsAdapter = new QuestionsAdapter(getContext(), this);

        this.lstQuestions = findViewById(R.id.lstQuestions);
        this.lstQuestions.setAdapter(this.questionsAdapter);

    }

    private Context getContext() {
        return getRootView().getContext();
    }

    private <T extends View> T findViewById(int id) {
        return getRootView().findViewById(id);
    }

    public View getRootView() {
        return this.rootView;
    }

    @Override
    public void bindQuestions(List<Question> questions) {
        questionsAdapter.clear();
        questionsAdapter.addAll(questions);
        questionsAdapter.notifyDataSetChanged();
    }

    @Override
    public void onQuestionClicked(Question question) {
        for (Listener listener : listeners) {
            listener.onQuestionClicked(question);
        }
    }
}
