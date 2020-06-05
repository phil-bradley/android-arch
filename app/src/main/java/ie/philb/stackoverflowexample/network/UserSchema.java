package ie.philb.stackoverflowexample.network;

import com.google.gson.annotations.SerializedName;

public class UserSchema {

    @SerializedName("display_name")
    private final String userName;

    @SerializedName("profile_image")
    private final String avatarUrl;

    public UserSchema(String userName, String avatarUrl) {
        this.userName = userName;
        this.avatarUrl = avatarUrl;
    }

    public String getUserName() {
        return userName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    @Override
    public String toString() {
        return "UserSchema{" +
                "userName='" + userName + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                '}';
    }
}
