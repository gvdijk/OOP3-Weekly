package week3.states;

import java.util.Scanner;

public class Client {

    private static boolean active = true;

    public static void main(String[] args) {

        // create the context
        ATM atm = new ATM(100);

        System.out.println("Type a number for an event:");
        System.out.println("1. Insert card");
        System.out.println("2. Enter PIN code");
        System.out.println("3. Enter amount");
        System.out.println("4. Eject card");
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        try {
            while (active) {
                System.out.print("Event: ");
                switch(scanner.nextInt()) {
                    case 0:
                        active = false;
                        break;
                    case 1:
                        atm.insertCard();
                        break;
                    case 2:
                        atm.enterPin();
                        break;
                    case 3:
                        System.out.print("Enter amount: ");
                        atm.requestAmount(scanner.nextInt());
                        break;
                    case 4:
                        atm.ejectCard();
                        break;
                    default:
                        System.out.print("Unknown event");
                }
            }
        } catch (Exception e) { e.printStackTrace(); }

    }
}
