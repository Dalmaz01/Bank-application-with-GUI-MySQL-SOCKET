package bankapplication.midterm1;

import java.io.Serializable;
import java.util.ArrayList;

public class PackageData implements Serializable {
    private String operationType;
    private int pinCode;
    private int account_number;
    private String cash;
    private CityBankAccount cityBankAccount;
    private int oldPinCode;
    private int newPinCode;
    private String name;
    private String surname;
    private ArrayList<CityBankAccount> cityBankAccounts;

    public PackageData(String operationType, int pinCode, int account_number) {
        this.operationType = operationType;
        this.pinCode = pinCode;
        this.account_number = account_number;
    }

    public PackageData(String operationType, String cash, int account_number) {
        this.operationType = operationType;
        this.cash = cash;
        this.account_number = account_number;
    }
    public PackageData(String operationType, String operation , String oper) {
        this.operationType = operationType;

    }

    public PackageData(String operationType, int account_number) {
        this.operationType = operationType;
        this.account_number = account_number;
    }

    public PackageData(String cash) {
        this.cash = cash;
    }

    public PackageData(String operationType, int oldPinCode, int newPinCode, int account_number) {
        this.operationType = operationType;
        this.oldPinCode = oldPinCode;
        this.newPinCode = newPinCode;
        this.account_number = account_number;
    }
    public PackageData(ArrayList<CityBankAccount> cityBankAccounts) {
        this.cityBankAccounts = cityBankAccounts;
    }

    public PackageData(CityBankAccount cityBankAccount) {
        this.cityBankAccount = cityBankAccount;
    }

    public int getOldPinCode() {
        return oldPinCode;
    }

    public void setOldPinCode(int oldPinCode) {
        this.oldPinCode = oldPinCode;
    }

    public int getNewPinCode() {
        return newPinCode;
    }

    public void setNewPinCode(int newPinCode) {
        this.newPinCode = newPinCode;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public int getAccount_number() {
        return account_number;
    }

    public void setAccount_number(int account_number) {
        this.account_number = account_number;
    }

    public CityBankAccount getCityBankAccount() {
        return cityBankAccount;
    }

    public void setCityBankAccount(CityBankAccount cityBankAccount) {
        this.cityBankAccount = cityBankAccount;
    }

    public String getCash() {
        return cash;
    }

    public void setCash(String cash) {
        this.cash = cash;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public ArrayList<CityBankAccount> getCityBankAccounts() {
        return cityBankAccounts;
    }

    public void setCityBankAccounts(ArrayList<CityBankAccount> cityBankAccounts) {
        this.cityBankAccounts = cityBankAccounts;
    }
}
