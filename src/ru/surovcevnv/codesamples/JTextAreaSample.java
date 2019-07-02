package ru.surovcevnv.codesamples;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*JTextArea,  JTextField, JPasswordField, GridLayout, JCheckBox, changing default uncaught exceptions handler samples
 * hiding panel */

public class JTextAreaSample extends JFrame implements ActionListener, Thread.UncaughtExceptionHandler {
    private final JTextArea textArea = new JTextArea();

    private final JCheckBox checkBox = new JCheckBox("Always on top");
    private final JPanel upperPanel = new JPanel(new GridLayout(2, 3, 2, 2));
    private final JTextField textField1 = new JTextField("field1");
    private final JTextField textField2 = new JTextField("field2");
    private final JTextField textField3 = new JTextField("field3");
    private final JPasswordField passwordField1 = new JPasswordField("");
    private final JButton jbButton1 = new JButton("Show");

    private final JPanel hidingPanel = new JPanel(new BorderLayout());
    private final JButton buttonHide = new JButton("Hide");


    private final JList<String> jList = new JList<String>();

    public JTextAreaSample() {
        setTitle("JTextArea sample");
        setBounds(100, 100, 1000, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        init();
        setVisible(true);
        Thread.setDefaultUncaughtExceptionHandler(this);
    }


    private void init() {
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        this.add(scrollPane, BorderLayout.CENTER);
        for (int i = 0; i < 100; i++) {
            textArea.append("Строка " + i + "\n");
        }
        upperPanel.add(textField1);
        upperPanel.add(textField2);
        /*if we need to skip one button*/
        upperPanel.add(checkBox);
        upperPanel.add(textField3);
        upperPanel.add(passwordField1);
        upperPanel.add(jbButton1);
        this.add(upperPanel, BorderLayout.NORTH);


        checkBox.setActionCommand("clickedOnTop");
        checkBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setAlwaysOnTop(checkBox.isSelected());
            }
        });

        jbButton1.addActionListener(this);
        buttonHide.addActionListener(this);

        String[] data = {"one", "two", "three"};
        jList.setListData(data);
        this.add(jList, BorderLayout.EAST);

        hidingPanel.add(buttonHide);
        hidingPanel.setVisible(false);
        this.add(hidingPanel, BorderLayout.SOUTH);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == jbButton1) {
            hidingPanel.setVisible(true);
        } else if (src == buttonHide) {
            hidingPanel.setVisible(false);
        } else {
            throw new RuntimeException("Unknown src: " + src);
        }
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        StackTraceElement[] stackTraceElements = e.getStackTrace();
        String msg = "";

        if (stackTraceElements.length == 0) {
            msg = "empty StackTrace";
        } else {
            msg = e.getClass().getCanonicalName() + ": " + e.getMessage() + "\n" +
                    stackTraceElements[0];
        }


        JOptionPane.showMessageDialog(null, msg, "Excepton: ", JOptionPane.ERROR_MESSAGE);
    }
}
