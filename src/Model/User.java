package Model;
import java.util.ArrayList;
import java.util.List;
public class User {
    private String id;

    private String name;
    private String email;
    private String password;
    private List<Entry> entries;

    public User() {
    }
//full constructor
    public User(String id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }
    // create user constructor

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
    // login constructor
    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Entry> getEntries() {
        return entries;
    }

    public void setEntries(List<Entry> entries) {
        this.entries = entries;
    }
}
