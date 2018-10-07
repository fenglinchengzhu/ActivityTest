package com.example.kinglu.activitytest;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        Button button = (Button)findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  Toast.makeText(FirstActivity.this, "hello", Toast.LENGTH_SHORT).show();
                String data = "Hello Secondary";
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                startActivityForResult(intent, 1);
             //   intent.putExtra("extra_data", data);
//                Intent intent = new Intent("com.example.kinglu.activitytest.ACTION_START");
//                intent.addCategory("com.example.kinglu.activitytest.MY_CATEGORY");
//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse("https://www.baidu.com"));
               // startActivity(intent);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.remove:
                Toast.makeText(FirstActivity.this, "remove", Toast.LENGTH_SHORT).show();
                break;
            case R.id.add:
                Toast.makeText(FirstActivity.this, "add", Toast.LENGTH_SHORT).show();
                break;
                default:
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK){
                    String returnData = data.getStringExtra("data_return");
                    Log.d("FirstActivity",returnData);

                }else {
                   Toast.makeText(FirstActivity.this,"数据返回失败",Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }
    }
}

