package ie.philb.stackoverflowexample.screens;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ie.philb.stackoverflowexample.R;
import ie.philb.stackoverflowexample.common.BaseMvcView;
import ie.philb.stackoverflowexample.common.BaseObservableMvcView;
import ie.philb.stackoverflowexample.questions.Question;

public class QuestionListItemMvcViewImpl extends BaseObservableMvcView<QuestionListItemMvcView.Listener> implements QuestionListItemMvcView {

    private Question question;
    private TextView textView;

    public QuestionListItemMvcViewImpl(LayoutInflater inflater, ViewGroup parent) {
        setRootView(inflater.inflate(R.layout.layout_question_entry, parent, false));

        this.textView = findViewById(R.id.txtTitle);

        getRootView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (Listener listener : getListeners()) {
                    listener.onQuestionClicked(question);
                }
            }
        });
    }

    @Override
    public void bindQuestion(Question question) {
        this.question = question;
        this.textView.setText(question.getTitle());
    }
}
