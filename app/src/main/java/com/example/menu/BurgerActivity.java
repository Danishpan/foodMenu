package com.example.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class BurgerActivity extends AppCompatActivity {
    int totalPrice = 0;

    TextView textView;
    ListView listView1;

//    Item burgers[] = {new Item("Big Mac", "Big Mac Bun, 100% Beef Patty, Shredded Lettuce, Big Mac Sauce, Pasteurized Process American Cheese, Pickle Slices Onions", 900),
//                      new Item("McChicken", "Regular Bun, McChicken Patty, Shredded Lettuce, Mayonnaise", 850),
//                      new Item("Filet-O-Fish", "Regular Bun, Fish Filet Patty, Pasteurized Process American Cheese, Tartar Sauce", 900)};
//    Item desserts[] = {new Item("Vanilla Cone", "Crispy Cone, Creamy Vanilla Soft Serve", 400),
//                       new Item("McFlurry with M&M'S® Candies", "M&M’S® Chocolate candies, Vanilla Soft Serve", 600),
//                       new Item("Baked Apple Pie", "100% American-grown Apples, Lattice Crust, Sprinkled Sugar", 350)};
//    Item drinks[] = {new Item("Chocolate Shake", "Soft Serve, Chocolate Syrup, Creamy Whipped Topping", 500),
//                     new Item("Strawberry Shake", "Soft Serve, Strawberry Syrup, Creamy Whipped Topping", 500) };

    String burgerNames[] = {"Big Mac", "McChicken", "Filet-O-Fish"};
    String burgerDetails[] = {"Big Mac Bun, 100% Beef Patty, Shredded Lettuce, Big Mac Sauce, Pasteurized Process American Cheese, Pickle Slices Onions", "Regular Bun, McChicken Patty, Shredded Lettuce, Mayonnaise", "Filet-O-Fish\", \"Regular Bun, Fish Filet Patty, Pasteurized Process American Cheese, Tartar Sauce"};
    Double burgerPrices[] = {900.0, 850.0, 900.0};


    int images[] = {R.drawable.bigmac, R.drawable.mcchicken, R.drawable.fileofish};
    // so our images and other things are set in array

    // now paste some images in drawable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
            // aslo set in menifest
        }

        textView = findViewById(R.id.textViewPrice);
        textView.setText("In total for burgers: " + totalPrice + "₸");

        listView1 = findViewById(R.id.listView1);
        // now create an adapter class

        MyAdapter adapter1 = new MyAdapter(this, burgerNames, burgerDetails, burgerPrices);
        listView1.setAdapter(adapter1);
        // there is my mistake...
        // now again check this..

        // now set item click on list view
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position ==  0) {
                    Toast.makeText(BurgerActivity.this, "Price: 900₸", Toast.LENGTH_SHORT).show();
                    MainActivity.totalPrice+=900;
                    totalPrice+=900;
                    textView.setText("In total for burgers: " + totalPrice + "₸");
                }
                if (position ==  1) {
                    Toast.makeText(BurgerActivity.this, "Price: 850₸", Toast.LENGTH_SHORT).show();
                    MainActivity.totalPrice+=850;
                    totalPrice+=850;
                    textView.setText("In total for burgers: " + totalPrice + "₸");
                }
                if (position ==  2) {
                    Toast.makeText(BurgerActivity.this, "Price: 900₸", Toast.LENGTH_SHORT).show();
                    MainActivity.totalPrice+=900;
                    totalPrice+=900;
                    textView.setText("In total for burgers: " + totalPrice + "₸");
                }
            }
        });


        // so item click is done now check list view
    }

    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String itemNames[];
        String itemDetails[];
        Double itemPrices[];

        MyAdapter (Context c, String itemNames[], String itemDetails[], Double itemPrices[]) {
            super(c, R.layout.row, R.id.textView1, itemNames);
            this.context = c;
            this.itemNames = itemNames;
            this.itemDetails = itemDetails;
            this.itemPrices = itemPrices;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            TextView myTitle = row.findViewById(R.id.textView1);
            TextView myDescription = row.findViewById(R.id.textView2);
            ImageView myImage = row.findViewById(R.id.image);
            myImage.setImageResource(images[position]);

            // now set our resources on views
            myTitle.setText(itemNames[position]);
            myDescription.setText(itemDetails[position]);

            return row;
        }
    }
}