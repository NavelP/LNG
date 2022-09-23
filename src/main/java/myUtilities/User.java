package myUtilities;


public class User {

    public String username;
    public String password;
    public String nationalid;

    public User(String username, String password, String nationalid) {
        this.username = username;
        this.password = password;
        this.nationalid = nationalid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNationalid() {
        return nationalid;
    }

    public void setNationalid(String nationalid) {
        this.nationalid = nationalid;
    }
}
