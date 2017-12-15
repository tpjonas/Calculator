package cimdata.android.dez2017.calculator;

import android.util.Log;
import java.lang.reflect.Array;
import java.util.Observable;


public class Calculator extends Observable{

    private double right;
    private double left;

    public static String MULTIPLY = "multiply";
    public static String ADD = "add";
    public static String SUBSTRACT = "substract";
    public static String DIVIDE = "divide";

    private String operator;

    private boolean dotIsSet = false;


    private int multiplierBeforeDecimalPoint = 10;
    private double multiplierAfterDigitalPoint = 1.0;



    public Calculator() {

        left = right = 0;

    }
    public void setOperator(String operator) {

        calculateResult();
        this.operator = operator;

    }

    public void put(int digit) {

        if(dotIsSet) {
            multiplierBeforeDecimalPoint = 1;
            multiplierAfterDigitalPoint /= 10;
        }

        if (this.operator == null) {
            left = left * multiplierBeforeDecimalPoint + digit * multiplierAfterDigitalPoint;
            setChanged();
            notifyObservers(left);
        } else {
            right = right * multiplierBeforeDecimalPoint + digit * multiplierAfterDigitalPoint;
            setChanged();
            notifyObservers(right);
        }

    }

    public void setDot() {

        dotIsSet = true;
    }

    public void equals() {

        calculateResult();
        this.operator = null;


    }

    private void calculateResult() {

        if (this.operator == MULTIPLY) {
            left = left * right;
        } else if (this.operator == DIVIDE) {
            left = left / right;
        } else if (this.operator == ADD) {
            left = left + right;
        } else if (this.operator == SUBSTRACT) {
            left = left - right;
        }

        right = 0;
        dotIsSet = false;
        multiplierBeforeDecimalPoint = 10;
        multiplierAfterDigitalPoint = 1;

        setChanged();
        notifyObservers(left);
    }

    public void reset() {

        this.operator = null;
        left = right = 0;

        multiplierBeforeDecimalPoint = 10;
        multiplierAfterDigitalPoint = 1;

        dotIsSet = false;

        setChanged();
        notifyObservers(0);

    }

    public void changePrefeix() {

        setChanged();

        if (this.operator == null) {
            left = left * -1;
            notifyObservers(left);
        } else {
            right = right * -1;
            notifyObservers(right);
        }

    }


}



/**

 ScriptEngine se = new ScriptEngineManager().getEngineByName("nashorn");
 dann:
 String result = String.valueOf(se.eval(expression));


 **/