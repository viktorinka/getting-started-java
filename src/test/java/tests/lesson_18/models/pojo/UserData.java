package tests.lesson_18.models.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserData {
    private UserPojo data;

    public UserPojo getData() {
        return data;
    }

    public void setData(UserPojo data) {
        this.data = data;
    }
}
