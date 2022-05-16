package bankapplication.midterm1;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ServerThread extends Thread{
    private Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            CityBankATM manager = new CityBankATM();
            manager.connect();

            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

            PackageData packageData = null;
            while((packageData=(PackageData)inputStream.readObject())!=null) {
                if(packageData.getOperationType().equals("Login")) {//Login

                    int pincodefromclient = packageData.getPinCode();
                    int accnumberfromclient = packageData.getAccount_number();
                    manager.isLogin(accnumberfromclient, pincodefromclient);
                }
                else if(packageData.getOperationType().equals("Cash Withrawal")) {//cash withrawal

                    String cashFromClient = packageData.getCash();
                    int accNumberFromClient = packageData.getAccount_number();
                    manager.cashWithrawal(cashFromClient, String.valueOf(accNumberFromClient));
                }
                else if(packageData.getOperationType().equals("View Balance")) {
                    int infoForClient = manager.getBalance(String.valueOf(packageData.getAccount_number()));
                    PackageData toClient = new PackageData(String.valueOf(infoForClient));
                    outputStream.writeObject(toClient);
                }
                else if(packageData.getOperationType().equals("Chage Pin Code")) {
                    int oldPinCodeFromClient = packageData.getOldPinCode();
                    int newPinCodeFromClient = packageData.getNewPinCode();
                    int accNumberFromClient = packageData.getAccount_number();
                    manager.changePinCode(String.valueOf(accNumberFromClient), String.valueOf(newPinCodeFromClient));
                }
                else if(packageData.getOperationType().equals("Cash In Account")) {
                    String cashFromClient = packageData.getCash();
                    int accNumberFromClient = packageData.getAccount_number();
                    manager.cashInAccount(cashFromClient, String.valueOf(accNumberFromClient));
                }
                else if(packageData.getOperationType().equals("View Account")) {
                    CityBankAccount infoForClient = manager.getAccount(packageData.getAccount_number());
                    PackageData toClient = new PackageData(infoForClient);
                    outputStream.writeObject(toClient);
                }
                else if(packageData.getOperationType().equals("LIST")) {
                    ArrayList<CityBankAccount> infoForClient = manager.getAccounts();
                    PackageData toClient = new PackageData(infoForClient);
                    outputStream.writeObject(toClient);
                }

            }
            inputStream.close();
            outputStream.close();
            socket.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
