package cimdata.android.dez2017.calculator;

import android.util.Log;
import java.lang.reflect.Array;
import java.util.Observable;


public class Calculator extends Observable{

    private double right;
    private double left;

    public enum OperatorType {
        MULTIPLY, ADD, SUBSTRACT, DIVIDE
    }


    private OperatorType operator;

    private boolean dotIsSet = false;

    private int multiplierBeforeDecimalPoint;
    private double multiplierAfterDigitalPoint;



    public Calculator() {

        left = right = 0;
        multiplierBeforeDecimalPoint = 10;
        multiplierAfterDigitalPoint = 1.0;

    }
    public void setOperator(OperatorType operator) {

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

        switch (this.operator) {
            case MULTIPLY:
                left = left * right;
                break;
            case DIVIDE:
                left = left / right;
                break;
            case ADD:
                left = left + right;
                break;
            case SUBSTRACT:
                left = left - right;
                break;
        }

        right = 0;

        resetMultipliers();

        setChanged();
        notifyObservers(left);
    }

    private void resetMultipliers() {

        dotIsSet = false;
        multiplierBeforeDecimalPoint = 10;
        multiplierAfterDigitalPoint = 1;

    }

    public void reset() {

        this.operator = null;
        left = right = 0;

        resetMultipliers();

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