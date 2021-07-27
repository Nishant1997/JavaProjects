package numbers.ErrorHandling;

import numbers.Display.Print;
import numbers.common.Properties;

import java.util.ArrayList;
import java.util.List;

public class ErrorValidator {

    Print print = new Print();
    Properties prop = new Properties();

    public void firstParamError() {
        System.out.println("The first parameter should be a natural number or zero.");
    }
    public void secondParamError() {
        System.out.println("The second parameter should be a natural number.");
    }

    public void thirdParamError(List<String> invalidProp) {
        String msg = "";
        if(invalidProp.size()>1){
            msg = "The properties "+ invalidProp +" are wrong.";
        }
        else{
            msg = "The property "+ invalidProp +" is wrong.";
        }

        String availableProp = "Available properties: [" + prop.availString() + "]";
        System.out.println(msg+"\n"+availableProp);
    }

    public void validate(String[] choices) throws Exception {
        if(choices.length > 2 ){
            //validate property
            validateProperties(choices);
        }
        if(choices.length > 1 ){
            validateParam2(choices[1]);
        }

        if(choices == null || choices[0].isBlank() || choices[0].isEmpty()){
            print.instructions();
            throw new Exception();
        }
        else {
            validateParam1(choices[0]);
        }

    }

    private void validateProperties(String[] choices) throws Exception{
        List<String> invalidProp = new ArrayList<>();
        List<String> validProp = new ArrayList<>();
        for (int i = 2 ; i< choices.length; i++ ) {
            String s = choices[i];
            if(!prop.isValidProperty(s))
                invalidProp.add(s);
            else
                validProp.add(s);
        }
        if(invalidProp.size()>0){
            thirdParamError(invalidProp);
            throw new Exception();
        }
        if(validProp.size()>1 && prop.hasMutualExcProp(validProp)){
            mutualluExclusiveError(validProp);
            throw new Exception();
        }
    }

    private void mutualluExclusiveError(List<String> invalidProp) {
        System.out.println(
                "The request contains mutually exclusive properties: "+invalidProp.toString()+"\n" +
                "There are no numbers with these properties.");
    }

    public void validateParam1(String param) throws Exception {
        try{
            Long l = Long.parseLong(param);
            checkForNegativeNumber(l);
        }
        catch (Exception e){
            firstParamError();
            throw new Exception();
        }
    }

    private void checkForNegativeNumber(Long l) throws Exception{
        if(l < 0) {
            throw new Exception();
        }
    }
    public void validateParam2(String param) throws Exception {
        try{
            Long l = Long.parseLong(param);
            checkForNegativeNumber(l);
        }
        catch (Exception e){
            secondParamError();
            throw new Exception();
        }
    }

}
