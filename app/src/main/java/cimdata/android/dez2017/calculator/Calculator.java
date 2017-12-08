package cimdata.android.dez2017.calculator;

import android.util.Log;

import java.lang.reflect.Array;

/**
 * Created by Student on 06.12.2017.
 */

public class Calculator {

    public double result;

    public static String MULTIPLY = "multiply";
    public static String ADD = "add";
    public static String SUBSTRACT = "substract";
    public static String DIVIDE = "divide";

    public String operator;

    public Calculator() {

        this.operator = ADD;
        result = 0;

    }
    public void parse(double num, String operator) {

        if (this.operator == MULTIPLY) {
            result = result * num;
        } else if (this.operator == DIVIDE) {
            result = result / num;
        } else if (this.operator == ADD) {
            result = result + num;
        } else if (this.operator == SUBSTRACT) {
            result = result - num;
        }
        this.operator = operator;

        Log.d("CALC", String.valueOf(result));

    }

    public double equals() {
        // reset
        this.operator = ADD;
        Double tmp_result = result;
        result = 0;

        return tmp_result;
    }

}

/**

 ScriptEngine se = new ScriptEngineManager().getEngineByName("nashorn");
 dann:
 String result = String.valueOf(se.eval(expression));


 **/