package com.example.doraemon;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Score extends AppCompatActivity implements View.OnClickListener {
    //定义数组存放加分
    private  final  int scoreArray[]={1,2,3};
    private  int lastScore_a,lastScore_b,score_a,score_b;
    private Button btna_1,btna_2,btna_3,btnb_1,btnb_2,btnb_3;
    private ImageView img_cancel,img_rest;
    private TextView test_score_a,test_score_b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        inintView();
    }

    private void inintView() {
        //获取按钮id
        btna_1=findViewById(R.id.btna_1);
        btna_2=findViewById(R.id.btna_2);
        btna_3=findViewById(R.id.btna_3);
        btnb_1=findViewById(R.id.btnb_1);
        btnb_2=findViewById(R.id.btnb_2);
        btnb_3=findViewById(R.id.btnb_3);


        //得分情况和清零
        img_cancel=findViewById(R.id.img_cancel);
        img_rest=findViewById(R.id.img_reset);
        test_score_a=findViewById(R.id.score_a);
        test_score_b=findViewById(R.id.score_b);

        //按钮实现监听
        btna_1.setOnClickListener(this);
        btna_2.setOnClickListener(this);
        btna_3.setOnClickListener(this);
        btnb_1.setOnClickListener(this);
        btnb_2.setOnClickListener(this);
        btnb_3.setOnClickListener(this);
        img_rest.setOnClickListener(this);
        img_cancel.setOnClickListener(this);
    }

    //点击事件
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btna_1:
                scoreAdd(0,scoreArray[0]);

                break;
            case R.id.btna_2:
                scoreAdd(0,scoreArray[1]);

                break;
            case R.id.btna_3:
                scoreAdd(0,scoreArray[2]);

                break;
            case  R.id.btnb_1:
                scoreAdd(1,scoreArray[0]);

                break;
            case  R.id.btnb_2:
                scoreAdd(1,scoreArray[1]);

                break;
            case  R.id.btnb_3:
                scoreAdd(1,scoreArray[2]);

                break;
            case  R.id.img_reset:
                reset();
                break;
            case  R.id.img_cancel:
                cancel();
                break;
            default:
                break;
        }
    }

    //取消上次加分操作
    private void cancel() {
        if (score_a != 0 && score_a-lastScore_a >= 0){
            score_a -= lastScore_a;
        }
        if (score_b != 0 && score_b-lastScore_b >= 0){
            score_b -= lastScore_b;
        }
        ShowText();
    }

    //重置功能,弹出提示框
    private void reset() {
        //弹出提示框，提示用户你是否要重置
        AlertDialog.Builder builder=new AlertDialog.Builder(Score.this);
        builder.setTitle("提示")
                .setIcon(R.drawable.pointout)
                .setMessage("你确定要重置分数吗?")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        score_a = 0;
                        score_b = 0;
                        ShowText();
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        AlertDialog  dialog=builder.create();
        dialog.show();
    }

    //退出软件，弹出提示框
    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder=new AlertDialog.Builder(Score.this);
        builder.setTitle("提示")
                .setIcon(R.drawable.warn)
                .setMessage("你确定要退出?")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Score.this.finish();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        AlertDialog  dialog=builder.create();
        dialog.show();
    }

    //进行加分
    private void  scoreAdd(int Tage,int score){
        //Tage为标志位:   0:A队  1:B队
        if (Tage==0||Tage==1)//当Tage为0或1时进行加分操作
        {
            if (Tage == 0){
                //表示A队进行加分
                lastScore_b=0;//B队新增分数为0
                lastScore_a=score; //A队新增分数为score（即点击的按钮值）
                score_a+=lastScore_a;//总分为原有分数+新增分数
            }else if (Tage == 1){
                //表示对B队进行加分
                lastScore_a=0;//A队新增分数为0
                lastScore_b=score;//B队新增分数为score（即点击的按钮值）
                score_b+=lastScore_b;
            }
            ShowText();
        }
    }
    //进行显示
    private  void ShowText(){
        test_score_a.setText(Integer.toString(score_a));
        test_score_b.setText(Integer.toString(score_b));
    }
}

