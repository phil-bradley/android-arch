package ie.philb.stackoverflowexample.screens;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ie.philb.stackoverflowexample.questions.Question;

public class QuestionsRecyclerViewAdapter extends RecyclerView.Adapter<QuestionsRecyclerViewAdapter.QuestionViewHolder> implements QuestionListItemMvcView.Listener {

    public interface OnQuestionClickListener {
        void onQuestionClicked(Question question);
    }

    static class QuestionViewHolder extends  RecyclerView.ViewHolder {

        private QuestionListItemMvcView itemView;

        public QuestionViewHolder(@NonNull QuestionListItemMvcView itemView) {
            super(itemView.getRootView());
            this.itemView = itemView;
        }
    }


    private final List<Question> questions = new ArrayList<>();

    private final LayoutInflater inflater;
    private final OnQuestionClickListener onQuestionClickListener;

    public QuestionsRecyclerViewAdapter(LayoutInflater inflater, OnQuestionClickListener listener) {
        this.inflater = inflater;
        this.onQuestionClickListener = listener;
    }

    public void bindQuestions(List<Question> questions) {
        this.questions.clear();
        this.questions.addAll(questions);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public QuestionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        QuestionListItemMvcView view = new QuestionListItemMvcViewImpl(inflater, parent);
        view.registerListener(this);
        return new QuestionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionViewHolder holder, int position) {
        holder.itemView.bindQuestion(questions.get(position));
    }

    @Override
    public int getItemCount() {
    return this.questions.size();
    }

    @Override
    public void onQuestionClicked(Question question) {
        this.onQuestionClickListener.onQuestionClicked(question);
    }
}