import javax.swing.*;

public class ClassMain {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
//                CardLayoutSample w = new CardLayoutSample();
//              CollectionsSample w = new CollectionsSample();
//              JTextAreaSample w = new JTextAreaSample();
                ThreadSamples w = new ThreadSamples();
            }
        });
    }
}
