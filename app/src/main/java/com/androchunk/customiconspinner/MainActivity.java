package com.androchunk.customiconspinner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner customSpinner;
    ArrayList<CustomItem> customList;
    int width = 150; //set according to your use

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        customSpinner = findViewById(R.id.customIconSpinner);
        customList = getCustomList();
        CustomAdapter adapter = new CustomAdapter(this, customList);
        if (customSpinner != null) {
            customSpinner.setAdapter(adapter);
            customSpinner.setOnItemSelectedListener(this);
        }

    }

    private ArrayList<CustomItem> getCustomList() {
        customList = new ArrayList<>();
        customList.add(new CustomItem("Android", R.drawable.ic_android_black_24dp));
        customList.add(new CustomItem("School", R.drawable.ic_school_black_24dp));
        customList.add(new CustomItem("Satisfied", R.drawable.ic_sentiment_very_satisfied_black_24dp));
        customList.add(new CustomItem("Shopping Cart", R.drawable.ic_shopping_cart_black_24dp));
        customList.add(new CustomItem("Whatshot", R.drawable.ic_whatshot_black_24dp));
        return customList;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        try {
            LinearLayout linearLayout = findViewById(R.id.customSpinnerItemLayout);
            width = linearLayout.getWidth();
        } catch (Exception e) {
        }
        customSpinner.setDropDownWidth(width);
        CustomItem item = (CustomItem) adapterView.getSelectedItem();
        Toast.makeText(this, item.getSpinnerItemName(), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
