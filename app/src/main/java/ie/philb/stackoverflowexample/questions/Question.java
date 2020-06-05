package ie.philb.stackoverflowexample.questions;

public class Question {

    private final String id;
    private final String title;

    public Question(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
