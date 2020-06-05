package ie.philb.stackoverflowexample.screens;

import android.view.View;

import ie.philb.stackoverflowexample.questions.Question;

public interface QuestionListItemView {

    public interface Listener {
        void onQuestionClicked(Question question);
    }

    View getRootView();

    void registerListener(Listener listener);

    void unRegisterListener(Listener listener);

    void bindQuestion(Question question);
}
