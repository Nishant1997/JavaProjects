package numbers.Execution;

import numbers.common.Number;
import numbers.common.Properties;

public class PropertyChecker {

    public PropertyChecker(){
    }

    public PropertyChecker(Number num) {
        checkPropertiesOfNumber(num);
    }

    public void checkPropertiesOfNumber(Number num){
        parityCheck(num);
        buzzChecker(num);
        duckChecker(num);
        palindromChecker(num);
        gapfulChecker(num);
        spyNumbChecker(num);
        squareNumber(num);
        sunnyNumber(num);
        jumping(num);
        happyorSad(num);
    }

    public void happyorSad(Number num) {
        String str = num.getString();
        Long sum = 99999999L;
        while (sum > 9 ){
            sum=0L;
            for (char c: str.toCharArray()) {
                sum += (long)Math.pow((c-'0'),2);
            }
            str = String.valueOf(sum);
        }
        if(sum == 1 || sum == 7){
            num.getProp().setSad(false);
            num.getProp().setHappy(true);
            num.getProp().property.add(Properties.ProperitesEnum.HAPPY);
        }
        else{
            num.getProp().setSad(true);
            num.getProp().setHappy(false);
            num.getProp().property.add(Properties.ProperitesEnum.SAD);
        }
    }

    public void jumping(Number num) {
        Long l = num.getNum();
        Properties prop = num.getProp();
        char[] arry = num.getString().toCharArray();
        for(int i=0;i<arry.length-1;i++){
            if(Math.abs(arry[i]-arry[i+1]) != 1) {
                prop.setJumping(false);
                return;
            }
        }
        prop.setJumping(true);
        prop.property.add(Properties.ProperitesEnum.JUMPING);
    }

    public void sunnyNumber(Number num) {
        Long d = (long)Math.sqrt(num.getNum()+1);
        if(d * d == num.getNum()+1){
            num.getProp().property.add(Properties.ProperitesEnum.SUNNY);
            num.getProp().setSunny(true);
        }
        else{
            num.getProp().setSunny(false);
        }
    }

    public void squareNumber(Number num) {
        long d = (long)Math.sqrt(num.getNum());
        if(d * d == num.getNum()){
            num.getProp().property.add(Properties.ProperitesEnum.SQUARE);
            num.getProp().setSquare(true);
        }
        else{
            num.getProp().setSquare(false);
        }
    }

    public void spyNumbChecker(Number num) {
        long sum = 0;
        long mul = 1;
        char []numChar = num.getNum().toString().toCharArray();
        for (char c:numChar) {
            sum+= c - '0';
            mul*= c - '0';
        }
        Properties prop = num.getProp();
        if(sum == mul ) {
            prop.setSpyNumber(true);
            prop.property.add(Properties.ProperitesEnum.SPY);
        }
        else{
            prop.setSpyNumber(false);
        }
    }


    public  void gapfulChecker(Number num) {
        String str = num.getString();
        Integer div = Integer.parseInt(String.valueOf(str.charAt(0))
                + str.charAt(str.length() - 1));
        Properties prop = num.getProp();
        if(str.length() > 2 && num.getNum() % div == 0){
            prop.setGapful(true);
            prop.property.add(Properties.ProperitesEnum.GAPFUL);
        }
        else{
            prop.setGapful(false);
        }

    }

    public  void palindromChecker(Number num) {
        StringBuilder stringBuilder = new StringBuilder(num.getString()).reverse();
        if(num.getString()==stringBuilder.toString()){
            num.getProp().setPalindrom(true) ;
            num.getProp().property.add(Properties.ProperitesEnum.PALINDROMIC);
        }
    }

    public  void duckChecker(Number num) {
        String str = String.valueOf(num.getNum());
        Properties prop = num.getProp();
        if(str.contains("0")){
            prop.setDuck(true);
            prop.property.add(Properties.ProperitesEnum.DUCK);
        }
        else{
            prop.setDuck(false);
        }
    }

    public  void buzzChecker(Number num) {
        Properties prop = num.getProp();
        if(num.getNum() % 10 == 7 || num.getNum() % 7 == 0) {
            prop.setBuzz(true);
            prop.property.add(Properties.ProperitesEnum.BUZZ);
        }
        else{
            prop.setBuzz(false);
        }
    }

    public  void parityCheck(Number num) {
        Long input = num.getNum();
        Properties prop = num.getProp();
        if(input % 2 == 0 ){
            prop.setEven(true);
            prop.setOdd(false);
            prop.property.add(Properties.ProperitesEnum.EVEN);
        }
        else{
            prop.setEven(false);
            prop.setOdd(true);
            prop.property.add(Properties.ProperitesEnum.ODD);
        }
    }
}
