package models;

import java.util.Objects;

public class Definition {
    private String word;

    private String definition;

    private int id;

    public Definition(String word, String definition, int id) {
        this.word = word;
        this.definition = definition;
        this.id = id;
    }

    public Definition () {

    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
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
        Definition that = (Definition) o;
        return id == that.id &&
                Objects.equals(word, that.word) &&
                Objects.equals(definition, that.definition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word, definition, id);
    }
}
