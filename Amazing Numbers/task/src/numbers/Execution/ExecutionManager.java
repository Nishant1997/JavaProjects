package numbers.Execution;

import numbers.Display.Print;
import numbers.ErrorHandling.ErrorValidator;
import numbers.InputHandling.InputManager;
import numbers.common.Number;
import numbers.common.Properties;

public class ExecutionManager {

    private final InputManager input = new InputManager();
    private final ErrorValidator errorMsg = new ErrorValidator();
    private final Print print = new Print();
    private final PropertyChecker checker = new PropertyChecker();

    public void execute() {
        Long choice = -1L;
        while(choice != 0){
            try{
                String[] choices = input.getRequest();
                errorMsg.validate(choices);
                choice = Long.parseLong(choices[0]);
                if(choice != 0){
                    if(choices.length > 2){
                        String[] newArr = new String[choices.length-2];
                        System.arraycopy(choices,2,newArr,0,choices.length-2);
                        exeForMultipleInputs(
                                Long.parseLong(choices[0]),Long.parseLong(choices[1]),newArr);
                    }
                    else if(choices.length == 2)
                        exeFor2Inputs(Long.parseLong(choices[0]),Long.parseLong(choices[1]));
                    else if(choices.length == 1)
                        exeFor1Inputs(Long.parseLong(choices[0]));
                }
            }
            catch(Exception e){
                //do nothing
            }

        }
    }

    private void exeFor1Inputs(Long i1) {
        Number number = new Number(i1);
        checker.checkPropertiesOfNumber(number);
        print.properties(number);
    }

    private void exeFor2Inputs(Long i1, Long i2) {
        int i = 0;
        while (i < i2) {
            Number number = new Number(i1+i);
            checker.checkPropertiesOfNumber(number);
            print.listNumber(number);
            i++;
        }
    }

    private void exeForMultipleInputs(Long i1,Long i2,String []prop) {
            int i = 0;
            int count = 0;
            while(count < i2){
                Number num = new Number(i1+i);
                if(num.hasAllProperties(prop)){
                    checker.checkPropertiesOfNumber(num);
                    print.listNumber(num);
                    count++;
                }
                i++;
         }
    }
}
