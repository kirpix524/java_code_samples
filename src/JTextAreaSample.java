import javax.swing.*;
import java.awt.*;

public class JTextAreaSample extends JFrame {
    private final JTextArea textArea = new JTextArea();

    public JTextAreaSample() {
        setTitle("JTextArea sample");
        setBounds(100, 100, 1000, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        init();
        setVisible(true);
    }


    private void init() {
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        this.add(scrollPane, BorderLayout.CENTER);
        for (int i = 0; i < 100; i++) {
            textArea.append("Строка " + i + "\n");
        }
    }
}
