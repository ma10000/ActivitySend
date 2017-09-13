package helloworld.se.cs.bistu.edu.cn.activitysend;



        import android.app.Activity;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;

public class AnotherActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.another_activity);//设置该Activity所对应的xml布局文件
        Intent intent =this.getIntent();//得到激活她的意图
        String name =intent.getStringExtra("name");
        int age=intent.getExtras().getInt("age");//第二种取值方式
        TextView textView = (TextView)this.findViewById(R.id.result);
        textView.setText("姓名："+ name);
        Button button = (Button)this.findViewById(R.id.close);
        button.setOnClickListener(new View.OnClickListener() {

            //返回结果给前面的Activity
            @Override
            public void onClick(View v) {
                Intent intent =new Intent();
                intent.putExtra("result", "这是处理结果");
                setResult(20, intent);//设置返回数据
                finish();//关闭activity
            }
        });
    }

}


