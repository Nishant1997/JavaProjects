package numbers.Execution;

import numbers.Display.Print;

//use this as a tester for the project
public class Main {

    public int one = 1;
    public static Print print = new Print();
    public static void main(String[] args) {
        //write your code here
        print.welComeUser();
        print.instructions();
        ExecutionManager manager = new ExecutionManager();
        manager.execute();
        print.exitMsg();
        Main.main(null);
    }
}
