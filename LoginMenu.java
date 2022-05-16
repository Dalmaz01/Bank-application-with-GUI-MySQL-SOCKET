package bankapplication.midterm1;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginMenu extends Container {

    private JLabel accNumberLabel;
    private JLabel pinLabel;

    public static JTextField accNumberText;
    private JPasswordField pinText;

    private JButton loginButton;
    private JButton forgotButton;
    private JButton exitButton;

    public static String acc_number_now;

    public LoginMenu() {

        setSize(500, 400);
        setLayout(null);

        accNumberLabel = new JLabel("Account Number");
        accNumberLabel.setBounds(60, 120, 110, 30);
        add(accNumberLabel);

        accNumberText = new JTextField();
        accNumberText.setBounds(175, 120, 120, 30);
        add(accNumberText);

        pinLabel = new JLabel("Pin Code");
        pinLabel.setBounds(60, 160, 110, 30);
        add(pinLabel);

        pinText = new JPasswordField();
        pinText.setBounds(175, 160, 120, 30);
        add(pinText);

        loginButton = new JButton("Login");
        loginButton.setBounds(90, 200, 80, 30);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

//                if(CityBankATM.isLogin(accNumberText.getText(), pinText.getText())) {
//                    MainFrame.bankActionsMenuWindow.setVisible(true);
//                    MainFrame.mainMenuWindow.setVisible(false);
//                    acc_number_now = accNumberText.getText();
//                }else {
//                    JOptionPane.showMessageDialog(null, "Incorrect login and password!");
//                }
//
                PackageData pd = new PackageData("Login", Integer.parseInt(pinText.getText()), Integer.parseInt(accNumberText.getText()));
                Main.connect(pd);
            }
        });
        add(loginButton);

        exitButton = new JButton("Exit");
        exitButton.setBounds(190, 200, 80, 30);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                        System.exit(0);
                    }
        });
        add(exitButton);
    }
}