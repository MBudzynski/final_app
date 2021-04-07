package pl.sda.finalapp.users;

public class UserExistsExeption extends Exception {
    public UserExistsExeption(String msg) {
        super(msg);
    }
}
