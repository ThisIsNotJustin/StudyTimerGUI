# Study Timer README

![](https://github.com/ThisIsNotJustin/ThisIsNotJustin.github.io/blob/gh-pages/assets/StudyTimer.png)

The StudyTimer program is a Java-based application that follows the advice of Andrew Huberman, a neuroscientist and associate professor at Stanford University, 
who suggests taking 10-second breaks throughout studying to increase the rate of learning. 
The program helps students or anyone who needs to study for an extended period by providing them with a timer that counts down from 90 minutes of study time and triggers a 10-second break every five minutes.


Requirements
------------------------------

To run the program, you need to have the following:

Java Development Kit (JDK) 8 or higher

An Integrated Development Environment (IDE) that supports Java, such as Eclipse, IntelliJ IDEA, Netbeans, or Visual Studio Code.



How to Run the Program
------------------------------

Open the IDE and create a new Java project.

Copy the StudyTimer.java code and paste it into a new file in the project.

Save the file and run the program.

When you run the program, a graphical user interface (GUI) will appear, showing the Study Timer window. The window has two buttons: Start and Stop.



Usage
------------------------------

Click the Start button to start the study timer countdown.

The timer will count down from 90 minutes, after which the text on the timer label will turn red and display the message "Study Time Over."

During the 90-minute countdown, the timer will trigger a 10-second break every five minutes.

The timer will show a green label with the message "Break: XX" to indicate that it's time for a break, and it will countdown from 10 seconds to 0 before returning to the main study countdown.

To stop the timer, click the Stop button.

Note: If you click the Start button again after the timer has ended, the study time will reset to 90 minutes and start the countdown again.




Code Description
------------------------------

The StudyTimer class extends the JFrame class, which allows the program to create a window with the timer and start and stop buttons. 

The class contains the following instance variables:

timerLabel: a JLabel object that displays the timer countdown and messages.

startButton: a JButton object that starts the timer.

stopButton: a JButton object that stops the timer.

RED, GREEN, and BLACK: Color objects used to change the color of the timer label.

timer: a Timer object that triggers the countdown.

studytime: an int variable that holds the number of seconds in the study time.

breakLength: an int variable that holds the number of seconds in the break time.

breakTime: a boolean variable that indicates whether the timer is in break time.

studyOver: a boolean variable that indicates whether the study time is over.

The class has a constructor that sets the initial values of the instance variables, creates the GUI, and adds action listeners to the buttons. 

The class also has a private TimerListener class that implements the ActionListener interface, which listens to the timer and updates the timer label accordingly.

Finally, the class has a private formatTime method that formats the time into a string that can be displayed on the timer label.



Conclusion
------------------------------
The StudyTimer program is a useful tool for students or anyone who needs to study for extended periods. 
It provides a simple and effective way to manage study time and take breaks at regular intervals. 
With its simple interface and sole purpose of being a timer, you're able to put the phone away and focus on your studying while following 
the principles given by Andrew Huberman.
