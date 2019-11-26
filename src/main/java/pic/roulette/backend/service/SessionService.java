package pic.roulette.backend.service;

import java.util.ArrayList;
import java.util.Optional;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import pic.roulette.backend.repository.SessionRepository;
import pic.roulette.backend.model.Session;
import pic.roulette.backend.model.UserUrlPair;

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
            if (!sessionRepo.findById(sessionId).isPresent()) break;
        }
        System.out.println(sessionId);
        Session newSession = new Session(sessionId);
        sessionRepo.save(newSession);
        return sessionId;
    }

    //add picture url to session
    public boolean addPicture(String sessionId, String username, String picUrl) {
        Optional<Session> session = sessionRepo.findById(sessionId);
        if (session.isPresent()) {
            ArrayList<UserUrlPair> pictureUrls = session.get().getPictureUrls();
            pictureUrls.add(new UserUrlPair(username, picUrl));
            sessionRepo.save(session.get());
            return true;
        }
        return false;
    }

    //get all picture urls for a sessionId
    public ArrayList<UserUrlPair> getAllPictures(String sessionId) {
        Optional<Session> session = sessionRepo.findById(sessionId);
        if (session.isPresent()) return session.get().getPictureUrls();
        return null;
    }

    //get all picture urls for a sessionId
    public boolean removeAllPictures(String sessionId) {
        Optional<Session> session = sessionRepo.findById(sessionId);
        if (session.isPresent()) {
            session.get().getPictureUrls().clear();
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
