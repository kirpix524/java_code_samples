package ru.surovcevnv.circletimer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class TimerVisual extends JFrame{

    private class EventGenerator extends Thread {
        JFrame form;
        EventGenerator(JFrame form) {
            this.form = form;
            start();
        }

        @Override
        public void run() {
            while (!isInterrupted()) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        form.repaint();
                    }
                });
                try {
                    sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    private ArrayList<CircleTimer> elements;
    private JPanel jpBottomMenu;

    public TimerVisual() {
        setTitle("TimerVisual");
        setBounds(100, 100, 1000, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        //
        initMenus();

        new EventGenerator(this);

        elements = new ArrayList<>();
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton()==MouseEvent.BUTTON1) {
                    elements.add(new CircleTimer(e.getX(), e.getY(), 50,50, 60000, new Color(0,150,0)));
                    elements.get(elements.size()-1).start();
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

//    region menus

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
        ((CardLayout) jpBottomMenu.getLayout()).show(jpBottomMenu, "jpMainMenu");
    }

    private JPanel getBottomMenu() {
        JPanel jpBottom = new JPanel(new CardLayout());
        jpBottom.setPreferredSize(new Dimension(1, 60)); //
        return jpBottom;
    }

    private JPanel getMainMenu() {
        JPanel jpMainMenu = new JPanel(new GridLayout());
        //Button start learning
        JButton jbButton1 = new JButton("Menu 1");
        jbButton1.addActionListener(e -> {
            //
            ((CardLayout) jpBottomMenu.getLayout()).show(jpBottomMenu, "jpFirstMenu");
        });
        jpMainMenu.add(jbButton1);
        //Button start repeating
        JButton jbButton2 = new JButton("Menu 2");
        jbButton2.addActionListener(e -> {
            //
            ((CardLayout) jpBottomMenu.getLayout()).show(jpBottomMenu, "jpSecondMenu");
        });
        jpMainMenu.add(jbButton2);
        //Button Exit
        JButton jbExit = new JButton("Exit");
        jbExit.addActionListener(e -> {
            System.exit(0);
        });
        jpMainMenu.add(jbExit);
        return jpMainMenu;
    }

    private JPanel getFirstMenu() {
        JPanel jpFirstMenu = new JPanel(new GridLayout());
        //
        JButton jbButton1 = new JButton("Message dialog");
        jbButton1.addActionListener(e -> {
            //
            JOptionPane.showMessageDialog(new JFrame(), "Message");
        });
        jpFirstMenu.add(jbButton1);
        //
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
        //
        JButton jbButton0 = new JButton("Message dialog");
        jbButton0.addActionListener(e -> {
            //
            JOptionPane.showMessageDialog(new JFrame(), "Message");
        });
        jpSecondMenu.add(jbButton0);
        //
        //
        JButton jbButton1 = new JButton("Confirm Dialog");
        jbButton1.addActionListener(e -> {
            //
            JOptionPane.showConfirmDialog(new JFrame(), "Massage to confirm");
        });
        jpSecondMenu.add(jbButton1);
        //
        JButton jbButton2 = new JButton("Input Dialog");
        jbButton2.addActionListener(e -> {
            //
            String userInput = JOptionPane.showInputDialog(new JFrame(), "Input Dialog");
            JOptionPane.showMessageDialog(new JFrame(), "userInput: " + userInput);

        });
        jpSecondMenu.add(jbButton2);
        //
        JButton jbButton3 = new JButton("Options Dialog");
        jbButton3.addActionListener(e -> {
            //
            String[] options = {"First", "Second", "Third", "Fourth", "Fifth"};
            int response = JOptionPane.showOptionDialog(null, "Option Dialog", "Title", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, "Third");
            JOptionPane.showMessageDialog(new JFrame(), response);
        });
        jpSecondMenu.add(jbButton3);
        //
        JButton jbButtonBack = new JButton("Back");
        jbButtonBack.addActionListener(e -> {
            ((CardLayout) jpBottomMenu.getLayout()).show(jpBottomMenu, "jpMainMenu");
        });
        jpSecondMenu.add(jbButtonBack);
        return jpSecondMenu;
    }
//  endregion

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (int i=0; i<elements.size(); i++) {
            elements.get(i).draw(g);
//            System.out.println("element "+i+": "+elements.get(i).getInfo());
        }
    }
}
