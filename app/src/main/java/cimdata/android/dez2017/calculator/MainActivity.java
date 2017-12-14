package cimdata.android.dez2017.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Observable;
import java.util.Observer;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Observer {

    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b0;
    Button b_divide, b_multiply, b_plus, b_minus;
    Button b_ce;
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
        b_ce = findViewById(R.id.button_CE);
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
        b_ce.setOnClickListener(this);
        b_equals.setOnClickListener(this);

        calculator = new Calculator();

        calculator.addObserver(this);

    }

    @Override
    public void onClick(View view) {

        int id = view.getId();

        switch (id) {
            case R.id.button_0:
                calculator.put(0);
                break;
            case R.id.button_1:
                calculator.put(1);
                break;
            case R.id.button_2:
                calculator.put(2);
                break;
            case R.id.button_3:
                calculator.put(3);
                break;
            case R.id.button_4:
                calculator.put(4);
                break;
            case R.id.button_5:
                calculator.put(5);
                break;
            case R.id.button_6:
                calculator.put(6);
                break;
            case R.id.button_7:
                calculator.put(7);
                break;
            case R.id.button_8:
                calculator.put(8);
                break;
            case R.id.button_9:
                calculator.put(9);
                break;
            case R.id.button_CE:
                calculator.reset();
                break;
            case R.id.button_multiply:
                calculator.setOperator(Calculator.MULTIPLY);
                break;
            case R.id.button_divide:
                calculator.setOperator(Calculator.DIVIDE);
                break;
            case R.id.button_plus:
                calculator.setOperator(Calculator.ADD);
                break;
            case R.id.button_minus:
                calculator.setOperator(Calculator.SUBSTRACT);
                break;
            case R.id.button_equals:
                calculator.equals();
                break;

        }

    }

    @Override
    public void update(Observable o, Object currentNumber) {
        output.setText(String.valueOf(currentNumber));
        //int foo = 1;
    }
}
