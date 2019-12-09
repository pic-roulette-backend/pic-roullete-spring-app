package pic.roulette.backend.model;

import org.springframework.data.annotation.Id;

public class Text {
    //member vars
    @Id
    Integer id;
    String username;
    String message;

    //ctor
    public Text(Integer id, String username, String message) {
        this.id = id;
        this.username = username;
        this.message = message;
    }

    //getters
    public Integer getId() {return this.id;}
    public String getUsername() {return this.username;}
    public String getTextMessages() {return this.message;}

    //setters
    public void setId(Integer id) {this.id = id;}
    public void setUsername(String username) {this.username = username;}
    public void setTextMessages(String message) {this.message = message;}
}