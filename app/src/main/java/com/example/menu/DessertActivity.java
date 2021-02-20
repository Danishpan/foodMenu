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

public class DessertActivity extends AppCompatActivity {
    int totalPrice = 0;

    TextView textView;
    ListView listView1;

    String dessertNames[] = {"Vanilla Cone", "McFlurry with M&M'S® Candies", "Baked Apple Pie"};
    String dessertDetails[] = {"Crispy Cone, Creamy Vanilla Soft Serve", "M&M’S® Chocolate candies, Vanilla Soft Serve", "100% American-grown Apples, Lattice Crust, Sprinkled Sugar"};
    Double dessertPrices[] = {400.0, 600.0, 350.0};

    int images[] = {R.drawable.cone, R.drawable.mcflurry, R.drawable.pie};
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
        textView.setText("In total for desserts: " + totalPrice + "₸");

        listView1 = findViewById(R.id.listView1);
        // now create an adapter class

        MyAdapter adapter1 = new MyAdapter(this, dessertNames, dessertDetails, dessertPrices);
        listView1.setAdapter(adapter1);
        // there is my mistake...
        // now again check this..

        // now set item click on list view
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Toast.makeText(DessertActivity.this, "Price: 400₸", Toast.LENGTH_SHORT).show();
                    MainActivity.totalPrice+=400;
                    totalPrice += 400;
                    textView.setText("In total for desserts: " + totalPrice + "₸");
                }
                if (position == 1) {
                    Toast.makeText(DessertActivity.this, "Price: 600₸", Toast.LENGTH_SHORT).show();
                    MainActivity.totalPrice+=600;
                    totalPrice += 600;
                    textView.setText("In total for desserts: " + totalPrice + "₸");
                }
                if (position == 2) {
                    Toast.makeText(DessertActivity.this, "Price: 350₸", Toast.LENGTH_SHORT).show();
                    MainActivity.totalPrice+=350;
                    totalPrice += 350;
                    textView.setText("In total for desserts: " + totalPrice + "₸");
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

        MyAdapter(Context c, String itemNames[], String itemDetails[], Double itemPrices[]) {
            super(c, R.layout.row, R.id.textView1, itemNames);
            this.context = c;
            this.itemNames = itemNames;
            this.itemDetails = itemDetails;
            this.itemPrices = itemPrices;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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