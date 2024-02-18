package com.example.finalproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


@RequiresApi(api = Build.VERSION_CODES.O)
public class MainActivity extends AppCompatActivity {
    private AutoCompleteTextView symbolAutoCompleteTextView;
    private Button fetchDataButton;
    private ArrayList<String> suggestions = new ArrayList<>();

    @SuppressLint({"SetJavaScriptEnabled", "MissingInflatedId"})
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        symbolAutoCompleteTextView = findViewById(R.id.symbolAutoCompleteTextView);
        fetchDataButton = findViewById(R.id.fetchDataButton);

        new ReadCSVTask().execute();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, suggestions);

        symbolAutoCompleteTextView.setAdapter(adapter);

        symbolAutoCompleteTextView.setOnItemClickListener((parent, view, position, id) -> {
            String selectedSymbol = (String) parent.getItemAtPosition(position);
            openDetailActivity(selectedSymbol);
        });

        fetchDataButton.setOnClickListener(v -> {
            String selectedSymbol = symbolAutoCompleteTextView.getText().toString();
            if (!TextUtils.isEmpty(selectedSymbol)) {
                openDetailActivity(selectedSymbol);
            } else {
                Toast.makeText(MainActivity.this, "Select a symbol first", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private class ReadCSVTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... params) {
            try {
                InputStream inputStream = getAssets().open("supported_tickers.csv");
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                bufferedReader.readLine();
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    String[] fields = line.split(",");

                    if (fields.length > 5 && fields[5].equals("2024-01-19")) {
                        suggestions.add(fields[0]);
                    }
                }

                inputStream.close();
                inputStreamReader.close();
                bufferedReader.close();

            } catch (IOException e) {
                Log.e("CSV", "Error reading CSV file", e);
            }

            return null;
        }
    }

    private void openDetailActivity(String ticker) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("TICKER", ticker);
        startActivity(intent);
    }
}
