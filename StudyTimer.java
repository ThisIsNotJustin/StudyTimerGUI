package Timer;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * Program based on Andrew Huberman, Neuroscientist at Standford University 
 * who suggested 10 second breaks throughout studying to learn faster
 * @author Jusin Coleman
 */
public class StudyTimer extends JFrame {
    // private instance variables
    private final JLabel timerLabel;
    private final JButton startButton, stopButton;
    private static final Color RED = new Color(255, 55, 0); // red
    private static final Color GREEN = new Color(0, 128, 0); // green
    private static final Color BLACK = new Color(0, 0, 0); // black
    private Timer timer;
    private int studytime, breakLength;
    
    private boolean breakTime = false;
    private boolean studyOver = false;
    
    public StudyTimer() {
    studytime = 5400; // 5400 seconds (90 minutes)
    breakLength = 10; // 10 seconds 

    // create the gui for the study timer
    setTitle("Study Timer");
    setBounds(100, 100, 400, 150);
    JPanel content = new JPanel();
    content.setBorder(new EmptyBorder(10, 10, 10, 10));
    content.setLayout(new BorderLayout(0, 10));
    setContentPane(content);
    // initialize a new timer with a 1 second delay and timerlistener to listen
    // to the created timer
    timer = new Timer(1000, new TimerListener());

    // create label to display the timer countdown
    timerLabel = new JLabel(formatTime(studytime));
    timerLabel.setFont(new Font("Arial", Font.BOLD, 40));
    timerLabel.setHorizontalAlignment(JLabel.CENTER);
    content.add(timerLabel, BorderLayout.CENTER);

    // create panel for start and stop buttons
    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
    content.add(buttonPanel, BorderLayout.SOUTH);

    // create the start button 
    startButton = new JButton("Start");
    // actionlistener when start button is pressed
    startButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // when pressed display the study time and start the timer
            timerLabel.setText(formatTime(studytime));
            timer.start();
        }
    });
    startButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) { 
            // if start button is pressed and studytime is less than or equal
            // to 0 reset studyOver back to false, text color to black, 
            // studytime back to 5400 seconds, display the studytime and start
            // the timer
            if (studytime <= 0) {
                studyOver = false;
                timerLabel.setForeground(BLACK);
                studytime = 5400;
                timerLabel.setText(formatTime(studytime));
                timer.start();
            }
            
        }
    });
    buttonPanel.add(startButton);

    // create stop button 
    stopButton = new JButton("Stop");
    // actionlistener for stop button
    stopButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // when pressed stop the timer
            timer.stop();
        }
    });
    buttonPanel.add(stopButton);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null); // center program
    setVisible(true);
    }

    private class TimerListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        // if breakTime and studyOver are false, set text to black and display
        // the study timer, also decrement the studytime
        if (!breakTime && !studyOver) {
            timerLabel.setForeground(BLACK);
            timerLabel.setText(formatTime(studytime));
            studytime--;
            // if studytime is less than 0 set studyOver to true, stop the timer
            // set text to red, and display Study Time Over
            if (studytime < 0) {
                studyOver = true;
                timer.stop();
                timerLabel.setForeground(RED);
                timerLabel.setText(String.format("Study Time Over"));
                // if studytime is perfectly divisble by 5 minutes and greater
                // than zero, set breakTime to true
            } else if (studytime % 300 == 0 && studytime > 0) { 
                breakTime = true;
            }
            // if breakTime is true and studyOver is false, set text to green
            // and display Break: with a countdown of the length of the break
        } else if (breakTime && !studyOver) {
            timerLabel.setForeground(GREEN);
            timerLabel.setText(String.format("Break: %02d", breakLength));
            breakLength--;
            // if breaktime is less than 0, set breakTime to false and 
            // decrement studytime by the length of the break
            if (breakLength < 0) {
                breakTime = false;
                studytime -= 10;
            }
        }
    }
    }
    
    public static void main(String[] args) {
        new StudyTimer();
    }

    // private string method for formatting seconds to the displayed timer
    private static String formatTime(long seconds) {
        long min = seconds / 60;
        long sec = seconds % 60;
        return String.format("%02d:%02d", min, sec);
    }
}

