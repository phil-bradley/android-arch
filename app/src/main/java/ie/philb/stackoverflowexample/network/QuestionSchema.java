package ie.philb.stackoverflowexample.network;

import com.google.gson.annotations.SerializedName;

public class QuestionSchema {

    @SerializedName("title")
    private final String title;

    @SerializedName("question_id")
    private final String id;

    @SerializedName("body")
    private final String body;

    @SerializedName("owner")
    private final UserSchema owner;

    public QuestionSchema(String title, String id, String body, UserSchema owner) {
        this.title = title;
        this.id = id;
        this.body = body;
        this.owner = owner;
    }

    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    public UserSchema getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        return "QuestionSchema{" +
                "title='" + title + '\'' +
                ", id='" + id + '\'' +
                ", body='" + body + '\'' +
                ", owner=" + owner +
                '}';
    }
}
