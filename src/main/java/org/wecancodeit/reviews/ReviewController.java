package org.wecancodeit.reviews;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReviewController {

    private ReviewStorage reviewStorage;

    public ReviewController(ReviewStorage reviewStorage) {
        this.reviewStorage = reviewStorage;
    }

    @RequestMapping("/reviews")
    public String displayReviews(Model model) {
        model.addAttribute("reviews", reviewStorage.findAllReviews());
        return "ListOfReviews";
    }

    @RequestMapping("/reviews/{reviewName}")
    public String displaySingleReview(@PathVariable String reviewName, Model model) {
        Review retrievedReview = reviewStorage.findReviewByName(reviewName);
        model.addAttribute("review", retrievedReview);
        return "review";
    }
}
