package ie.philb.stackoverflowexample.common;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import ie.philb.stackoverflowexample.screens.QuestionsListMvcView;
import ie.philb.stackoverflowexample.screens.QuestionsListMvcViewImpl;

public class MvcViewFactory {

    private final LayoutInflater inflater;

    public MvcViewFactory(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    public QuestionsListMvcView getQuestionsListMvcView(ViewGroup parent) {
        return new QuestionsListMvcViewImpl(inflater, parent);
    }
}
