import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Quiz extends JFrame implements ActionListener {
    Question[] questions = QuizData.getQuestions();
    int current = 0, score = 0;
    JLabel labelQuestion;
    JRadioButton[] btnOptions = new JRadioButton[4];
    ButtonGroup bg;
    JButton btnNext;
    Timer timer;
    int timeLeft = 15;

    public Quiz() {
        setLayout(null);
        setTitle("Quiz Application");
        setBounds(200, 100, 800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        labelQuestion = new JLabel();
        labelQuestion.setBounds(50, 50, 700, 30);
        add(labelQuestion);

        bg = new ButtonGroup();
        for (int i = 0; i < 4; i++) {
            btnOptions[i] = new JRadioButton();
            btnOptions[i].setBounds(100, 100 + i * 50, 600, 30);
            add(btnOptions[i]);
            bg.add(btnOptions[i]);
        }

        btnNext = new JButton("Next");
        btnNext.setBounds(350, 320, 100, 30);
        btnNext.addActionListener(this);
        add(btnNext);

        startQuiz();
        setVisible(true);
    }

    public void startQuiz() {
        loadQuestion(current);
        timer = new Timer(1000, e -> {
            timeLeft--;
            if (timeLeft <= 0) {
                timeLeft = 15;
                nextQuestion();
            }
            repaint();
        });
        timer.start();
    }

    public void loadQuestion(int idx) {
        bg.clearSelection();
        labelQuestion.setText("Q" + (idx + 1) + ": " + questions[idx].getTitle());
        String[] opts = questions[idx].getOptions();
        for (int i = 0; i < 4; i++) {
            btnOptions[i].setText(opts[i]);
        }
    }

    public void actionPerformed(ActionEvent e) {
        timer.stop();
        int selected = -1;
        for (int i = 0; i < 4; i++) {
            if (btnOptions[i].isSelected()) {
                selected = i;
            }
        }
        if (selected == questions[current].getAnswerIndex()) {
            score++;
        }
        nextQuestion();
    }

    public void nextQuestion() {
        current++;
        if (current < questions.length) {
            timeLeft = 15;
            loadQuestion(current);
            timer.start();
        } else {
            showResult();
        }
    }

    public void showResult() {
        dispose();
        new Result(score, questions.length);
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma", Font.BOLD, 25));
        g.drawString("Time left: " + timeLeft + " sec", 550, 430);
    }

    public static void main(String[] args) {
        new Quiz();
    }
}
