import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Launcher extends JFrame {
    public static void main(String[] args) {
        Frame();
    }
    public static void Frame (){
        JFrame jFrame = new JFrame("Выберите название мира");
        JTextField jTextField = new JTextField("world");
        jTextField.setColumns(30);
        JRadioButton jRadioButton = new JRadioButton("Debug");
        JButton jButton = new JButton("ИГРАТЬ");
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!jTextField.getText().isEmpty()) {
                    if (jRadioButton.isSelected()) {
                        Process proc = null;
                        try {
                            proc = Runtime.getRuntime().exec("cmd 1.bat " + jTextField.getText());
                            //proc.waitFor();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }else {
                        Process proc = null;
                        try {
                            proc = Runtime.getRuntime().exec("java -jar GuilsGame.jar " + jTextField.getText());
                            //proc.waitFor();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        } //catch (InterruptedException ex) {
                        //ex.printStackTrace();
                        //}
                        //proc.destroy();
                    }
                    System.exit(0);
                }else {
                    JFrame jFrame1 = new JFrame("Ошибка");
                    JLabel jLabel = new JLabel("Поле world не может быть пустым");
                    jFrame1.add(jLabel);
                    jFrame1.setBounds(100, 100, 300, 100);
                    jFrame1.setResizable(false);
                    jFrame1.setVisible(true);
                }
            }
        });
        jFrame.setBounds(100, 100, 400, 300);
        JPanel jPanel = new JPanel();
        jPanel.add(jTextField);
        jPanel.add(jButton);
        //jPanel.add(jRadioButton);
        jFrame.add(jPanel);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setResizable(false);
        jFrame.setVisible(true);
    }
}
