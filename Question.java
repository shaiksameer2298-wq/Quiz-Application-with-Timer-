public class Question {
    private String title;
    private String[] options;
    private int answerIndex;

    public Question(String title, String[] options, int answerIndex) {
        this.title = title;
        this.options = options;
        this.answerIndex = answerIndex;
    }

    public String getTitle() {
        return title;
    }

    public String[] getOptions() {
        return options;
    }

    public int getAnswerIndex() {
        return answerIndex;
    }
}