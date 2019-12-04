package com.trilogyed.post.viewModel;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Objects;

public class PostViewModel {
    private int postId;

    @NotNull(message = "need date for post")
    private LocalDate postDate;

    @NotEmpty(message = "need name for the post")
    @Size(min=1, max=50, message = "50 characters max ")
    private String posterName;
    @Size(min=5, max=255, message = "max 255 chars")
    private String postContent;

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


    public String getPostContent() {
        return postContent;

    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;

    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostViewModel that = (PostViewModel) o;
        return getPostId() == that.getPostId() &&
                getPostDate().equals(that.getPostDate()) &&
                getPosterName().equals(that.getPosterName()) &&
                getPostContent().equals(that.getPostContent());

    }
    @Override
    public int hashCode() {
        return Objects.hash(getPostId(), getPostDate(), getPosterName(), getPostContent());

    }

}