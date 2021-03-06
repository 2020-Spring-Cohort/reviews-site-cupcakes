package org.wecancodeit.reviews;

import javax.persistence.*;
import java.util.*;

@Entity
public class Review {
    @Id
    @GeneratedValue
    private Long id;
    private String reviewName;
    private String reviewAuthor;
    private Integer reviewRating;
    private Date reviewDate;
    private String reviewText;
    @ManyToOne
    private Category reviewCategory;
    @ManyToMany
    private Set<Hashtag> hashtags;

    public Review() {
    }

    public Review(String reviewAuthor, Integer reviewRating, String reviewText, Category reviewCategory, String reviewName) {
        this.reviewAuthor = reviewAuthor;
        this.reviewRating = reviewRating;
        this.reviewDate = new Date();
        this.reviewText = reviewText;
        this.reviewCategory = reviewCategory;
        this.reviewName = reviewName;
        this.hashtags = new HashSet<>();
    }

    public Collection<Hashtag> getHashtags(){
        return hashtags;
    }

    public String getReviewName() {
        return reviewName;
    }

    public String getReviewAuthor() {
        return reviewAuthor;
    }

    public Integer getReviewRating() {
        return reviewRating;
    }

    public Date getReviewDate() {
        return reviewDate;
    }

    public String getReviewText() {
        return reviewText;
    }

    public Category getReviewCategory() {
        return reviewCategory;
    }

    public Long getId() {
        return id;
    }

    public void addHashtag(Hashtag hashtagToAdd){
        hashtags.add(hashtagToAdd);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return Objects.equals(reviewName, review.reviewName) &&
                Objects.equals(reviewCategory, review.reviewCategory) &&
                Objects.equals(reviewAuthor, review.reviewAuthor) &&
                Objects.equals(reviewDate, review.reviewDate) &&
                Objects.equals(reviewRating, review.reviewRating) &&
                Objects.equals(reviewText, review.reviewText) &&
                Objects.equals(id, review.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reviewAuthor, reviewRating, reviewDate, reviewText, reviewCategory, reviewName, id, hashtags);
    }
}
