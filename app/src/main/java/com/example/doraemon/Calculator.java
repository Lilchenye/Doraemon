package com.example.doraemon;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class Calculator extends Activity implements OnClickListener {

    //声明控件
    Button btn0;//0键
    Button btn1;//1键
    Button btn2;//2键
    Button btn3;//3键
    Button btn4;//4键
    Button btn5;//5键
    Button btn6;//6键
    Button btn7;//7键
    Button btn8;//8键
    Button btn9;//9键

    Button btnC;//清除键
    Button btnAdd;//+键
    Button btnSub;//-键
    Button btnMul;//*键
    Button btnDiv;//除键
    Button btnEqu;//等于键
    Button btnDot;//点键
    EditText tvResult;

    //声明两个参数。接收tvResult前后的值
    double num1 = 0, num2 = 0;
    double Result = 0;//计算结果
    int op = 0;//判断操作数，
    String opd = " ";//显示操作符
    boolean isClickEqu = false;//判断是否按了“=”按钮

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        //从布局文件中获取控件，
        btn0 = (Button) findViewById(R.id.btn0);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);

        btnC = (Button) findViewById(R.id.btnC);
        btnEqu = (Button) findViewById(R.id.btnEqu);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnSub = (Button) findViewById(R.id.btnSub);
        btnMul = (Button) findViewById(R.id.btnMul);
        btnDiv = (Button) findViewById(R.id.btnDiv);
        btnDot = (Button) findViewById(R.id.btnDot);

        tvResult = (EditText) findViewById(R.id.tvResult);

        //添加监听
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);

        btnDot.setOnClickListener(this);
        btnC.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMul.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnEqu.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {                //switch循环获取点击按钮后的值

            case R.id.btn0:                //获取，0-9、小数点，并在编辑框显示
                String myString = tvResult.getText().toString();
                myString += "0";
                tvResult.setText(myString);
                break;
            case R.id.btn1:
                String myString1 = tvResult.getText().toString();
                myString1 += "1";
                tvResult.setText(myString1);
                break;
            case R.id.btn2:
                String myString2 = tvResult.getText().toString();
                myString2 += "2";
                tvResult.setText(myString2);
                break;
            case R.id.btn3:
                String myString3 = tvResult.getText().toString();
                myString3 += "3";
                tvResult.setText(myString3);
                break;
            case R.id.btn4:
                String myString4 = tvResult.getText().toString();
                myString4 += "4";
                tvResult.setText(myString4);
                break;
            case R.id.btn5:
                String myString5 = tvResult.getText().toString();
                myString5 += "5";
                tvResult.setText(myString5);
                break;
            case R.id.btn6:
                String myString6 = tvResult.getText().toString();
                myString6 += "6";
                tvResult.setText(myString6);
                break;
            case R.id.btn7:
                String myString7 = tvResult.getText().toString();
                myString7 += "7";
                tvResult.setText(myString7);
                break;
            case R.id.btn8:
                String myString8 = tvResult.getText().toString();
                myString8 += "8";
                tvResult.setText(myString8);
                break;
            case R.id.btn9:
                String myString9 = tvResult.getText().toString();
                myString9 += "9";
                tvResult.setText(myString9);
                break;
            case R.id.btnAdd:             //判断，使用加减乘除的操作符
                String myStringAdd = tvResult.getText().toString();
                if (myStringAdd.equals(null)) {
                    return;
                }
                num1 = Double.valueOf(myStringAdd);
                tvResult.setText(null);
                op = 1;
                opd = "+";
                break;
            case R.id.btnSub:
                String myStringSub = tvResult.getText().toString();
                if (myStringSub.equals(null)) {
                    return;
                }
                num1 = Double.valueOf(myStringSub);
                tvResult.setText(null);
                op = 2;
                opd = "-";
                break;
            case R.id.btnMul:
                String myStringMul = tvResult.getText().toString();
                if (myStringMul.equals(null)) {
                    return;
                }
                num1 = Double.valueOf(myStringMul);
                tvResult.setText(null);
                op = 3;
                opd = "×";
                break;
            case R.id.btnDiv:
                String myStringDiv = tvResult.getText().toString();
                if (myStringDiv.equals(null)) {
                    return;
                }
                num1 = Double.valueOf(myStringDiv);
                tvResult.setText(null);
                op = 4;
                opd = "÷";
                break;
            case R.id.btnC:                 //清除，将编辑框文本显示为空
                tvResult.setText("");
                Result = 0;
                break;
            case R.id.btnDot:                 //加入小数点·
                String myStringDot = tvResult.getText().toString();
                myStringDot += ".";
                tvResult.setText(myStringDot);
                break;
            case R.id.btnEqu:                   //计算，以操作符为判断，选择所需的运算，并将结果输出
                String myStringEqu = tvResult.getText().toString();
                if (myStringEqu.equals(null)) {
                    return;
                }
                num2 = Double.valueOf(myStringEqu);
                tvResult.setText(null);
                switch (op) {
                    case 0:
                        Result = num2;
                        break;
                    case 1:
                        Result = num1 + num2;
                        break;
                    case 2:
                        Result = num1 - num2;
                        break;
                    case 3:
                        Result = num1 * num2;
                        break;
                    case 4:
                        if (num2 == 0)                //除法中分子与分母之分
                            Result = 0;
                        else
                            Result = num1 / num2;
                        break;
                    default:
                        Result = 0;
                        break;
                }
                tvResult.setText(Double.toString(Result));
                //tvResult.setText(Double.toString(num1) + opd + Double.toString(num2) + "=" + Double.toString(Result));    //将结果完整输出
                op = 0;
                break;
            default:
                break;
        }
    }
}
