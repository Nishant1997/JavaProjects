package numbers.InputHandling;

import java.util.Scanner;

public class InputManager {

    public static final Scanner scan = new Scanner(System.in);

    public String[] getRequest() {
        System.out.println("\n Enter a request: ");
        return scan.nextLine().split(" ");
    }
}
