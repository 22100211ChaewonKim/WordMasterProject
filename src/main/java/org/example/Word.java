package org.example;

public class Word {
    private int id;
    private int level;
    private String word;
    private String meaning;

    Word(){} //기본형 만들기
    Word(int id, int level, String word, String meaning){
        this.id = id;
        this.level = level;
        this.word = word;
        this.meaning = meaning;
        //다른 거 필요한 게 생기면 여기에 추가하기
    }

    //외부에서 변경할 수 있도록
    public int getId() {
        return id;
    }

    public int getLevel() {
        return level;
    }

    public String getWord() {
        return word;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    @Override
    public String toString() {
        String slevel = "";
        for (int i = 0; i < level; i ++)
            slevel += "*";

        String str = String.format ("%-3s", slevel)
                + String.format("%15s", word)
                + "  "
                + meaning;

        return str;
    }
}
