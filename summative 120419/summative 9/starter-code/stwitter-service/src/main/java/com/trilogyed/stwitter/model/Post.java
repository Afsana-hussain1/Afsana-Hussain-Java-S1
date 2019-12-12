package com.trilogyed.stwitter.model;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Post {

    private int postID;
    private LocalDate postDate;
    @NotEmpty
    private String posterName;
    @NotEmpty
    private String post;

    private List<Comment> commentsList;

    public List<Comment> getComments() {
        return commentsList;
    }

    public void setComments(List<Comment> comments) {
        this.commentsList = comments;
    }

    public int getPostID() {
        return postID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }

    public LocalDate getPostDate() {
        return postDate;
    }

    public void setPostDate(LocalDate postDate) {
        this.postDate = postDate;
    }

    public String getPosterName() {
        return posterName;
    }

    public void setPosterName(String posterName) {
        this.posterName = posterName;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post1 = (Post) o;
        return postID == post1.postID &&
                Objects.equals(postDate, post1.postDate) &&
                Objects.equals(posterName, post1.posterName) &&
                Objects.equals(post, post1.post) &&
                Objects.equals(commentsList, post1.commentsList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postID, postDate, posterName, post, commentsList);
    }

    @Override
    public String toString() {
        return "Post{" +
                "postID=" + postID +
                ", postDate=" + postDate +
                ", posterName='" + posterName + '\'' +
                ", post='" + post + '\'' +
                ", comments=" + commentsList +
                '}';
    }
}
