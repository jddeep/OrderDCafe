/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.android.justjava;



import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import java.text.NumberFormat;
import java.io.*;
/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity=0;
    int quantity1=0;
    int price=10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void increment(View view) {
        if (quantity < 15) {
            quantity = quantity + 1;
            display(quantity);
        }

    }
    public void decrement(View view)
    {

      if (quantity>0) {
          quantity = quantity - 1;


          display(quantity);
      }

    }
    public void increment1(View view) {

        if (quantity1 < 15) {
            quantity1 = quantity1 + 1;
            display1(quantity1);
        }
    }
    public void decrement1(View view)
    {

        if (quantity1>0) {
            quantity1 = quantity1 - 1;


            display1(quantity1);
        }

    }


    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        String sub = "My Order";
        CheckBox extras = (CheckBox) findViewById(R.id.checkBox);
        boolean shit = extras.isChecked();
        EditText nm = (EditText)findViewById(R.id.album_description_view);
        String naam = nm.getText().toString();
        CheckBox extras2 = (CheckBox) findViewById(R.id.checkBox2);
        boolean shit2 = extras2.isChecked();
        String pricemsg=createOrder(price,shit,naam,shit2);
        composeEmail(pricemsg,sub);
    }
    public String createOrder(int p,boolean s,String n,boolean s2)
    {String hin="",hin2="";
    int x1 = 1,x2 = 2;
    int p1=p;
        if(s==true) {
            hin = "Yes";
            p = p + x2;
        }
        else
            hin="No thanks";
        if(s2==true) {
            hin2 = "Yes";
            p1 = p1 + x1;
        }
        else
            hin2="No thanks";

        String pmsg=getString(R.string.editable_name,n)+"\nTotal "+getString(R.string.quantity)+ (quantity+quantity1)+ "\n"+getString(R.string.extra1)+"? "+hin+"\n"+getString(R.string.extra2)+"? "+hin2+"\nPrice: $"+((quantity*p)+(quantity1*p1))+"\nThank You!!!";
        return pmsg;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    private void display1(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity1_text_view);
        quantityTextView.setText("" + number);
    }

    public void composeEmail(String txt,String subject) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT,txt);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /**
     * This method displays the given text on the screen.
     */
//    private void displayMessage(String message) {
//        TextView priceTextView = (TextView) findViewById(R.id.ordersumm_text);
//        priceTextView.setText(message);
//    }
}