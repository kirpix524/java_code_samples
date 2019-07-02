package ru.surovcevnv.codesamples;

import ru.surovcevnv.circletimer.TimerVisual;

import javax.swing.*;

public class ClassMain {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
//                ru.surovcevnv.codesamples.CardLayoutSample w = new ru.surovcevnv.codesamples.CardLayoutSample();
//              ru.surovcevnv.codesamples.CollectionsSample w = new ru.surovcevnv.codesamples.CollectionsSample();
//              ru.surovcevnv.codesamples.JTextAreaSample w = new ru.surovcevnv.codesamples.JTextAreaSample();
//                ru.surovcevnv.codesamples.ThreadSamples w = new ru.surovcevnv.codesamples.ThreadSamples();
//                NetSample w = new NetSample();
                TimerVisual w = new TimerVisual();
            }
        });
    }
}
