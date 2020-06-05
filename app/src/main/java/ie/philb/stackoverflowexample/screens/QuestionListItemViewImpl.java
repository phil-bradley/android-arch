package ie.philb.stackoverflowexample.screens;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import ie.philb.stackoverflowexample.R;
import ie.philb.stackoverflowexample.questions.Question;

public class QuestionListItemViewImpl implements QuestionListItemView {

    private final List<Listener> listeners = new ArrayList<>();
    private View rootView;
    private Question question;
    private TextView textView;

    public QuestionListItemViewImpl(LayoutInflater inflater, ViewGroup parent) {
        this.rootView = inflater.inflate(R.layout.layout_question_entry, parent, false);
        this.textView = findViewById(R.id.txtTitle);

        getRootView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (Listener listener : listeners) {
                    listener.onQuestionClicked(question);
                }
            }
        });
    }

    private <T extends View> T findViewById(int id) {
        return rootView.findViewById(id);
    }

    @Override
    public View getRootView() {
        return this.rootView;
    }

    @Override
    public void registerListener(Listener listener) {
        this.listeners.add(listener);
    }

    @Override
    public void unRegisterListener(Listener listener) {
        this.listeners.remove(listener);
    }

    @Override
    public void bindQuestion(Question question) {
        this.question = question;
        this.textView.setText(question.getTitle());
    }
}
