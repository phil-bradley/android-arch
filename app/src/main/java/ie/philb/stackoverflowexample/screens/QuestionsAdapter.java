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

public class QuestionsAdapter extends ArrayAdapter<Question> {

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
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_question_entry, parent, false);
        }

        final Question question = getItem(position);

        TextView txtTitle = convertView.findViewById(R.id.txtTitle);
        txtTitle.setText(question.getTitle());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicked(question);
            }
        });

        return convertView;
    }

    private void clicked(Question question) {
        this.onQuestionClickListener.onQuestionClicked(question);
    }
}
