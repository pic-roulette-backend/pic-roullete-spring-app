package pic.roulette.backend.service;

import java.util.ArrayList;
import java.util.Optional;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import pic.roulette.backend.repository.SessionRepository;
import pic.roulette.backend.model.Session;
import pic.roulette.backend.model.Text;

@Service
public class SessionService {
    //session database
    @Autowired
    SessionRepository sessionRepo;

    //create session
    public String createSession() {
        String sessionId = null;
        while (true) {
            sessionId = RandomStringUtils.randomAlphanumeric(8);
            if (!sessionRepo.existsById(sessionId)) break;
        }
        sessionRepo.save(new Session(sessionId));
        return sessionId;
    }

    //create session
    public Boolean joinSession(String sessionId) {
        return sessionRepo.existsById(sessionId);
    }

    //add picture url to session
    public boolean addMessage(String sessionId, String username, String message) {
        Optional<Session> session = sessionRepo.findById(sessionId);
        if (session.isPresent()) {
            ArrayList<Text> pictureUrls = session.get().getMessages();
            Integer id  = pictureUrls.size() + 1;

            pictureUrls.add(new Text(id, username, message));
            sessionRepo.save(session.get());
            return true;
        }
        return false;
    }

    //get all picture urls for a sessionId
    public ArrayList<Text> getAllMessages(String sessionId) {
        Optional<Session> session = sessionRepo.findById(sessionId);
        if (session.isPresent()) return session.get().getMessages();
        return null;
    }

    //get all picture urls for a sessionId
    public boolean removeAllMessages(String sessionId) {
        Optional<Session> session = sessionRepo.findById(sessionId);
        if (session.isPresent()) {
            session.get().getMessages().clear();
            sessionRepo.save(session.get());
            return true;
        }
        return false;
    }

    //get all sessions
    public Iterable<Session> getAllSessions() {
        return sessionRepo.findAll();
    }
}
