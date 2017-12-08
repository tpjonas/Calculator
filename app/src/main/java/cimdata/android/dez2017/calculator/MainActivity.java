package cimdata.android.dez2017.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b0;
    Button b_divide, b_multiply, b_plus, b_minus;
    Button b_dot;
    Button b_equals;

    TextView output;

    String currentNumber;

    Calculator calculator;

    Boolean hasFinished = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        output = findViewById(R.id.output);
        currentNumber = "";

        b1 = findViewById(R.id.button_1);
        b2 = findViewById(R.id.button_2);
        b3 = findViewById(R.id.button_3);
        b4 = findViewById(R.id.button_4);
        b5 = findViewById(R.id.button_5);
        b6 = findViewById(R.id.button_6);
        b7 = findViewById(R.id.button_7);
        b8 = findViewById(R.id.button_8);
        b9 = findViewById(R.id.button_9);
        b0 = findViewById(R.id.button_0);
        b_divide = findViewById(R.id.button_divide);
        b_multiply = findViewById(R.id.button_multiply);
        b_plus = findViewById(R.id.button_plus);
        b_minus = findViewById(R.id.button_minus);
        b_dot = findViewById(R.id.button_dot);
        b_equals = findViewById(R.id.button_equals);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
        b0.setOnClickListener(this);
        b_divide.setOnClickListener(this);
        b_multiply.setOnClickListener(this);
        b_plus.setOnClickListener(this);
        b_minus.setOnClickListener(this);
        b_dot.setOnClickListener(this);
        b_equals.setOnClickListener(this);

        calculator = new Calculator();

    }

    @Override
    public void onClick(View view) {

        int id = view.getId();

        if (hasFinished) {
            currentNumber = "";
        }

        switch (id) {
            case R.id.button_1:
                currentNumber += "1";
                break;
            case R.id.button_2:
                currentNumber += "2";
                break;
            case R.id.button_3:
                currentNumber += "3";
                break;
            case R.id.button_4:
                currentNumber += "4";
                break;
            case R.id.button_5:
                currentNumber += "5";
                break;
            case R.id.button_6:
                currentNumber += "6";
                break;
            case R.id.button_7:
                currentNumber += "7";
                break;
            case R.id.button_8:
                currentNumber += "8";
                break;
            case R.id.button_9:
                currentNumber += "9";
                break;
            case R.id.button_0:
                currentNumber += "0";
                break;
            case R.id.button_multiply:
                calculator.parse(Double.valueOf(currentNumber), Calculator.MULTIPLY);
                currentNumber = String.valueOf(calculator.equals());
                hasFinished = true;
                break;
            case R.id.button_divide:
                calculator.parse(Double.valueOf(currentNumber), Calculator.DIVIDE);
                currentNumber = String.valueOf(calculator.equals());
                hasFinished = true;
                break;
            case R.id.button_plus:
                calculator.parse(Double.valueOf(currentNumber), Calculator.ADD);
                currentNumber = String.valueOf(calculator.equals());
                hasFinished = true;
                break;
            case R.id.button_minus:
                calculator.parse(Double.valueOf(currentNumber), Calculator.SUBSTRACT);
                currentNumber = String.valueOf(calculator.equals());
                hasFinished = true;
                break;
            case R.id.button_equals:
                calculator.parse(Double.valueOf(currentNumber), Calculator.ADD);
                currentNumber = String.valueOf(calculator.equals());
                hasFinished = true;
                break;

        }
        output.setText(currentNumber);


    }
}
