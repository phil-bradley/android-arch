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

    private static class ViewHolder {
        TextView textView;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_question_entry, parent, false);

            ViewHolder viewHolder = new ViewHolder();
            viewHolder.textView = convertView.findViewById(R.id.txtTitle);
            convertView.setTag(viewHolder);
        }

        final Question question = getItem(position);

        ViewHolder viewHolder = (ViewHolder) convertView.getTag();
        viewHolder.textView.setText(question.getTitle());

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
