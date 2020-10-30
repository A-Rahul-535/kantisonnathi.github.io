package in.ac.bitspilani.webapp.model;

import javax.persistence.*;

@Entity
@Table(name="user")
public class UserEntity  {
    @Id@GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String userName;
    private String password;


    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
