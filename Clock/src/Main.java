import javax.swing.*;

public class Main extends JFrame {
    public Main() {
        setSize(600, 600);
        JPanel jPanel = new DrawStuff();
        setTitle("Relojo");
        add(jPanel);
        setDefaultCloseOperation(3);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}
