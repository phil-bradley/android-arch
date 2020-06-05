package ie.philb.stackoverflowexample.screens;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import ie.philb.stackoverflowexample.R;
import ie.philb.stackoverflowexample.questions.Question;

public class QuestionsAdapter extends ArrayAdapter<Question> implements QuestionListItemView.Listener {

    public interface OnQuestionClickListener {
        void onQuestionClicked(Question question);
    }

    private final OnQuestionClickListener onQuestionClickListener;

    public QuestionsAdapter(@NonNull Context context, OnQuestionClickListener listener) {
        super(context, 0);
        this.onQuestionClickListener = listener;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            QuestionListItemView view = new QuestionListItemViewImpl(LayoutInflater.from(getContext()), parent);
            view.registerListener(this);
            convertView = view.getRootView();
            convertView.setTag(view);
        }

        final Question question = getItem(position);
        QuestionListItemView view = (QuestionListItemView) convertView.getTag();
        view.bindQuestion(question);

        return convertView;
    }

    @Override
    public void onQuestionClicked(Question question) {
        this.onQuestionClickListener.onQuestionClicked(question);
    }
}
