package pic.roulette.backend.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import pic.roulette.backend.model.Session;
import pic.roulette.backend.model.UserUrlPair;
import pic.roulette.backend.service.SessionService;

@RestController
public class SessionController
{
    @Autowired
    SessionService sessionService;

    // create a new session to store game data
    @RequestMapping(value = "/session/create", method = RequestMethod.POST)
    @ApiOperation(value = "An api function to create a new session to save game data." )
    public String createSession() {
        return sessionService.createSession();
    }

    // check that session id is valid
    @RequestMapping(value = "/session/join/{sessionId}", method = RequestMethod.GET)
    @ApiOperation(value = "An api function to validate a session id." )
    public Boolean joinSession(@PathVariable("sessionId") String sessionId) {
        return sessionService.joinSession(sessionId);
    }

    // add picture to session's saved game data
    @RequestMapping(value = "/session/addPicture/{sessionId}", method = RequestMethod.POST)
    @ApiOperation(value = "An api function to add a picture to a session's saved game data." )
    public boolean addPicture(@PathVariable("sessionId") String sessionId, @Valid @RequestBody UserUrlPair p) {
        return sessionService.addPicture(sessionId, p.getUsername(), p.getPicUrl());
    }

    //get all pictures for a session
    @RequestMapping(value = "/session/getAllPictures/{sessionId}", method = RequestMethod.GET)
    @ApiOperation(value = "An api function to get all picture URLs posted to a session." )
    public ArrayList<UserUrlPair> getAllPictures(@PathVariable("sessionId") String sessionId) {
        return sessionService.getAllPictures(sessionId);
    }

    //remove all pictures
    @RequestMapping(value = "/session/removeAllPictures/{sessionId}", method = RequestMethod.POST)
    @ApiOperation(value = "An api function to remove all picture URLs posted to a session." )
    public boolean removeAllPictures(@PathVariable("sessionId") String sessionId) {
        return sessionService.removeAllPictures(sessionId);
    }

    //get all sessions
    @RequestMapping(value = "/session/getAll", method = RequestMethod.GET)
    @ApiOperation(value = "An api function to get all sessions stored in the database." )
    public Iterable<Session> getAllSessions() {
        return sessionService.getAllSessions();
    }
}