package gym;

/**
 * Created by Ashkan Amiri
 * Date:  2020-10-09
 * Time:  15:09
 * Project: gym
 * Copyright: MIT
 */
public class Main {

    private static ListUtil listUtil = new ListUtil();

    public static void main(String[] args) {
        listUtil.getCustomersFromFile();
        listUtil.addMemberToFile();
    }
}
