package effectively_final;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Evgeny Borisov
 */
public class MyFrame extends JFrame {

    public MyFrame(int[] counter) {
        JButton button = new JButton("click to change color");

        button.addActionListener(e -> {
            getContentPane().setBackground(Color.RED);
            System.out.println(counter[0]++);
        });

        getContentPane().add(button, BorderLayout.NORTH);
        setSize(400,400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new MyFrame(new int[]{10});
    }
}
