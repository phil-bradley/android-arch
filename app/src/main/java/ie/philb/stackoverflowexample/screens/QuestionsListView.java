package ie.philb.stackoverflowexample.screens;

import java.util.List;

import ie.philb.stackoverflowexample.questions.Question;

public interface QuestionsListView {

    interface Listener {
        void onQuestionClicked(Question question);
    }

    void registerListener(Listener l);

    void unRegisterListener(Listener l);

    void bindQuestions(List<Question> questions);
}
