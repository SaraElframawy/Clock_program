import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MyFrame extends JFrame {

    SimpleDateFormat timeFormat;
    SimpleDateFormat dayFormat;
    SimpleDateFormat dateFormat;
    JLabel timeLabel;
    JLabel dayLabel;
    JLabel dateLabel;
    String day; //to keep the current time in a string with format
    String time;
    String date;

    MyFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("mt Clock program");
        this.setLayout(new FlowLayout());
        this.setSize(400,400);
       // this.setResizable(false);
        this.setVisible(true);
        timeFormat = new SimpleDateFormat("hh:mm:ss a"); //a for pm or am,just the  formatting of the time string
        dayFormat= new SimpleDateFormat("EEEE");
        dateFormat=new SimpleDateFormat("MM/dd, yyyy");
        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Verdena",Font.PLAIN,50));
        timeLabel.setForeground(new Color(0x00ff00));
        timeLabel.setBackground(Color.BLACK);
        timeLabel.setOpaque(true);
        dayLabel = new JLabel();
        dayLabel.setFont(new Font("Ink Free",Font.PLAIN,35));
        dateLabel= new JLabel();
        dateLabel.setFont(new Font("Ink Free",Font.PLAIN,25));
        this.add(timeLabel);
        this.add(dayLabel);
        this.add(dateLabel);
        setTime();


    }
    public void setTime(){
        while (true) {
            time = timeFormat.format(Calendar.getInstance().getTime());
            timeLabel.setText(time);
            day= dayFormat.format(Calendar.getInstance().getTime());
            dayLabel.setText(day);
            date= dateFormat.format(Calendar.getInstance().getTime());
            dateLabel.setText(date);
            try {
                Thread.sleep(1000); //wait one second and then start to produce the time now over and over again
            } catch (InterruptedException e) { //so it will be real ongoing clock
                throw new RuntimeException(e);
            }
        }
    }
}
