package com.example.doraemon;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Chouqian extends AppCompatActivity  {

    private Button bt1;
    private EditText et1;
    private EditText et2;
    private TextView tv;
    int data[] = new int[5]; /*开辟了一个长度为5的数组*/
    String result_list[] = new String[5];/*开辟了一个长度为5的数组*/
    private int i;
    private String sresult;
    private List<String> data_list = new ArrayList<String>();;//下拉列表展示的数据
    private Spinner spinner;//下拉列表
    private ArrayAdapter<String> arr_adapter;//spanner的适配器


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_chouqian);
        bt1 = (Button) findViewById(R.id.bt1);
        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        tv = (TextView) findViewById(R.id.tv);
        spinner = findViewById(R.id.spinner);

        //添加数据
        data_list.add("1");
        data_list.add("2");
        data_list.add("3");
        data_list.add("4");
        data_list.add("5");

        //适配器
        arr_adapter= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,
                data_list);
        //设置样式
        arr_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //加载适配器
        spinner.setAdapter(arr_adapter);

        //为spinner添加点击监控
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            //有选择值时，要进行的操作
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                //获取选中的数据
                String str = data_list.get(position);
                //将所获取的选中的数据转换成int型并赋值给i
                i = Integer.valueOf(str).intValue();
            }
            @Override
            //没有选择值时，要进行的操作
            public void onNothingSelected(AdapterView<?> parent) { }
        });

        //为按钮设置监听事件
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //i++;
                //将TextView获取到的值转换成int型
                int low = Integer.parseInt(et1.getText().toString()) ;
                int high = Integer.parseInt(et2.getText().toString()) + 1;
                if (low > high){
                    AlertDialog.Builder builder=new AlertDialog.Builder(Chouqian.this);
                    builder.setTitle("提示")
                            .setIcon(R.drawable.pointout)
                            .setMessage("上限值不能小于下限值，请重新输入")
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    AlertDialog  dialog=builder.create();
                    dialog.show();
                }
                else{
                String s = "抽到的是";
                Random ran = new Random();
                for (int n=0;n<5;n++){
                    data[n] = ran.nextInt(high - low)+ low ;
                }
                for(int t=0;t<5;t++){
                    result_list[t] = String.valueOf(data[t]);
                }
                switch (i){
                    case 1:sresult = s + result_list[0];break;
                    case 2:sresult = s + result_list[0] + "、" + result_list[1];break;
                    case 3:sresult = s + result_list[0] + "、" + result_list[1] + "、" + result_list[2];break;
                    case 4:sresult = s + result_list[0] + "、" + result_list[1] + "、" + result_list[2] + "、" + result_list[3];
                                      break;
                    case 5:sresult = s + result_list[0] + "、" + result_list[1] + "、" + result_list[2] + "、" + result_list[3]
                                      + "、" + result_list[4];break;
                    default:break;
                    }
                tv.setText(sresult);//在显示框中显示
               }
            }
        });
    }
}




