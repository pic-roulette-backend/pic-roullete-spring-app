package pic.roulette.backend.model;

public class Text {
    //member vars
    String username;
    String message;

    //ctor
    public Text(String username, String message) {
        this.username = username;
        this.message = message;
    }

    //getters
    public String getUsername() {return this.username;}
    public String getTextMessages() {return this.message;}

    //setters
    public void setUsername(String username) {this.username = username;}
    public void setTextMessages(String message) {this.message = message;}
}