package com.trilogyed.post.model;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Objects;

public class Post {

    private int postId;
    private LocalDate postDate;
    @NotEmpty
    private String posterName;
    @NotEmpty
    private String post;

    public int getPostId() {
        return postId;

    }
    public void setPostId(int postId) {
        this.postId = postId;

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
        return getPostId() == post1.getPostId() &&
                getPostDate().equals(post1.getPostDate()) &&
                getPosterName().equals(post1.getPosterName()) &&
                getPost().equals(post1.getPost());

    }



    @Override
    public int hashCode() {
        return Objects.hash(getPostId(), getPostDate(), getPosterName(), getPost());

    }

}