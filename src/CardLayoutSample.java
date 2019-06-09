import javax.swing.*;
import java.awt.*;

public class CardLayoutSample extends JFrame {
    private JPanel jpBottomMenu;

    public CardLayoutSample() {
        setTitle("CardLayout sample");
        setBounds(300, 300, 400, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        //
        initMenus();
    }

    private void initMenus() {
        jpBottomMenu = getBottomMenu();
        this.add(jpBottomMenu, BorderLayout.SOUTH);
        //
        JPanel jpMainMenu = getMainMenu();
        jpBottomMenu.add(jpMainMenu, "jpMainMenu");
        //
        JPanel jpFirstMenu = getFirstMenu();
        jpBottomMenu.add(jpFirstMenu, "jpFirstMenu");
        //
        JPanel jpSecondMenu = getSecondMenu();
        jpBottomMenu.add(jpSecondMenu, "jpSecondMenu");
    }

    private JPanel getBottomMenu() {
        JPanel jpBottom = new JPanel(new CardLayout());
        jpBottom.setPreferredSize(new Dimension(1, 60)); //
        return jpBottom;
    }

    private JPanel getMainMenu() {
        JPanel jpMainMenu = new JPanel(new GridLayout());
        //Button start learning
        JButton jbStartLearning = new JButton("Menu 1");
        jbStartLearning.addActionListener(e -> {
            //
            ((CardLayout) jpBottomMenu.getLayout()).show(jpBottomMenu, "jpFirstMenu");
        });
        jpMainMenu.add(jbStartLearning);
        //Button start repeating
        JButton jbStartRepeating = new JButton("Menu 2");
        jbStartRepeating.addActionListener(e -> {
            //
            ((CardLayout) jpBottomMenu.getLayout()).show(jpBottomMenu, "jpSecondMenu");
        });
        jpMainMenu.add(jbStartRepeating);
        //Button Exit
        JButton jbExitToMainMenu = new JButton("Exit");
        jbExitToMainMenu.addActionListener(e -> {
            System.exit(0);
        });
        jpMainMenu.add(jbExitToMainMenu);
        return jpMainMenu;
    }

    private JPanel getFirstMenu() {
        JPanel jpFirstMenu = new JPanel(new GridLayout());
        //Button Start
        JButton jbButton1 = new JButton("Button 1");
        jbButton1.addActionListener(e -> {
            //
        });
        jpFirstMenu.add(jbButton1);
        //Button MainMenu
        JButton jbButtonBack = new JButton("Back");
        jbButtonBack.addActionListener(e -> {
            //
            ((CardLayout) jpBottomMenu.getLayout()).show(jpBottomMenu, "jpMainMenu");
        });
        jpFirstMenu.add(jbButtonBack);
        return jpFirstMenu;
    }

    private JPanel getSecondMenu() {
        JPanel jpSecondMenu = new JPanel(new GridLayout());
        //Button Pass
        JButton jbButton1 = new JButton("Button 1");
        jbButton1.addActionListener(e -> {
            //
        });
        jpSecondMenu.add(jbButton1);
        //Button Remembered
        JButton jbButton2 = new JButton("Button 2");
        jbButton2.addActionListener(e -> {
            //
        });
        jpSecondMenu.add(jbButton2);
        //Button StopLearning
        JButton jbButtonBack = new JButton("Back");
        jbButtonBack.addActionListener(e -> {
            ((CardLayout) jpBottomMenu.getLayout()).show(jpBottomMenu, "jpMainMenu");
        });
        jpSecondMenu.add(jbButtonBack);
        return jpSecondMenu;
    }
}
