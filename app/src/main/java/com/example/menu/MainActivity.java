package com.example.menu;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    static int totalPrice = 0;

    TextView textView;
    ListView listView1;

    String categories[] = {"Burgers", "Desserts", "Drinks"};
    String description[] = {"The Freshest Burgers", "The Sweetiest Desserts", "The Tastiest Drinks"};
    int images[] = {R.drawable.burgers, R.drawable.desserts, R.drawable.drinks};
    // so our images and other things are set in array

    // now paste some images in drawable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textViewPrice);
        textView.setText("In total: " + totalPrice + "₸");

        listView1 = findViewById(R.id.listView1);
        // now create an adapter class

        MyAdapter adapter1 = new MyAdapter(this, categories);
        listView1.setAdapter(adapter1);
        // there is my mistake...
        // now again check this..

        // now set item click on list view
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position ==  0) {
                    Intent intent = new Intent(getApplicationContext(), BurgerActivity.class);
                    startActivity(intent);

                }
                if (position ==  1) {
                    Intent intent = new Intent(getApplicationContext(), DessertActivity.class);
                    startActivity(intent);
                }
                if (position ==  2) {
                    Intent intent = new Intent(getApplicationContext(), DrinkActivity.class);
                    startActivity(intent);
                }
            }
        });


        // so item click is done now check list view
    }

    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String categories[];

        MyAdapter (Context c, String categories[]) {
            super(c, R.layout.row, R.id.textView1, categories);
            this.context = c;
            this.categories = categories;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            TextView myTitle = row.findViewById(R.id.textView1);
            TextView mySubTitle = row.findViewById(R.id.textView2);
            ImageView myImage = row.findViewById(R.id.image);

            // now set our resources on views
            myTitle.setText(categories[position]);
            mySubTitle.setText(description[position]);
            myImage.setImageResource(images[position]);

            return row;
        }
    }
}