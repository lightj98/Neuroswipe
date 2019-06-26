package com.nsa.cubric.application.controllers.API;

import com.nsa.cubric.application.domain.Account;
import com.nsa.cubric.application.domain.Feedback;
import com.nsa.cubric.application.domain.FeedbackOverview;
import com.nsa.cubric.application.dto.PaginatedList;
import com.nsa.cubric.application.services.AccountService;
import com.nsa.cubric.application.services.FeedbackService;
import com.nsa.cubric.application.services.LoggedUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/feedback")
@RestController
public class FeedbackAPI {
    private LoggedUserService loggedUserService;
    private AccountService accountService;
    private FeedbackService feedbackService;

    @Autowired
    public FeedbackAPI(LoggedUserService loggedUserService, AccountService accountService, FeedbackService feedbackService) {
        this.loggedUserService = loggedUserService;
        this.accountService = accountService;
        this.feedbackService = feedbackService;
    }

    /**
     * This method is accepts posted JSON containing feedback information. It responds to POST
     * requests to /feedback.
     * @return Boolean true indicating success.
     */
//    @PostMapping(value = "/", produces = "application/json")
//    public ResponseEntity addFeedback(@RequestParam(value = "feedbackText") String feedbackText) {
//        if(loggedUserService.getUsername() == null){
//            return new ResponseEntity<>(false, null, HttpStatus.FORBIDDEN);
//        }
//        Account loggedInUser = accountService.getAccountByEmail(loggedUserService.getUsername());
//        Feedback feedback = new Feedback(null, loggedInUser.getId(), feedbackText);
//        feedbackService.insertNewFeedback(feedback);
//        return new ResponseEntity<>(true, null, HttpStatus.OK);
//    }

    /**
     * This method is used to return the JSON for all the feedback entries. It responds to GET
     * requests to /feedback.
     * @return ResponseEntity object containing JSON.
     */
//    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
//    public ResponseEntity getFeedback() {
//        List<Feedback> feedback = feedbackService.getAll();
//
//        for (Feedback feedbackObject : feedback) {
//            Account account = accountService.getAccountById(feedbackObject.getUserProfileId());
//            feedbackObject.setUserEmail(account.getEmail());
//        }
//
//        return new ResponseEntity<>(feedback, null, HttpStatus.OK);
//    }

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity getFeedbackData(){
        FeedbackOverview overview = feedbackService.getFeedbackOverview();
        return new ResponseEntity<>(overview, null, HttpStatus.OK);
    }

    @RequestMapping(value = "/comments", method = RequestMethod.GET)
    public ResponseEntity getFeedbackComments(@RequestParam(value = "page") int page, @RequestParam(value = "page-size") int pageSize){
        PaginatedList data = feedbackService.getFeedbackComments(page, pageSize);
        return new ResponseEntity(data, HttpStatus.OK);
    }
}
