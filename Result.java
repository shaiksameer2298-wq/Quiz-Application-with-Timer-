import javax.swing.*;

public class Result extends JFrame {
    public Result(int score, int total) {
        setLayout(null);
        setBounds(300, 150, 600, 400);
        setTitle("Result");

        JLabel res = new JLabel("Your Score: " + score + " / " + total);
        res.setBounds(200, 100, 200, 30);
        add(res);

        JButton btnReplay = new JButton("Play Again");
        btnReplay.setBounds(200, 150, 150, 30);
        btnReplay.addActionListener(e -> {
            dispose();
            new Quiz();
        });
        add(btnReplay);

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}