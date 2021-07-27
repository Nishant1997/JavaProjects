package numbers.Display;

import numbers.common.Number;
import numbers.common.Properties;

import java.util.Arrays;

public class Print {

    public void properties(Number num) {
        Properties prop = num.getProp();
        System.out.println("Properties of "+num.getNum());
        System.out.print("\t\t even: "+prop.getEven()+
                "\n\t\t odd: "+!prop.getEven()+
                "\n\t\t buzz: "+prop.getBuzz()+
                "\n\t\t duck: "+prop.getDuck()+
                "\n\tpalindromic: "+prop.getPalindrom()+
                "\n\t\tgapful: "+prop.getGapful()+
                "\n\t\t sunny: "+prop.getSunny()+
                "\n\t\tsquare: "+prop.getSquare()+
                "\n\t\tJumping: "+prop.getJumping()+
                "\n\t\thappy: "+prop.getHappy()+
                "\n\t\tsad: "+prop.getSad()+
                "\n\t\tspy: "+prop.getSpyNumber());
    }

    public void instructions() {
        System.out.println("Supported requests:\n" +
                "- enter a natural number to know its properties;\n" +
                "- enter two natural numbers to obtain the properties of the list:\n" +
                "  * the first parameter represents a starting number;\n" +
                "  * the second parameter shows how many consecutive numbers are to be processed;\n" +
                "- two natural numbers and properties to search for;\n" +
                "- a property preceded by minus must not be present in numbers;\n" +
                "- separate the parameters with one space;\n" +
                "- enter 0 to exit.");
    }

    public void welComeUser() {
        System.out.println("Welcome to Amazing Numbers!\n");
    }

    public void listNumber(Number num) {
        Properties prop = num.getProp();
        String gful = (prop.getGapful() ? "gapful," : "") ;
        String duck = (prop.getDuck() ? "duck," : "") ;
        String buzz = (prop.getBuzz() ? "buzz," : "" );
        String pdrom = (prop.getPalindrom() ? "palindrom," : "") ;
        String spy = (prop.getSpyNumber() ? "spy," : "") ;
        String sunny = (prop.getSunny() ? "sunny," : "") ;
        String square = (prop.getSquare() ? "square," : "") ;
        String jumping = (prop.getJumping() ? "jumping," : "") ;
        String happy = (prop.getHappy() ? "happy," : "") ;
        String sad = (prop.getSad() ? "sad," : "") ;
        String parity = prop.getEven() ? "even" : "odd";

        System.out.println(num.getNum() +" is " + gful + jumping+duck +spy + buzz+
                pdrom+sunny+happy+sad+square+parity);
    }

    public void exitMsg() {
        System.out.print("Goodbye!");
    }
}
