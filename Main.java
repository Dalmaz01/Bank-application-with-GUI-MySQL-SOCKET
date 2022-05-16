package bankapplication.midterm1;

import javax.swing.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class Main {
    public static MainFrame frame;

    public static void connect(PackageData pd) {
        try {
            Socket socket = new Socket("localhost", 8888);
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

            if(pd.getOperationType().equals("Login")) {
                outputStream.writeObject(pd);//ADD, Student

                if(CityBankATM.isLogin(pd.getAccount_number(), pd.getPinCode())) {
                    MainFrame.bankActionsMenuWindow.setVisible(true);
                    MainFrame.mainMenuWindow.setVisible(false);
                    LoginMenu.acc_number_now = LoginMenu.accNumberText.getText();
                }else {
                    JOptionPane.showMessageDialog(null, "Incorrect login and password!");
                }
            }
            else if(pd.getOperationType().equals("Cash Withrawal")) {
                //JOptionPane.showMessageDialog(null, "The "+"balance"+" was cash withrawed from yours!");

                outputStream.writeObject(pd);
            }
            else if(pd.getOperationType().equals("View Balance")) {
                outputStream.writeObject(pd);
                PackageData infoFromServer = (PackageData)inputStream.readObject();
                String balance = infoFromServer.getCash();

                ViewBalanceMenu.balanceText.setText(balance);

            }
            else if(pd.getOperationType().equals("Chage Pin Code")) {
                outputStream.writeObject(pd);
            }
            else if(pd.getOperationType().equals("Cash In Account")) {
                outputStream.writeObject(pd);
            }
            else if(pd.getOperationType().equals("View Account")) {
                outputStream.writeObject(pd);
                PackageData infoFromServer = (PackageData)inputStream.readObject();


                CityBankAccount cityBankAccount = infoFromServer.getCityBankAccount();
                System.out.println(cityBankAccount);

                String name = cityBankAccount.getName();
                String surname = cityBankAccount.getSurname();
                int cash = cityBankAccount.getBalance();
                int account_number = cityBankAccount.getAccountNumber();

                ViewAccountMenu.nameText.setText(name);
                ViewAccountMenu.surnameText.setText(surname);
                ViewAccountMenu.balanceText.setText(String.valueOf(cash));
                ViewAccountMenu.accNumberText.setText(String.valueOf(account_number));
            }

            inputStream.close();
            outputStream.close();
            socket.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CityBankATM cityBankATM = new CityBankATM();
        cityBankATM.connect();
        frame = new MainFrame();
        frame.setVisible(true);

    }
}
