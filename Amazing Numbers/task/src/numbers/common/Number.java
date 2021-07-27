package numbers.common;

import numbers.Execution.PropertyChecker;

public class Number {

    PropertyChecker checker = new PropertyChecker();
    Properties prop = new Properties();
    private Long num ;

    public Properties getProp() {
        return prop;
    }

    public void setProp(Properties prop) {
        this.prop = prop;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public Number (Long num){
        this.num = num;
    }

    public String getString(){
        return num.toString();
    }

    public Boolean hasAllProperties(String[] prop){
        int i=0;
        for (String s: prop) {
            if(s.startsWith("-") && hasAProperty(getProp().getEnumFromStr(s.substring(1))))
                return false;
            else if(!s.startsWith("-") && !hasAProperty(getProp().getEnumFromStr(s)))
                return false;
        }
        return true;
    }

    public Boolean hasAProperty(Properties.ProperitesEnum propName){
        switch (propName){
            case BUZZ:
                checker.buzzChecker(this);
                return prop.getBuzz();
            case DUCK:
                checker.duckChecker(this);
                return prop.getDuck();
            case EVEN:
                checker.parityCheck(this);
                return prop.getEven();
            case ODD:
                checker.parityCheck(this);
                return prop.getOdd();
            case GAPFUL:
                checker.gapfulChecker(this);
                return prop.getGapful();
            case PALINDROMIC:
                checker.palindromChecker(this);
                return prop.getPalindrom();
            case SPY:
                checker.spyNumbChecker(this);
                return prop.getSpyNumber();
            case SUNNY:
                checker.sunnyNumber(this);
                return prop.getSunny();
            case SQUARE:
                checker.squareNumber(this);
                return prop.getSquare();
            case JUMPING:
                checker.jumping(this);
                return prop.getJumping();
            case HAPPY:
                checker.happyorSad(this);
                return prop.getHappy();
            case SAD:
                checker.happyorSad(this);
                return prop.getSad();
            default:
                return false;
        }
    }


    public boolean hasAProperty() {
        return hasAProperty(getProp().getFilteredPropName());
    }


}
