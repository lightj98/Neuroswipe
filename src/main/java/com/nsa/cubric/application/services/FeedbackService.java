package com.nsa.cubric.application.services;

import com.nsa.cubric.application.domain.Feedback;
import com.nsa.cubric.application.domain.FeedbackForm;
import com.nsa.cubric.application.domain.FeedbackOverview;

import java.util.List;

public interface FeedbackService {
    FeedbackOverview getFeedbackOverview();
    void insertNewFeedback(FeedbackForm feedbackForm);
    List<String> getFeedbackComments();

}
