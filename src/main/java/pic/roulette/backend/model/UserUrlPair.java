package pic.roulette.backend.model;

public class UserUrlPair {
    //member vars
    String username;
    String picUrl;

    //ctor
    public UserUrlPair(String username, String picUrl) {
        this.username = username;
        this.picUrl = picUrl;
    }

    //getters
    public String getUsername() {return this.username;}
    public String getPicUrl() {return this.picUrl;}

    //setters
    public void setUsername(String username) {this.username = username;}
    public void setPicUrl(String picUrl) {this.picUrl = picUrl;}
}