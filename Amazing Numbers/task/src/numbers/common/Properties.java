package numbers.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Properties {

    private  Boolean even = false;
    private  Boolean buzz = false;
    private  Boolean duck = false;
    private  Boolean palindrom = false;
    private  Boolean gapful = false;
    private  Boolean odd = false;
    private  Boolean spyNumber = false;
    private  Boolean sunny = false; // n+1 is square
    private  Boolean square = false;
    private Boolean jumping = false;
    private Boolean happy = false;
    private Boolean sad = false;

    public Boolean getHappy() {
        return happy;
    }

    public void setHappy(Boolean happy) {
        this.happy = happy;
    }

    public Boolean getSad() {
        return sad;
    }

    public void setSad(Boolean sad) {
        this.sad = sad;
    }

    public enum ProperitesEnum {
        EVEN,BUZZ,DUCK,PALINDROMIC,GAPFUL,ODD,SPY,SQUARE,SUNNY,JUMPING,HAPPY,SAD,NILL
    }
    public ProperitesEnum filteredPropName = ProperitesEnum.NILL;
    public List<Enum> property = new ArrayList<>();

    public Boolean getJumping() {
        return jumping;
    }

    public void setJumping(Boolean jumping) {
        this.jumping = jumping;
    }

    public Boolean getSunny() {
        return sunny;
    }

    public void setSunny(Boolean sunny) {
        this.sunny = sunny;
    }

    public Boolean getSquare() {
        return square;
    }

    public void setSquare(Boolean square) {
        this.square = square;
    }

    public List<Enum> getProperty() {
        return property;
    }

    public void setProperty(List<Enum> property) {
        this.property = property;
    }

    public ProperitesEnum getFilteredPropName() {
        return filteredPropName;
    }

    public void setFilteredPropName(ProperitesEnum filteredPropName) {
        this.filteredPropName = filteredPropName;
    }

    public ProperitesEnum getEnumFromStr(String st){
        for (ProperitesEnum e : ProperitesEnum.values()) {
            if(e.name().equalsIgnoreCase(st)) return e;
        }
        return ProperitesEnum.NILL;
    }

    public void setFilteredPropName(String filteredPropName) {
        setFilteredPropName(getEnumFromStr(filteredPropName));
    }
    public Boolean getSpyNumber() {
        return spyNumber;
    }
    public void setSpyNumber(Boolean spyNumber) {
        this.spyNumber = spyNumber;
    }

    public String availString() {
        String str = "";
        for (ProperitesEnum e: ProperitesEnum.values()) {
            if(e == ProperitesEnum.NILL) continue;
            str+=e.name()+",";
        }
        return str.substring(0,str.length()-1);
    }

    public Boolean getOdd() {
        return odd;
    }
    public void setOdd(Boolean odd) {
        this.odd = odd;
    }

    public Boolean getEven() {
        return even;
    }
    public void setEven(Boolean even) {
        this.even = even;
    }

    public Boolean getBuzz() {
        return buzz;
    }
    public void setBuzz(Boolean buzz) {
        this.buzz = buzz;
    }

    public Boolean getDuck() {
        return duck;
    }
    public void setDuck(Boolean duck) {
        this.duck = duck;
    }

    public Boolean getPalindrom() {
        return palindrom;
    }

    public void setPalindrom(Boolean palindrom) {
        this.palindrom = palindrom;
    }

    public Boolean getGapful() {
        return gapful;
    }

    public void setGapful(Boolean gapful) {
        this.gapful = gapful;
    }

    public Boolean isValidProperty(String prop){
        try{
            if(prop.startsWith("-")){
                prop = prop.substring(1);
            }
            ProperitesEnum.valueOf(prop.toUpperCase(Locale.ROOT));
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public Boolean hasMutualExcProp(List<String> prop){
        for(int i=0;i<prop.size()-1;i++){
            for(int j=i+1;j<prop.size();j++) {
                if (areMutuallyExc(prop.get(i), prop.get(j)))
                    return true;
            }
        }
        return false;
    }

    public Boolean areMutuallyExc(String val1,String val2){
       val1 = val1.toLowerCase(Locale.ROOT);
       val2 = val2.toLowerCase(Locale.ROOT);

        if((val1.startsWith("-") && val1.contains(val2)) || (val2.startsWith("-") && val2.contains(val1))){
            return true;
        }
        if((val1.equalsIgnoreCase("-even") && val2.equalsIgnoreCase("-odd"))
                ||(val2.equalsIgnoreCase("-even") && val1.equalsIgnoreCase("-odd"))
                ||(val1.equalsIgnoreCase("-duck") && val2.equalsIgnoreCase("-spy"))
                ||(val2.equalsIgnoreCase("-duck") && val1.equalsIgnoreCase("-spy"))
                ||(val1.equalsIgnoreCase("-happy") && val2.equalsIgnoreCase("-sad"))
                ||(val2.equalsIgnoreCase("-happy") && val1.equalsIgnoreCase("-sad")))
            return true;
        return (val1.equalsIgnoreCase("even") && val2.equalsIgnoreCase("odd"))
                || (val2.equalsIgnoreCase("even") && val1.equalsIgnoreCase("odd"))
                || (val1.equalsIgnoreCase("duck") && val2.equalsIgnoreCase("spy"))
                || (val2.equalsIgnoreCase("duck") && val1.equalsIgnoreCase("spy"))
                || (val1.equalsIgnoreCase("sunny") && val2.equalsIgnoreCase("square"))
                || (val2.equalsIgnoreCase("sunny") && val1.equalsIgnoreCase("square"))
                || (val1.equalsIgnoreCase("happy") && val2.equalsIgnoreCase("sad"))
                || (val2.equalsIgnoreCase("happy") && val1.equalsIgnoreCase("sad"));
    }



}
