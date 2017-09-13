package helloworld.se.cs.bistu.edu.cn.activitysend;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.style.BulletSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    TextView xianTv;
    EditText sendEt;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button =(Button)findViewById(R.id.button);
        sendEt=(EditText) findViewById(R.id.send_et);
        String str=sendEt.getText().toString();
        button.setOnClickListener(new View.OnClickListener() {

            //给按钮注册点击事件，打开新的Acticity
            @Override
            public void onClick(View v) {
                sendEt=(EditText) findViewById(R.id.send_et);
                String str=sendEt.getText().toString();
                Intent intent =new Intent(MainActivity.this,AnotherActivity.class);

                intent.putExtra("name", str);


                startActivityForResult(intent, 100);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        Toast.makeText(this, data.getStringExtra("result"), Toast.LENGTH_LONG).show();
        xianTv=(TextView)findViewById(R.id.xian_tv);
        xianTv.setText(data.getStringExtra("result"));//得到返回结果
        super.onActivityResult(requestCode, resultCode, data);
    }
}

