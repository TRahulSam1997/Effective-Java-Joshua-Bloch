package chapter4.item15.user;

// Package-private class: only accessible within chapter4.item15.user package
// UserDataProcessor is part of the internal logic of the user package.
// External clients can use UserService without knowing about UserDataProcessor.
class UserDataProcessor {
    void process(String data) {
        // Processing logic
        System.out.println("Processing user data: " + data);
    }
}

// Public class uses UserDataProcessor internally
public class UserService {
    public void updateUserProfile(String data) {
        UserDataProcessor processor = new UserDataProcessor();
        processor.process(data);
    }
}