package bankapplication.midterm1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewAccountMenu extends Container {
    private JLabel nameLabel;
    private JLabel surnameLabel;
    private JLabel balanceLabel;
    private JLabel accNumberLabel;

    public static JTextArea nameText;
    public static JTextArea surnameText;
    public static JTextArea balanceText;
    public static JTextArea accNumberText;

    private JButton viewButton;
    private JButton backButton;

    public ViewAccountMenu() {
        setSize(400, 500);
        setLayout(null);

        nameLabel = new JLabel("Name");
        nameLabel.setBounds(90, 60, 100, 30);
        add(nameLabel);

        nameText = new JTextArea();
        nameText.setBounds(200, 60, 150, 30);
        add(nameText);

        surnameLabel = new JLabel("Surname");
        surnameLabel.setBounds(90, 100, 100, 30);
        add(surnameLabel);

        surnameText = new JTextArea();
        surnameText.setBounds(200, 100, 150, 30);
        add(surnameText);

        balanceLabel = new JLabel("Balance");
        balanceLabel.setBounds(90, 140, 100, 30);
        add(balanceLabel);

        balanceText = new JTextArea();
        balanceText.setBounds(200, 140, 150, 30);
        add(balanceText);

        accNumberLabel = new JLabel("Card Number");
        accNumberLabel.setBounds(90, 180, 100, 30);
        add(accNumberLabel);

        accNumberText = new JTextArea();
        accNumberText.setBounds(200, 180, 150, 30);
        add(accNumberText);

        viewButton = new JButton("View Data");
        viewButton.setBounds(90, 220, 300, 30);
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {



                for (int i = 0; i < CityBankATM.getAccounts().size(); i++) {
                    int account_number = Integer.parseInt(CityBankATM.getAccounts().get(i).toString().split(" ")[4]);
                    if(account_number == Integer.parseInt(LoginMenu.acc_number_now)) {
                        String name = CityBankATM.getAccounts().get(i).toString().split(" ")[1];
                        String surname = CityBankATM.getAccounts().get(i).toString().split(" ")[2];
                        int balance = Integer.parseInt(CityBankATM.getAccounts().get(i).toString().split(" ")[5]);



                        nameText.setText(name);
                        surnameText.setText(surname);
                        balanceText.setText(String.valueOf(balance));
                        accNumberText.setText(String.valueOf(account_number));


                    }
                }

                PackageData pd = new PackageData("View Account", Integer.parseInt(LoginMenu.acc_number_now));
                Main.connect(pd);



            }
        });
        add(viewButton);

        backButton = new JButton("Back");
        backButton.setBounds(90, 260, 300, 30);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.bankActionsMenuWindow.setVisible(true);
                MainFrame.viewAccountMenuWindow.setVisible(false);
            }
        });
        add(backButton);
    }
}
