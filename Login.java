import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class Login implements ActionListener {

    JFrame frame = new JFrame();
    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");
    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel userIDLabel = new JLabel("UserId:");
    JLabel userPasswordLabel = new JLabel("Password:");
    JLabel messageLabel = new JLabel();

    HashMap<String,String> logininfo = new HashMap<String,String>();

    Login(HashMap<String,String> loginInfoOriginal) {
        logininfo = loginInfoOriginal;

        userIDLabel.setBounds(750,400,75,25);
        userPasswordLabel.setBounds(750,450,75,25);

        messageLabel.setBounds(825,600,500,35);
        messageLabel.setFont(new Font(null,Font.ITALIC,25));

        userIDField.setBounds(875,400,200,25);
        userPasswordField.setBounds(875,450,200,25);

        loginButton.setBounds(825,500,100,25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);

        resetButton.setBounds(950,500,100,25);
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);

        frame.add(userIDLabel);
        frame.add(userPasswordLabel);
        frame.add(messageLabel);
        frame.add(userIDField);
        frame.add(userPasswordField);
        frame.add(loginButton);
        frame.add(resetButton);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920,1080);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==resetButton){
            userIDField.setText("");
            userPasswordField.setText("");
        }

        if(e.getSource()==loginButton){
            String userID = userIDField.getText();
            String password = String.valueOf(userPasswordField.getPassword());
            if(logininfo.containsKey(userID)) {
                if(logininfo.get(userID).equals(password)){
                    messageLabel.setForeground(Color.green);
                    messageLabel.setText("LOGIN SUCCESSFULLY");
                    frame.dispose();
                    WelcomePage welcomePage = new WelcomePage();
                    //demo dem = new demo();
                }
                else{
                    messageLabel.setForeground(Color.red);
                    messageLabel.setText("WRONG PASSWORD");
                }
            }
            else{
                messageLabel.setForeground(Color.red);
                messageLabel.setText("Username not found");
            }
        }
    }
}
