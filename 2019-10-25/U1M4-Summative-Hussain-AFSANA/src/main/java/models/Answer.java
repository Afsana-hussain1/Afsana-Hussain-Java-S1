package models;

import java.util.Objects;

public class Answer {
    private String answer;

    private String question;

    private int id;

    public Answer(String answer, String question, int id) {
        this.answer = answer;
        this.question = question;
        this.id = id;
    }
    public Answer() {

    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answer answer1 = (Answer) o;
        return id == answer1.id &&
                Objects.equals(answer, answer1.answer) &&
                Objects.equals(question, answer1.question);
    }

    @Override
    public int hashCode() {
        return Objects.hash(answer, question, id);
    }
}
