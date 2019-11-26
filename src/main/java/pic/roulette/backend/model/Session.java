package pic.roulette.backend.model;

import java.util.ArrayList;
import org.springframework.data.annotation.Id;

public class Session {
    // pair class to hold username->picurl
    // member vars
    @Id
    private String sessionId;
    private ArrayList<UserUrlPair> pictureUrls;

    //ctor
    public Session(String sessionId) {
        this.sessionId = sessionId;
        this.pictureUrls = new ArrayList<UserUrlPair>();
    }

    //getters
    public String getSessionId() {return this.sessionId;}
    public ArrayList<UserUrlPair> getPictureUrls() {return this.pictureUrls;}

    //setters
    public void setSessionId(String sessionId) {this.sessionId = sessionId;}
    public void setPictureUrls(ArrayList<UserUrlPair> pictureUrls) {this.pictureUrls = pictureUrls;}
}