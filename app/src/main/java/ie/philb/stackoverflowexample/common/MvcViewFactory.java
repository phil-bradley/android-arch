package ie.philb.stackoverflowexample.common;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import ie.philb.stackoverflowexample.screens.QuestionListItemMvcView;
import ie.philb.stackoverflowexample.screens.QuestionListItemMvcViewImpl;
import ie.philb.stackoverflowexample.screens.QuestionsListMvcView;
import ie.philb.stackoverflowexample.screens.QuestionsListMvcViewImpl;

public class MvcViewFactory {

    private final LayoutInflater inflater;

    public MvcViewFactory(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    public QuestionsListMvcView getQuestionsListMvcView(@Nullable ViewGroup parent) {
        return new QuestionsListMvcViewImpl(inflater, parent, this);
    }

    public QuestionListItemMvcView getQuestionListItemMvcView(@Nullable ViewGroup parent) {
        return new QuestionListItemMvcViewImpl(inflater, parent);
    }
}
