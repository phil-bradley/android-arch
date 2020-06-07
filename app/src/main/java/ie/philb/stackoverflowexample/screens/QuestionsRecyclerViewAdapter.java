package ie.philb.stackoverflowexample.screens;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ie.philb.stackoverflowexample.common.MvcViewFactory;
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

    private final OnQuestionClickListener onQuestionClickListener;
    private MvcViewFactory mvcViewFactory;

    public QuestionsRecyclerViewAdapter(OnQuestionClickListener listener, MvcViewFactory mvcViewFactory) {
        this.onQuestionClickListener = listener;
        this.mvcViewFactory = mvcViewFactory;
    }

    public void bindQuestions(List<Question> questions) {
        this.questions.clear();
        this.questions.addAll(questions);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public QuestionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        QuestionListItemMvcView view = mvcViewFactory.getQuestionListItemMvcView(parent);
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