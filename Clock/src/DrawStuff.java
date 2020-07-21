import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DrawStuff extends JPanel implements ActionListener {
    Timer t = new Timer(1, this);
    float hour;
    float min;
    float sec;

    public DrawStuff() {
        t.start();
    }

    @Override
    protected void paintComponent(Graphics gf) {

        super.paintComponent(gf);
        this.setBackground(Color.BLACK);
        Graphics2D g = (Graphics2D) gf;

        g.translate(getWidth() / 2, getHeight() / 2);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 15));
        g.drawString("12", -15, -150);
        g.drawString("9", -150, 0);
        g.drawString("3", 150, 0);
        g.drawString("6", -15, 150);
        g.drawString((int) hour + " : " + (int) min + " : " + (int) sec, -50, 200);
        g.scale(1.25, -1.25);
        g.setStroke(new BasicStroke(4));
        float hr = map(hour, 0, 24, 0, 359);
        float mn = map(min, 0, 60, 0, 359);
        float sc = map(sec, 0, 60, 0, 359);
        g.rotate(Math.PI / 2);
        g.setColor(Color.MAGENTA);
        g.drawArc(-100, -100, 200, 200, 0, (int) mn);
        g.setColor(Color.BLUE);
        g.drawArc(-95, -95, 190, 190, 0, (int) hr);
        g.setColor(Color.GREEN);
        g.drawArc(-90, -90, 180, 180, 0, (int) sc);

    }

    static public float map(float toMap, float fromMin, float fromMax, float toMin, float toMax) {
        return toMin + (toMax - toMin) * ((toMap - fromMin) / (fromMax - fromMin));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        hour = new GregorianCalendar().get(Calendar.HOUR_OF_DAY);
        min = new GregorianCalendar().get(Calendar.MINUTE);
        sec = new GregorianCalendar().get(Calendar.SECOND);
        repaint();
    }
}
