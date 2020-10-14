package gym;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Ashkan Amiri
 * Date:  2020-10-12
 * Time:  13:24
 * Project: gym
 * Copyright: MIT
 */
public class ListUtil {
     //två instans variable används när testerna körs
    public Boolean test = false;
    public String name = null;

    String filePathIn = "resource/customers.txt";
    String filePathOut = "resource/ptCustomerFile.txt";

    public List<Customer> getCustomersFromFile() {
        List<Customer> customersList = new ArrayList<>();
        if (test)
            filePathIn = "test/gym/customersTest.txt";
        try (Scanner readFile = new Scanner(new File(filePathIn))) {
            while (readFile.hasNextLine()) {
                Customer customerInfo = new Customer();
                String[] split = readFile.nextLine().split(",");
                customerInfo.setPersonNumber(split[0]);
                customerInfo.setName(split[1]);
                String registeredDate = readFile.nextLine();
                customerInfo.setRegDate(registeredDate);
                customersList.add(customerInfo);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File could not found");
            e.printStackTrace();
        }
        return customersList;
    }


    public List<Customer> addMemberToFile() {
        ListUtil listUtil = new ListUtil();
        List<Customer> customerList = listUtil.getCustomersFromFile();
        List<Customer> gymMemberList;
        while (true) {
            if (test) {
                gymMemberList = checkCustomerRegisterDate(customerList, name);
                return gymMemberList;
            } else {
                String inParam = JOptionPane.showInputDialog("Select your personal number or name!");
                if (inParam == null || inParam.isEmpty() || inParam.isBlank())
                    System.exit(0);
                inParam.trim();
                gymMemberList = checkCustomerRegisterDate(customerList, inParam);
            }
            if (gymMemberList.size() > 0)
                saveToPtFile(gymMemberList);
        }
    }

    protected void saveToPtFile(List<Customer> gymMemberList) {
        System.out.println("gymMemberList\n " + gymMemberList);
        if (test)
            filePathOut = "test/gym/PtCustomerFileTest.txt";

        String textToAppend = gymMemberList.get(0).toString();
        try (FileWriter fileWriter = new FileWriter(filePathOut, true);//Set true for append mode.
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            printWriter.println(textToAppend);  //New line
        } catch (FileNotFoundException e) {
            System.out.println("File could not be found");
        } catch (IOException e) {
            System.out.println("Could not write to file");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("File error");
        }
    }

    protected List<Customer> checkCustomerRegisterDate(List<Customer> customerList, String inParam) {
        List<Customer> gymMemberList = new ArrayList<>();
        long differentDays;
        boolean check = false;
        for (Customer customer : customerList) {
            if (customer.getName().equalsIgnoreCase(inParam) || customer.getPersonNumber().equals(inParam)) {
                differentDays = DateUtil.durationDates(customer.getRegDate());
                if (differentDays <= 365) {
                        customer.setCurrentDate((DateUtil.getDateNowFormat()));
                        gymMemberList.add(customer);
                    if (test)
                        System.out.println("Welcome in");
                    else
                        JOptionPane.showMessageDialog(null, "Welcome in");
                        check = true;
                        break;
                    }
                }
            }
        if (!check) {
            if (test) {
                System.out.println("\"Your membership is finish or your not member " +
                        "\nPleas contact reception and register again\"");
            } else
                JOptionPane.showMessageDialog(null,
                        "Your membership is finish or your not member \nPleas contact reception and register again");
        }
        return gymMemberList;
    }
}
