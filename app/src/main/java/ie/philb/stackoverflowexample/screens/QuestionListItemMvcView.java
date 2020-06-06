package ie.philb.stackoverflowexample.screens;

import ie.philb.stackoverflowexample.common.ObservableMvcView;
import ie.philb.stackoverflowexample.questions.Question;

public interface QuestionListItemMvcView extends ObservableMvcView<QuestionListItemMvcView.Listener> {

    public interface Listener {
        void onQuestionClicked(Question question);
    }

    void bindQuestion(Question question);
}
