package gym;


import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Ashkan Amiri
 * Date:  2020-10-12
 * Time:  18:07
 * Project: gym
 * Copyright: MIT
 */
class ListUtilTest {

    private final ListUtil listUtil = new ListUtil();

    @Test
    void readAndAddFileTest() {
        listUtil.test = true;
        List<Customer> customerList = listUtil.getCustomersFromFile();
        assertNotNull(customerList);
        assertEquals(customerList.size(), 2);
    }

    @Test
    void checkCustomerRegisterDatePositiveTest() {
        listUtil.test = true;
        List<Customer> customerList = listUtil.getCustomersFromFile();
        List<Customer> gymMemberList;
        gymMemberList = listUtil.checkCustomerRegisterDate(customerList, "7608021234");//True
        assertEquals(gymMemberList.size(), 1);
        gymMemberList = listUtil.checkCustomerRegisterDate(customerList, "Diamanda Djedi");//True
        assertEquals(gymMemberList.size(), 1);
    }

    @Test
    void checkCustomerRegisterDateNegativeTest() {
        listUtil.test = true;
        List<Customer> customerList = listUtil.getCustomersFromFile();
        List<Customer> gymMemberList;
        gymMemberList = listUtil.checkCustomerRegisterDate(customerList, "Chamade Coriola");//Fals
        assertEquals(gymMemberList.size(), 0);
    }


    @Test
    void addMemberToFilePositiveTest() {
        listUtil.test = true;
        listUtil.name = "Greger Ganache";
        List<Customer> gymMemberList = listUtil.addMemberToFile();
        assertEquals(gymMemberList.size(), 1);
    }

    @Test
    void addMemberToFileNegativeTest() {
        listUtil.test = true;
        listUtil.name = "Ashkan";
        List<Customer> gymMemberList = listUtil.addMemberToFile();
        assertEquals(gymMemberList.size(), 0);
    }

    @Test
    void saveToFileTest() {

        listUtil.test = true;
        Customer c = new Customer("9108302222","Ashkan","2020-10-10",DateUtil.getDateNowFormat());
        List<Customer> customers = new ArrayList<>();
        customers.add(c);
        listUtil.saveToPtFile(customers);
        Scanner readFile = null;
        try {
            readFile = new Scanner(new File("test/gym/PtCustomerFileTest.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
        assertTrue(readFile.hasNextLine());
        readFile.close();
    }

}