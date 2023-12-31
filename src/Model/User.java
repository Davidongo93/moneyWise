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

    // create user constructor
    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    ;

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

    @Override
    public String toString() {
        return "User{" +
                "name='" + getName() + '\'' +
                ", email='" + getEmail() + '\'' +
                '}';
    }
}

/*    public List<Entry> getEntries() {
        return entries;
    }

    public void setEntries(Entry entry) {
        if (getEntries() == null) {
            entries = new ArrayList<>();
        }
        entries.add(entry);
    }
}*/
