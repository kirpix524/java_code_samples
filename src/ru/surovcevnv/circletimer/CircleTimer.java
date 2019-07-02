package ru.surovcevnv.circletimer;

import java.awt.*;

public class CircleTimer implements Drawable {
    //    region timer properties
    private int duration;
    private boolean isStarted;
    private boolean isRunning;
    private long startTime;
    private long pauseDuration;
    //    endregion
//    region graphics properties
    private static Color COLOR_OFF = new Color(160, 160, 160);
    private int curX;
    private int curY;
    private int width;
    private int height;
    private Color color;
//    endregion

    CircleTimer(int centerX, int centerY, int width, int height, int durationMs, Color color) {
        this.curX = centerX;
        this.curY = centerY;
        this.width = width;
        this.height = height;
        this.duration = durationMs;
        this.isStarted = false;
        this.isRunning = false;
        this.color = color;
    }

    public void start() {
        if (!isStarted) {
            isStarted = true;
            startTime = System.currentTimeMillis();
            pauseDuration = 0;
        }
        if ((!isRunning) && (pauseDuration > 0)) {
            startTime = System.currentTimeMillis() - pauseDuration;
            pauseDuration = 0;
        }
        isRunning = true;
    }

    public void pause() {
        if (isRunning) {
            isRunning = false;
            pauseDuration = System.currentTimeMillis() - startTime;
        }
    }

    public void stop() {
        isRunning = false;
        isStarted = false;
        pauseDuration = 0;
        startTime = 0;
    }

    public void restart() {
        stop();
        start();
    }

    public boolean setDuration(int durationMS) {
        if (isRunning) return false;
        if (durationMS <= 0) return false;
        this.duration = durationMS;
        return true;
    }

    public String getInfo() {
        return "startTime="+startTime+", isRunning="+isRunning+", isStarted="+isStarted+", percentPassed="+getPercentPassed();
    }

    private float getPercentPassed() {
        float percentPassed = 0;
        if (isStarted) {
            if (isRunning) {
                long nowTime = System.currentTimeMillis();
                long millisPassed =nowTime - startTime;
                percentPassed = (float)millisPassed / (float)duration;
            } else {
                percentPassed = (float)pauseDuration / (float)duration;
            }
        } else {
            percentPassed = 0;
        }
        if (percentPassed > 1) {
            percentPassed = 1;
        }
        return percentPassed;
    }

    @Override
    public void draw(Graphics g) {
        float percentPassed = getPercentPassed();
        if ((!isStarted) || (!isRunning)) {
            g.setColor(COLOR_OFF);
        } else {
            g.setColor(color);
        }
        g.drawArc(curX - width / 2, curY - height / 2, width, height, 0, (int) (360 * (1 - percentPassed)));
    }
}
