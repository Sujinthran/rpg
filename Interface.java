import javax.swing.*;
import java.awt.*;

public class Interface extends JFrame {

    public Interface() {

        initUI();
    }

    private void initUI() {

        add(new Board());

        setSize(250, 200);

        setTitle("Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {

    }
}