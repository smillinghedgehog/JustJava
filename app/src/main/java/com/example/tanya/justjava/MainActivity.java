package com.example.tanya.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    int quantity = 0;
    int price = 150;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        display(quantity);
        displayPrice(quantity * price);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    /**
     * This method increments the number of coffees.
     */
    public void increment(View view){
        quantity ++;
        display(quantity);
        displayPrice(quantity * price);
    }

    /**
     * This method decrements the number of coffees.
     */
    public void decrement(View view){
        if (quantity > 0) {
            quantity--;
        }
        display(quantity);
        displayPrice(quantity * price);
    }

    public void check1(View view){
        CheckBox checkBox = findViewById(R.id.whipped_cream);
        if (checkBox.isChecked()){
            price += 30;
        }
        else{
            price -= 30;
        }
    }

    public void check2(View view){
        CheckBox checkBox = findViewById(R.id.raspberry_syrup);
        if (checkBox.isChecked()){
            price += 30;
        }
        else{
            price -= 30;
        }
    }

    public void check3(View view){
        CheckBox checkBox = findViewById(R.id.marshmello);
        if (checkBox.isChecked()){
            price += 30;
        }
        else{
            price -= 30;
        }
    }

    public void check4(View view){
        CheckBox checkBox = findViewById(R.id.maple_syrup);
        if (checkBox.isChecked()){
            price += 30;
        }
        else{
            price -= 30;
        }
    }

    public void send(View view){
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java");
        EditText editText = findViewById(R.id.name_view);
        String text = editText.getText().toString() + "!";
        text += "\nYour order is:";
        if (quantity > 1) {
            text += "\n" + quantity + " Coffees";
        }
        else{
            text += "\nCoffee";
        }
        if (price != 150){
            text += " with";
        }
        CheckBox checkBox = findViewById(R.id.whipped_cream);
        if (checkBox.isChecked()){
            text += " whipped cream";
        }
        checkBox = findViewById(R.id.raspberry_syrup);
        if (checkBox.isChecked()){
            text += ", raspberry syrup";
        }
        checkBox = findViewById(R.id.marshmello);
        if (checkBox.isChecked()){
            text += ", marshmello";
        }
        checkBox = findViewById(R.id.maple_syrup);
        if (checkBox.isChecked()){
            text += ", maple syrup";
        }
        text += "\nTotal: " + NumberFormat.getCurrencyInstance().format(price);
        text += "\nThank you!";
        intent.putExtra(Intent.EXTRA_TEXT, text);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
