package bankingapp;
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String cusID;
        String passw;
        String nummer = "5";
        int tan;
        Account chris = new Account("C384450", "W6184", (int) (Math.random() * 100));
        Account kim = new Account("G731209", "x93972", (int) (Math.random() * 100));
        Account tim = new Account("P0511231", "Lv3972", (int) (Math.random() * 100));

        welcome();

        System.out.print("Please type in your customer ID: ");
        cusID = sc.nextLine();


        if (cusID.equals(chris.customerID)) {
            System.out.print("Please type in your password: ");
            passw = sc.nextLine();
            if (passw.equals(chris.password)) {
                System.out.println("The generated TAN is " + chris.tan);
                System.out.print("Please type in the generated TAN again to confirm: ");
                tan = sc.nextInt();
                sc.nextLine();
                if (tan == chris.tan)
                    menue();
                else
                    System.out.println("TAN is wrong. Program is closing...");
            } else
                System.out.println("Password is not correct. Program is closing...");
        } else if (cusID.equals(kim.customerID)) {
            System.out.print("Please type in your password: ");
            passw = sc.nextLine();
            if (passw.equals(kim.password)) {
                System.out.println("The generated TAN is " + kim.tan);
                System.out.print("Please type in your TAN again to confirm: ");
                tan = sc.nextInt();
                sc.nextLine();
                if (tan == kim.tan)
                    menue();
                else
                    System.out.println("TAN is wrong. Program is closing...");
            } else
                System.out.println("Password is not correct. Program is closing...");
        } else if (cusID.equals((tim.customerID))) {
            System.out.print("Please type in your password: ");
            passw = sc.nextLine();
            if (passw.equals(tim.password)) {
                System.out.println("The generated TAN is " + tim.tan);
                System.out.print("Please type in the TAN again to confirm: ");
                tan = sc.nextInt();
                sc.nextLine();
                if (tan == tim.tan)
                    menue();
                else
                    System.out.println("TAN is wrong. Program is closing...");
            } else
                System.out.println("Password is not correct. Program is closing...");
        } else
            System.out.println("This customer is not registered in our bank. Program is closing...");
    }


    //Additional methods
    protected static void welcome() {
        System.out.println("--------------------------------------------");
        System.out.println("--------Welcome to your bank account--------");
        System.out.println("--------------------------------------------");
    }

    protected static void menue() {
        Scanner ch = new Scanner(System.in);
        int choice;
        String areyousure;
        double balance = 0.0;
        double previous_balance = 0.0;
        int amount = 0;
        int amtchoice;
        String withanywway;

        do {
            System.out.println("Please choose one of the following options: ");
            System.out.println("<1> Balance");
            System.out.println("<2> Withdraw");
            System.out.println("<3> Deposit");
            System.out.println("<4> Exit");
            choice = ch.nextInt();


            switch (choice) {
                case 1:
                    Scanner scan = null;

                    try {
                        scan = new Scanner(new File("/Users/Chris/IdeaProjects/banking/out/production/banking/accountbalance.txt"));
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    while (scan.hasNext()) {
                        String s = scan.nextLine();
                        if (s.contains("Balance")) {
                            //balance=Double.parseDouble(s); //transform the double in string --> how?!
                            s = Double.toString(balance);
                            System.out.println("Your balance is: " + s.trim());
                        } else {
                            System.out.println("No, not found.");
                        }
                    }
                    scan.close();
                    break;

                case 2:
                    do {
                        System.out.println("Please select how much money you want to withdraw: ");
                        System.out.println("<20€>");
                        System.out.println("<50€>");
                        System.out.println("<100€>");
                        System.out.println("<200€>");
                        System.out.println("<500€>");
                        System.out.println("Select 1 for another amount");
                        System.out.println("Select 2 for quitting.");
                        amtchoice = ch.nextInt();

                        switch (amtchoice) {

                            case 1:
                                File log = new File("/Users/Chris/IdeaProjects/banking/out/production/banking/accountbalance.txt");
                                try {
                                    if (!log.exists()) {
                                        System.out.println("We had to make a new file.");
                                        log.createNewFile();
                                    }
                                    PrintWriter add = new PrintWriter("/Users/Chris/IdeaProjects/banking/out/production/banking/accountbalance.txt", "UTF-8");

                                    System.out.print("Please enter the amount you want to withdraw: ");
                                    amount = ch.nextInt();


                                    if (amount > balance) {
                                        System.out.println("Warning: Your requested amount is bigger than the balance on your bank account. This may cause debt.");
                                        System.out.println("Would you like to withdraw this amount anyway? y/n");
                                        ch.nextLine();

                                        withanywway = ch.nextLine();
                                        if (withanywway.equals("y")) {
                                            System.out.println(amount + " € will be withdrawn.");
                                            balance = balance - amount;
                                        } else {
                                            System.out.println("Action was canceled.");
                                        }
                                    } else {
                                        System.out.println(amount + " € will be withdrawn.");
                                        balance = balance - amount;
                                    }

                                    add.append("Balance: " + balance + "\n");
                                    add.close();
                                } catch (IOException e) {
                                    System.out.println("COULD NOT LOG!!");
                                }
                                break;

                            case 2:
                                System.out.println(""); //just for having an extra line
                                break;

                            case 20:
                                File loga = new File("/Users/Chris/IdeaProjects/banking/out/production/banking/accountbalance.txt");
                                try {
                                    if (!loga.exists()) {
                                        System.out.println("We had to make a new file.");
                                        loga.createNewFile();
                                    }
                                    PrintWriter add = new PrintWriter("/Users/Chris/IdeaProjects/banking/out/production/banking/accountbalance.txt", "UTF-8");

                                    amount = 20;
                                    if (amount > balance) {
                                        System.out.println("Warning: Your requested amount is bigger than the balance on your bank account.");
                                        System.out.println("Would you like to withdraw this amount anyway? y/n");
                                        ch.nextLine();
                                        withanywway = ch.nextLine();
                                        if (withanywway.equals("y")) {
                                            System.out.println(amount + " € will be withdrawn.");
                                            balance = balance - amount;
                                        } else {
                                            System.out.println("Action was canceled.");
                                        }
                                    } else {
                                        System.out.println(amount + " € will be withdrawn.");
                                        balance = balance - amount;
                                    }

                                    add.append("Balance: " + balance + "\n");
                                    add.close();
                                } catch (IOException e) {
                                    System.out.println("COULD NOT LOG!!");
                                }
                                break;

                            case 50:
                                File logb = new File("/Users/Chris/IdeaProjects/banking/out/production/banking/accountbalance.txt");
                                try {
                                    if (!logb.exists()) {
                                        System.out.println("We had to make a new file.");
                                        logb.createNewFile();
                                    }
                                    PrintWriter add = new PrintWriter("/Users/Chris/IdeaProjects/banking/out/production/banking/accountbalance.txt", "UTF-8");

                                    amount = 50;
                                    if (amount > balance) {
                                        System.out.println("Warning: Your requested amount is bigger than the balance on your bank account.");
                                        System.out.println("Would you like to withdraw this amount anyway? y/n");
                                        ch.nextLine();
                                        withanywway = ch.nextLine();
                                        if (withanywway.equals("y")) {
                                            System.out.println(amount + " € will be withdrawn.");
                                            balance = balance - amount;
                                        } else {
                                            System.out.println("Action was canceled.");
                                        }
                                    } else {
                                        System.out.println(amount + " € will be withdrawn.");
                                        balance = balance - amount;
                                    }

                                    add.append("Balance: " + balance + "\n");
                                    add.close();
                                } catch (IOException e) {
                                    System.out.println("COULD NOT LOG!!");
                                }
                                break;

                            case 100:
                                File logc = new File("/Users/Chris/IdeaProjects/banking/out/production/banking/accountbalance.txt");
                                try {
                                    if (!logc.exists()) {
                                        System.out.println("We had to make a new file.");
                                        logc.createNewFile();
                                    }
                                    PrintWriter add = new PrintWriter("/Users/Chris/IdeaProjects/banking/out/production/banking/accountbalance.txt", "UTF-8");


                                    amount = 100;
                                    if (amount > balance) {
                                        System.out.println("Warning: Your requested amount is bigger than the balance on your bank account.");
                                        System.out.println("Would you like to withdraw this amount anyway? y/n");
                                        ch.nextLine();
                                        withanywway = ch.nextLine();
                                        if (withanywway.equals("y")) {
                                            System.out.println(amount + " € will be withdrawn.");
                                            balance = balance - amount;
                                        } else {
                                            System.out.println("Action was canceled.");
                                        }
                                    } else {
                                        System.out.println(amount + " € will be withdrawn.");
                                        balance = balance - amount;
                                    }

                                    add.append("Balance: " + balance + "\n");
                                    add.close();
                                } catch (IOException e) {
                                    System.out.println("COULD NOT LOG!!");
                                }
                                break;

                            case 200:
                                File logd = new File("/Users/Chris/IdeaProjects/banking/out/production/banking/accountbalance.txt");
                                try {
                                    if (!logd.exists()) {
                                        System.out.println("We had to make a new file.");
                                        logd.createNewFile();
                                    }
                                    PrintWriter add = new PrintWriter("/Users/Chris/IdeaProjects/banking/out/production/banking/accountbalance.txt", "UTF-8");


                                    amount = 200;
                                    if (amount > balance) {
                                        System.out.println("Warning: Your requested amount is bigger than the balance on your bank account.");
                                        System.out.println("Would you like to withdraw this amount anyway? y/n");
                                        ch.nextLine();
                                        withanywway = ch.nextLine();
                                        if (withanywway.equals("y")) {
                                            System.out.println(amount + " € will be withdrawn.");
                                            balance = balance - amount;
                                        } else {
                                            System.out.println("Action was canceled.");
                                        }
                                    } else {
                                        System.out.println(amount + " € will be withdrawn.");
                                        balance = balance - amount;
                                    }

                                    add.append("Balance: " + balance + "\n");
                                    add.close();
                                } catch (IOException e) {
                                    System.out.println("COULD NOT LOG!!");
                                }
                                break;

                            case 500:
                                File loge = new File("/Users/Chris/IdeaProjects/banking/out/production/banking/accountbalance.txt");
                                try {
                                    if (!loge.exists()) {
                                        System.out.println("We had to make a new file.");
                                        loge.createNewFile();
                                    }
                                    PrintWriter add = new PrintWriter("/Users/Chris/IdeaProjects/banking/out/production/banking/accountbalance.txt", "UTF-8");


                                    amount = 500;
                                    if (amount > balance) {
                                        System.out.println("Warning: Your requested amount is bigger than the balance on your bank account.");
                                        System.out.println("Would you like to withdraw this amount anyway? y/n");
                                        ch.nextLine();
                                        withanywway = ch.nextLine();
                                        if (withanywway.equals("y")) {
                                            System.out.println(amount + " € will be withdrawn.");
                                            balance = balance - amount;
                                        } else {
                                            System.out.println("Action was canceled.");
                                        }
                                    } else {
                                        System.out.println(amount + " € will be withdrawn.");
                                        balance = balance - amount;
                                    }

                                    add.append("Balance: " + balance + "\n");
                                    add.close();
                                } catch (IOException e) {
                                    System.out.println("COULD NOT LOG!!");
                                }
                                break;

                            default:
                                System.out.println("This is not a valid option");
                                //System.exit(0);
                                break;
                        }
                    } while (amtchoice != 2);
                    break;

                case 3:
                    File log = new File("/Users/Chris/IdeaProjects/banking/out/production/banking/accountbalance.txt");
                    try {
                        if (!log.exists()) {
                            System.out.println("We had to make a new file.");
                            log.createNewFile();
                        }
                        PrintWriter writer = new PrintWriter("/Users/Chris/IdeaProjects/banking/out/production/banking/accountbalance.txt", "UTF-8");

                        System.out.print("Please enter the amount you want to deposit: ");
                        amount = ch.nextInt();
                        ch.nextLine();
                        System.out.println("You have entered " + amount + " € as deposit. Continue? y/n");
                        areyousure = ch.nextLine();
                        if (areyousure.equals("y")) {
                            System.out.println(amount + " € was successfully deposited on your bank account");
                            previous_balance = balance;
                            balance = previous_balance + amount;

                        } else {
                            System.out.println("Please adjust the amount or cancel this action.");
                        }


                        writer.append("Balance: " + balance + "\n");
                        writer.close();
                    } catch (IOException e) {
                        System.out.println("COULD NOT LOG!!");
                    }

                    break;

                case 4:
                    System.out.println("The program is closing...");
                    System.exit(0);

                default:
                    System.out.println("Please enter a valid option.");
                    break;
            }


        } while (choice != 4);
    }
}