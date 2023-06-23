package com.example.coffeeshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import javax.sql.StatementEvent;

public class MainActivity extends AppCompatActivity {
    TextView txt, text2;
    Button plus;
    Button minus;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();
    int no_ofCoffee=0,pricepercup=100,totalprice=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = findViewById(R.id.display);
        plus = findViewById(R.id.btnPlus);
        minus = findViewById(R.id.btnMinus);
        text2 = findViewById(R.id.text2);
    }
    public void btnMinus(View view) {
        String no = txt.getText().toString();
        int num = Integer.parseInt(no);
        if (num > 0) {
            num--;
            txt.setText(String.valueOf(num));
            int total = num * 100;
            text2.setText("No of coffee:" + txt.getText() + "\nTotal: " + total);
        } else {
            text2.setText("No of coffee:" + num);
            Toast.makeText(this, "Ordered coffee can not be less than 1", Toast.LENGTH_SHORT).show();
        }
    }
    public void btnPlus(View view){
        String no=txt.getText().toString();
        int num=Integer.parseInt(no);
        num++;
        if(num>0){
            txt.setText(String.valueOf(num));
            int total=num*100;
            text2.setText("No of coffee:"+txt.getText()+"\nTotal:"+total);
        }
        else {
            text2.setText("Number of coffee:"+num+"\nTotal:0");
            Toast.makeText(this, "Ordered coffee can not be less than 1", Toast.LENGTH_SHORT).show();
        }
    }
    public void emailing(View view){
        String[] email={"rinkadickson82@gmail.com"};
        Intent intent=new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mailto:"));
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_EMAIL,email);
        intent.putExtra(Intent.EXTRA_SUBJECT,"Coffee Order");
        intent.putExtra(Intent.EXTRA_TEXT,totalprice);
        if(intent.resolveActivity(getPackageManager())!=null){
           // startActivity(intent);
        }
        myRef.setValue("Hello, World!");
    }

}
       /* if (no_ofCoffee > 0) {
            no_ofCoffee--;
            noOfCoffee.setText("" + no_ofCoffee);
        } else {
            no_ofCoffee = 0;
        }
        totalprice = no_ofCoffee * pricepercup;
        Toast.makeText(getApplicationContext(), "KSH=" + totalprice, Toast.LENGTH_SHORT).show();
    }
    public void btnPlus (View view){
        no_ofCoffee++;
        totalprice=no_ofCoffee*pricepercup;
        noOfCoffee.setText("" + no_ofCoffee);
 */
        //Toast.makeText(getApplicationContext(), "KSH=" + totalprice, Toast.LENGTH_SHORT).show();
