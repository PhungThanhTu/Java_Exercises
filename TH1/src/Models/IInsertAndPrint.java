package Models;

import java.util.regex.*;

/**
 * Interface manage input and output
 */
public interface IInsertAndPrint {
    void insert();
    void print();


    /**
     * Using regex to check if model value valid
     * @param input input string
     * @return false if int string isn't valid, true if that string valid
     */
    static Boolean checkValidModel(String input){
        String regex = "[A-Za-z0-9]*";
        Pattern pat = Pattern.compile(regex);
        Matcher result = pat.matcher(input);
        return result.matches();
    }


}
