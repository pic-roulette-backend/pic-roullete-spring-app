package pic.roulette.backend.model;

import java.util.ArrayList;
import org.springframework.data.annotation.Id;

public class Session {
    // pair class to hold username->picurl
    // member vars
    @Id
    private String sessionId;
    private ArrayList<Text> messages;

    //ctor
    public Session(String sessionId) {
        this.sessionId = sessionId;
        this.messages = new ArrayList<Text>();
    }

    //getters
    public String getSessionId() {return this.sessionId;}
    public ArrayList<Text> getMessages() {return this.messages;}

    //setters
    public void setSessionId(String sessionId) {this.sessionId = sessionId;}
    public void setMessages(ArrayList<Text> pictureUrls) {this.messages = pictureUrls;}
}