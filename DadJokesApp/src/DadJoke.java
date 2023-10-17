public class DadJoke {
    private String question;
    private String punchline;

    public DadJoke(String question, String punchline) {
        this.question = question;
        this.punchline = punchline;
    }

    public String getQuestion() {
        return question;
    }

    public String getPunchline() {
        return punchline;
    }

    @Override
    public String toString() {
        return question + "\n" + punchline;
    }

}