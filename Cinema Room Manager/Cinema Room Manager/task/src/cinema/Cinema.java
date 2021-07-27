package cinema;


import java.util.Scanner;

public class Cinema {

    public static final Scanner scanner = new Scanner(System.in);
    public  static int purchasedTickets = 0;
    public  static int totalIncome = 0;
    public  static int rowNumber = -1;
    public  static int seatNumber = -1;
    public static int rows = 0;
    public static int seats = 0;

    public static void main(String[] args) {
        // Write your code here

        System.out.print("Enter the number of rows:\n");
         rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
         seats = scanner.nextInt();

        int [][]seatsArray = new int[rows][seats];
        int choice = getSelectedChoiceMenu();
        while(choice != 0)
        {
            if(choice==1)
            {
                SeatsArrangment(seatsArray);
            }
            else if(choice==2)
            {
                BuyATicket(seatsArray);
            }
            else if(choice==3)
            {
                showStatistics();
            }
            else
            {
                System.out.println("Enter a valid choice");
            }
            choice = getSelectedChoiceMenu();
        }

    }

    private static void showStatistics() {
        System.out.println("Number of purchased tickets : "+purchasedTickets);
        float percentage = ((float) purchasedTickets/(rows*seats))*100;
        System.out.printf("Percentage: %.2f%%%n",percentage);
        //System.out.println("Percentage: "+(percentage*100.00)/100.00+"%");
        System.out.println("Current income: $"+totalIncome);
        int maxIncome = (rows/2)*seats*10+(rows-(rows/2))*seats*8;
        System.out.println("Total income: $"+maxIncome);
    }

    private static int getSelectedChoiceMenu() {
        System.out.print("\n1.Show the seats \n2.Buy a ticket \n3.Statistics\n0.Exit\n");
        return scanner.nextInt();
    }

    private static void BuyATicket(int [][]seatsArray) {
        getSeatNumber();
        while(true)
        {
            if(rowNumber>rows || seatNumber > seats)
            {
                System.out.print("Wrong input!");
                getSeatNumber();
            }
            else if (seatsArray[rowNumber-1][seatNumber-1]!=0)
            {
                System.out.println("That ticket has already been purchased!");
                getSeatNumber();
            }
            else
            {
                break;
            }
        }
        if(rows*seats <= 60 || rowNumber <=rows/2)
        {
            System.out.println("Ticket Price: $10");
            seatsArray[rowNumber-1][seatNumber-1]=10;
            totalIncome = totalIncome+10;
        }
        else
        {
            System.out.println("Ticket Price: $8");
            seatsArray[rowNumber-1][seatNumber-1]=8;
            totalIncome = totalIncome+8;
        }
        purchasedTickets++;
    }

    private static void getSeatNumber() {
        System.out.println("\nEnter a row number:");
        rowNumber = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        seatNumber = scanner.nextInt();
    }

    public static void SeatsArrangment(int [][]seatsArray)
    {
        System.out.print("Cinema:\n");
        for(int i=0;i<=rows;i++)
        {
            for (int j=0;j<=seats;j++)
            {
                if(i==0&&j==0)
                {
                    System.out.print("  ");
                }
                else if(i==0)
                {
                    System.out.printf("%d ",j);
                }
                else if(j==0)
                {
                    System.out.printf("%d ",i);
                }
                else if(seatsArray[i-1][j-1]>=1)
                {
                    System.out.print("B ");
                }
                else
                {
                    System.out.print("S ");
                }
            }
            if(i!=rows)
            {
                System.out.print("\n");
            }

        }
    }
}