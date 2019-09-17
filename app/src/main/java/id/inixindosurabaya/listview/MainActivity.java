package id.inixindosurabaya.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    // 1. inisialisasi komponen
    ListView simpleList;
    String countryList[] = {
            "Indonesia", "India", "Singapore", "Germany", "Italy", "Japan", "Portugal",
            "Argentina", "Brazil", "Chile", "USA", "England", "Finland",
            "New Zealand", "Guinea", "South Africa", "Egypt", "Congo",
            "Ghana", "Honduras", "Thailand", "Vietnam", "Bangladesh"
    };
    int flags[] = {
            R.drawable.id,
            R.drawable.in,
            R.drawable.sg,
            R.drawable.de,
            R.drawable.it,
            R.drawable.jp,
            R.drawable.pt,
            R.drawable.ar,
            R.drawable.br,
            R.drawable.cl,
            R.drawable.us,
            R.drawable.gb,
            R.drawable.fi,
            R.drawable.nz,
            R.drawable.gn,
            R.drawable.za,
            R.drawable.eg,
            R.drawable.cd,
            R.drawable.gh,
            R.drawable.hn,
            R.drawable.th,
            R.drawable.vn,
            R.drawable.bd
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 2. mengenali komponen
        simpleList = findViewById(R.id.simple_listview);

        // membuat adapter untuk listview
        /*ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, R.layout.activity_listview,
                R.id.textView, countryList
        );*/

        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(),
                countryList, flags);

        simpleList.setAdapter(customAdapter);

        simpleList.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(MainActivity.this,
                "You clicked at: " + countryList[position], Toast.LENGTH_SHORT).show();
    }
}
