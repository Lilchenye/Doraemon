package com.example.doraemon;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;


public class BMI extends MainActivity implements View.OnClickListener{
    RadioButton rb1;
    RadioButton rb2;
    TextView tvResult;
    EditText txt1;
    EditText txt2;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        setViews();
    }
    public void setViews() {
        rb1 = (RadioButton) findViewById(R.id.rb1);
        rb2 = (RadioButton) findViewById(R.id.rb2);//判断男女
        tvResult = (TextView) findViewById(R.id.tvResult);
        txt1 = (EditText)findViewById(R.id.edX);
        txt2 = (EditText)findViewById(R.id.edY);

        btn = (Button)findViewById(R.id.btn);
        btn.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        double x = Double.parseDouble(txt1.getText().toString());//身高
        double y = Double.parseDouble(txt2.getText().toString());//体重//体重除以身高的平方
        double res;
        String str = "Your BMI is：";
        if(x<=0 || y<=0) {
            tvResult.setText("值异常，不计算");
            return ;
        }
        x = x/100;
        res = y / (x*x);
        String str1 = String.format("%.2f",res);
        str = str + str1;
        if(rb1.isChecked())
            res -= 1;//以女性为标准进行比较
        //仅以女性作为评价标准
        str +=   "\n体型:";
        if(res <= 19) {
            str += "\t\t过轻";
            str += "\n建议：要多吃一点哦";
        }
        else if(res >19 && res <= 24){
            str += "\t\t适中";
            str += "\n建议：很健康，继续保持~";
        }
        else if(res > 24 && res <= 29){
            str += "\t\t超重";
            str += "\n建议：有点超重了，要控制饮食哦~";
        }
        else if(res > 29 && res <= 34){
            str += "\t\t肥胖";
            str += "\n建议：体重超标了，要控制饮食，加强锻炼~";
        }
        else{
            str += "\t\t严重肥胖";
            str += "\n建议：现在的状态非常不健康，请咨询专业人士，合理调整~";
        }
        tvResult.setText(str);
    }
}


