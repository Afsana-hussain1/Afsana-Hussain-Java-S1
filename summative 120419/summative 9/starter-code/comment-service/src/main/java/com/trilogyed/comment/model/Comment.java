package com.trilogyed.comment.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Objects;

public class Comment {

    private int commentId;
    private int postId;
    private LocalDate createDate;
    private String commenterName;
    private String comment;

    public String getComment() {
        return comment;

    }
    public void setComment(String comment) {
        this.comment = comment;

    }
    public int getCommentId() {
        return commentId;

    }
    public void setCommentId(int commentId) {
        this.commentId = commentId;

    }
    public int getPostId() {
        return postId;

    }
    public void setPostId(int postId) {
        this.postId = postId;

    }
    public LocalDate getCreateDate() {
        return createDate;

    }
    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;

    }
    public String getCommenterName() {
        return commenterName;

    }
    public void setCommenterName(String commenterName) {
        this.commenterName = commenterName;

    }

    @Override

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment1 = (Comment) o;
        return getCommentId() == comment1.getCommentId() &&
                getPostId() == comment1.getPostId() &&
                getCreateDate().equals(comment1.getCreateDate()) &&
                getCommenterName().equals(comment1.getCommenterName()) &&
                Objects.equals(getComment(), comment1.getComment());

    }

    @Override
    public int hashCode() {
        return Objects.hash(getCommentId(), getPostId(), getCreateDate(), getCommenterName(), getComment());

    }
    @Override

    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", postId=" + postId +
                ", createDate=" + createDate +
                ", commenterName='" + commenterName + '\'' +
                ", comment='" + comment + '\'' +
                '}';

    }

}