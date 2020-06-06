package ie.philb.stackoverflowexample.screens;

import java.util.List;

import ie.philb.stackoverflowexample.common.ObservableMvcView;
import ie.philb.stackoverflowexample.questions.Question;

public interface QuestionsListMvcView extends ObservableMvcView<QuestionsListMvcView.Listener> {

    interface Listener {
        void onQuestionClicked(Question question);
    }

    void bindQuestions(List<Question> questions);
}
