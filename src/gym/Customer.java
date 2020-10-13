package gym;

/**
 * Created by Ashkan Amiri
 * Date:  2020-10-09
 * Time:  17:33
 * Project: gym
 * Copyright: MIT
 */
public class Customer {
    private String name;
    private String personNumber;
    private String regDate;
    private String currentDate;

    public Customer(String personNumber, String name, String regDate ) {
        this.personNumber = personNumber;
        this.name = name;
        this.regDate = regDate;
    }

    public Customer() {}

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    public String getPersonNumber() {
        return personNumber;
    }

    public void setPersonNumber(String personNumber) {
        this.personNumber = personNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.trim();
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    @Override
    public String toString() {
        return "|----Customers report----|\n" +
                "Name--->" + name + "\n" +
                "Personal Number--->" + personNumber + "\n" +
                "Registered date--->" + regDate + "\n" +
                "Entry Time--->" + currentDate + "\n";
    }
}
