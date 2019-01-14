package com.example.javi.beentheredonethat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class QuizMenuActivity extends QuizActivity {

    private ListView menuList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_menu);

        colocarItemsMenu();

        asignarListeners();

    }

    protected void colocarItemsMenu() {

        this.menuList = (ListView) findViewById(R.id.ListView_Menu);

        String[] items = {
                getResources().getString(R.string.menuItemPlay),
                getResources().getString(R.string.menuItemSettings),
                getResources().getString(R.string.menuItemScores),
                getResources().getString(R.string.menuItemHelp)
        };

        ArrayAdapter<String> adapt = new ArrayAdapter<String>(this, R.layout.menu_item, items);

        this.menuList.setAdapter(adapt);
    }

    protected void asignarListeners() {
        this.menuList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View itemClicked, int position, long id) {
                TextView textView = (TextView) itemClicked;
                String strText = textView.getText().toString();
                if (strText.equalsIgnoreCase(getResources().getString(R.string.menuItemPlay))) {
                    // Game Activity
                    startActivity(new Intent(QuizMenuActivity.this, QuizGameActivity.class));
                } else if (strText.equalsIgnoreCase(getResources().getString(R.string.menuItemSettings))) {
                    // Settings Activity
                    startActivity(new Intent(QuizMenuActivity.this, QuizSettingsActivity.class));
                } else if (strText.equalsIgnoreCase(getResources().getString(R.string.menuItemScores))) {
                    // Scores Activity
                    startActivity(new Intent(QuizMenuActivity.this, QuizScoresActivity.class));
                } else if (strText.equalsIgnoreCase(getResources().getString(R.string.menuItemHelp))) {
                    // Help Activity
                    startActivity(new Intent(QuizMenuActivity.this, QuizHelpActivity.class));
                }
            }
        });
    }
}
