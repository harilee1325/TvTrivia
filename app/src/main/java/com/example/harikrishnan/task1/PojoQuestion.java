package com.example.harikrishnan.task1;

public class PojoQuestion {

    String Qname,choice_1,choice_2,choice_3,choice_4,correct;

    public PojoQuestion(String qname, String choice_1, String choice_2, String choice_3, String choice_4, String correct) {
        Qname = qname;
        this.choice_1 = choice_1;
        this.choice_2 = choice_2;
        this.choice_3 = choice_3;
        this.choice_4 = choice_4;
        this.correct = correct;
    }

    public String getQname() {
        return Qname;
    }

    public void setQname(String qname) {
        Qname = qname;
    }

    public String getChoice_1() {
        return choice_1;
    }

    public void setChoice_1(String choice_1) {
        this.choice_1 = choice_1;
    }

    public String getChoice_2() {
        return choice_2;
    }

    public void setChoice_2(String choice_2) {
        this.choice_2 = choice_2;
    }

    public String getChoice_3() {
        return choice_3;
    }

    public void setChoice_3(String choice_3) {
        this.choice_3 = choice_3;
    }

    public String getChoice_4() {
        return choice_4;
    }

    public void setChoice_4(String choice_4) {
        this.choice_4 = choice_4;
    }

    public String getCorrect() {
        return correct;
    }

    public void setCorrect(String correct) {
        this.correct = correct;
    }
}
