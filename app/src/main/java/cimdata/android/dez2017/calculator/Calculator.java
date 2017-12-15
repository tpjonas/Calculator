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


    public Calculator() {

        left = right = 0;

    }
    public void setOperator(String operator) {

        calculateResult();
        this.operator = operator;

    }

    public void put(int digit) {

        if (this.operator == null) {
            left = left * 10 + digit;
            setChanged();
            notifyObservers(left);
        } else {
            right = right * 10 + digit;
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
        setChanged();
        notifyObservers(left);
    }

    public void reset() {

        this.operator = null;
        left = right = 0;

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