package com.wen.calculate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.DecimalFormat;

import static android.content.ContentValues.TAG;

public class CalcuActivity extends AppCompatActivity implements View.OnClickListener {

    private String username;
    private TextView nameText;
    private ImageButton imBt0, imBt1, imBt2, imBt3, imBt4, imBt5, imBt6, imBt7, imBt8, imBt9;
    private ImageButton imBtDot, imBtEqual, imBtPlus, imBtMinus, imBtMulti, imBtDivi, imBtX, imBtSign, imBtAC;
    private TextView resultText;

    private boolean lastIsOperator;
    private String lastOperator, last2Operator = "";
    private double stTextNum, ndTextNum = 0D;
    private DecimalFormat format;
    private String nowOperator;
    private boolean ndNumIsZero = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcu);

        username = getIntent().getStringExtra("USERNAME");
        Log.d(TAG, username + "");
        nameText = findViewById(R.id.nameText);
        nameText.setText("使用者名稱：" + username);
        resultText = findViewById(R.id.resultText);

        setButton();
        resultText.setText("0");

        format = new DecimalFormat("#.##");
    }

    private void setButton() {
        imBt0 = findViewById(R.id.imBt0);
        imBt0.setOnClickListener(this);

        imBt1 = findViewById(R.id.imBt1);
        imBt1.setOnClickListener(this);

        imBt2 = findViewById(R.id.imBt2);
        imBt2.setOnClickListener(this);

        imBt3 = findViewById(R.id.imBt3);
        imBt3.setOnClickListener(this);

        imBt4 = findViewById(R.id.imBt4);
        imBt4.setOnClickListener(this);

        imBt5 = findViewById(R.id.imBt5);
        imBt5.setOnClickListener(this);

        imBt6 = findViewById(R.id.imBt6);
        imBt6.setOnClickListener(this);

        imBt7 = findViewById(R.id.imBt7);
        imBt7.setOnClickListener(this);

        imBt8 = findViewById(R.id.imBt8);
        imBt8.setOnClickListener(this);

        imBt9 = findViewById(R.id.imBt9);
        imBt9.setOnClickListener(this);

        imBtDot = findViewById(R.id.imBtDot);
        imBtDot.setOnClickListener(this);

        imBtEqual = findViewById(R.id.imBtEqual);
        imBtEqual.setOnClickListener(this);

        imBtPlus = findViewById(R.id.imBtPlus);
        imBtPlus.setOnClickListener(this);

        imBtMinus = findViewById(R.id.imBtMinus);
        imBtMinus.setOnClickListener(this);

        imBtMulti = findViewById(R.id.imBtMulti);
        imBtMulti.setOnClickListener(this);

        imBtDivi = findViewById(R.id.imBtDivi);
        imBtDivi.setOnClickListener(this);

        imBtX = findViewById(R.id.imBtX);
        imBtX.setOnClickListener(this);

        imBtSign = findViewById(R.id.imBtSign);
        imBtSign.setOnClickListener(this);

        imBtAC = findViewById(R.id.imBtAC);
        imBtAC.setOnClickListener(this);
    }

    private void cleanText() {
        if (lastIsOperator) {
            resultText.setText("");
        }

    }

    public void onClick(View view) {

        if (resultText.getText().equals("0")) {
            resultText.setText("");
        }

        switch (view.getId()) {
            //Operand
            case R.id.imBt0:
                cleanText();
                resultText.setText(resultText.getText() + "0");
                lastIsOperator = false;
                break;
            case R.id.imBt1:
                cleanText();
                resultText.setText(resultText.getText() + "1");
                lastIsOperator = false;
                break;
            case R.id.imBt2:
                cleanText();
                resultText.setText(resultText.getText() + "2");
                lastIsOperator = false;
                break;
            case R.id.imBt3:
                cleanText();
                resultText.setText(resultText.getText() + "3");
                lastIsOperator = false;
                break;
            case R.id.imBt4:
                cleanText();
                resultText.setText(resultText.getText() + "4");
                lastIsOperator = false;
                break;
            case R.id.imBt5:
                cleanText();
                resultText.setText(resultText.getText() + "5");
                lastIsOperator = false;
                break;
            case R.id.imBt6:
                cleanText();
                resultText.setText(resultText.getText() + "6");
                lastIsOperator = false;
                break;
            case R.id.imBt7:
                cleanText();
                resultText.setText(resultText.getText() + "7");
                lastIsOperator = false;
                break;
            case R.id.imBt8:
                cleanText();
                resultText.setText(resultText.getText() + "8");
                lastIsOperator = false;
                break;
            case R.id.imBt9:
                cleanText();
                resultText.setText(resultText.getText() + "9");
                lastIsOperator = false;
                break;
            case R.id.imBtDot:
                if (!resultText.getText().toString().contains(".")) {
                    if (TextUtils.isEmpty(resultText.getText())) {
                        resultText.setText("0");
                    }
                    resultText.setText(resultText.getText() + ".");
                    lastIsOperator = false;
                }
                break;
            //clear
            case R.id.imBtAC:
                stTextNum = 0D;
                ndTextNum = 0D;
                resultText.setText("0");
                lastIsOperator = false;
                lastOperator = "";
                last2Operator = "";
                break;
            //sign
            case R.id.imBtSign:
                if (resultText.getText().toString().contains("-")) {
                    String nosign = resultText.getText().toString().replace("-", "");
                    resultText.setText(nosign);
                } else if (!resultText.getText().toString().contains("-") && !TextUtils.isEmpty(resultText.getText())) {
                    resultText.setText("-" + resultText.getText());
                } else if (TextUtils.isEmpty(resultText.getText())) {
                    resultText.setText("0");
                }
                lastIsOperator = false;
                break;
            //階乘
            case R.id.imBtX:
                if (!resultText.getText().toString().contains(".")) {
                    if (TextUtils.isEmpty(resultText.getText())) {
                        resultText.setText("1");
                    } else {
                        int n = Integer.parseInt(resultText.getText().toString());
                        int ans = 1;
                        for (int i = 1; i <= n; i++) {
                            ans *= i;
                        }
                        resultText.setText(String.valueOf(ans));
                    }
                    lastIsOperator = false;
                }
                break;
            //Operator
            case R.id.imBtPlus:
                if (lastIsOperator && !lastOperator.equals("=")) {
                    if (!lastOperator.equals("+")) {
                        lastOperator = "+";
                    }
                    return;
                }
                nowOperator = "+";
                operatorCalcu();
                lastIsOperator = true;
                lastOperator = "+";
                break;

            case R.id.imBtMinus:
                if (lastIsOperator && lastOperator.equals("=")) {
                    if (!lastOperator.equals("-")) {
                        lastOperator = "-";
                    }
                    return;
                }
                nowOperator = "-";
                operatorCalcu();
                lastIsOperator = true;
                lastOperator = "-";
                break;

            case R.id.imBtMulti:
                if (lastIsOperator && lastOperator.equals("=")) {
                    if (!lastOperator.equals("*")) {
                        lastOperator = "*";
                    }
                    return;
                }
                nowOperator = "*";
                operatorCalcu();
                lastIsOperator = true;
                lastOperator = "*";
                break;

            case R.id.imBtDivi:
                if (lastIsOperator && lastOperator.equals("=")) {
                    if (!lastOperator.equals("/")) {
                        lastOperator = "/";
                    }
                    return;
                }
                nowOperator = "/";
                operatorCalcu();
                lastIsOperator = true;
                lastOperator = "/";
                break;

            case R.id.imBtEqual:
                nowOperator = "=";
                operatorCalcu();
                lastOperator = "=";
                lastIsOperator = true;
                break;
        }
    }

    public void operatorCalcu() {
        if (TextUtils.isEmpty(last2Operator)) {
            if (TextUtils.isEmpty(lastOperator)) {
                if (TextUtils.isEmpty(resultText.getText())) {
                    resultText.setText("0");
                }
                stTextNum = Double.parseDouble(resultText.getText().toString());
            } else {
                if (TextUtils.isEmpty(resultText.getText())) {
                    resultText.setText("0");
                }
                if (lastOperator.equals("+")) {
                    if (nowOperator.equals("*") || nowOperator.equals("/")) {
                        Log.d(TAG, "go pri");
                        operatorPriority();
                    } else {
                        stTextNum += Double.parseDouble(resultText.getText().toString());
                        resultText.setText(format.format(stTextNum));
                    }
                } else if (lastOperator.equals("-")) {
                    if (nowOperator.equals("*") || nowOperator.equals("/")) {
                        Log.d(TAG, "go pri");
                        operatorPriority();
                    } else {
                        stTextNum -= Double.parseDouble(resultText.getText().toString());
                        resultText.setText(format.format(stTextNum));
                    }
                } else if (lastOperator.equals("*")) {
                    stTextNum *= Double.parseDouble(resultText.getText().toString());
                    resultText.setText(format.format(stTextNum));
                } else if (lastOperator.equals("/")) {
                    stTextNum /= Double.parseDouble(resultText.getText().toString());
                    resultText.setText(format.format(stTextNum));
                } else if (lastOperator.equals("=")) {
                    stTextNum = Double.parseDouble(resultText.getText().toString());
                }
            }
        } else {
            ndNumIsZero = true;
            operatorPriority();
        }
    }

    public void operatorPriority() {
        if (ndTextNum == 0D && ndNumIsZero == false) {
            ndTextNum = Double.parseDouble(resultText.getText().toString());
            switch (lastOperator) {
                case "+":
                    last2Operator = "+";
                    Log.d(TAG, last2Operator + "here");
                    break;
                case "-":
                    last2Operator = "-";
                    Log.d(TAG, last2Operator + "here");
                    break;
            }
        } else {
            if (TextUtils.isEmpty(resultText.getText())) {
                resultText.setText("0");
            }
            Log.d(TAG, last2Operator + "last2Operator");
            if (nowOperator.equals("+") || nowOperator.equals("-") || nowOperator.equals("=")) {
                if (last2Operator.equals("+")) {
                    switch (lastOperator) {
                        case "*":
                            stTextNum += ndTextNum * Double.parseDouble(resultText.getText().toString());
                            resultText.setText(format.format(stTextNum));
                            break;
                        case "/":
                            stTextNum += ndTextNum / Double.parseDouble(resultText.getText().toString());
                            resultText.setText(format.format(stTextNum));
                            break;
                    }
                } else if (last2Operator.equals("-")) {
                    switch (lastOperator) {
                        case "*":
                            stTextNum -= ndTextNum * Double.parseDouble(resultText.getText().toString());
                            resultText.setText(format.format(stTextNum));
                            break;
                        case "/":
                            stTextNum -= ndTextNum / Double.parseDouble(resultText.getText().toString());
                            resultText.setText(format.format(stTextNum));
                            break;
                    }
                }
                Log.d(TAG, stTextNum + "success");
                last2Operator = "";
                ndTextNum = 0D;
                ndNumIsZero = false;
            } else if (nowOperator.equals("*") || nowOperator.equals("/")) {
                switch (lastOperator) {
                    case "*":
                        ndTextNum *= Double.parseDouble(resultText.getText().toString());
                        resultText.setText(format.format(ndTextNum));
                        break;
                    case "/":
                        ndTextNum /= Double.parseDouble(resultText.getText().toString());
                        resultText.setText(format.format(ndTextNum));
                        break;
                }
            }
        }
    }
}


