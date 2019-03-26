package week4.statesexample;
import java.util.Scanner;

public class Main {

    private static boolean active = true;

    public static void main(String[] args) {

        // create the context
        Grabber grabber = new Grabber();

        System.out.println("Type a number for an event:");
        System.out.println("1. Press Start");
        System.out.println("2. Press Grab");
        System.out.println("3. Insert coins");
        System.out.println("4. Refund funds");
        System.out.println("5. Refill prices");

        Scanner scanner = new Scanner(System.in);
        while (active) {
            try {
                System.out.print("Event: ");
                switch(scanner.nextInt()) {
                    case 0:
                        active = false;
                        break;
                    case 1:
                        grabber.startIsPressed();
                        break;
                    case 2:
                        grabber.grabIsPressed();
                        break;
                    case 3:
                        System.out.print("Enter amount: ");
                        grabber.coinInserted(scanner.nextInt());
                        break;
                    case 4:
                        grabber.refundIsPressed();
                        break;
                    case 5:
                        System.out.print("Enter amount: ");
                        grabber.refillGrabber(scanner.nextInt());
                        break;
                    default:
                        System.out.print("Unknown event");
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Ignore that... restarting machine");
                grabber = new Grabber();
            }
        }
    }
}

