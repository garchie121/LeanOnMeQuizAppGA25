package org.baltimorecityschools.leanonmequizappga25;

public class Question {
    private String qPrompt;
    private boolean correctAnswer;
    private int imageid;

    public Question(String qPrompt, boolean correctAnswer, int imageid) {
        this.qPrompt = qPrompt;
        this.correctAnswer = correctAnswer;
        this.imageid = imageid;
    }

    public Question() {
    qPrompt = "";
    correctAnswer = false;
    imageid = 0;

}

    public String getqPrompt() {
        return qPrompt;
    }

    public int getImageid() {
        return imageid;
    }

    public void setImageid(int imageid) {
        this.imageid = imageid;
    }

    public void setqPrompt(String qPrompt) {
        this.qPrompt = qPrompt;
    }

    public boolean getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(boolean correctAnswer) {
        this.correctAnswer = correctAnswer;
    }



public boolean  isThisCorrect(boolean userAnswer) {
    return userAnswer == correctAnswer;
}

@Override
public String toString() {
    return "Question{" +
            "qPrompt='" + qPrompt + '\'' +
            ", correctAnswer=" + correctAnswer +
            '}';
     }
}