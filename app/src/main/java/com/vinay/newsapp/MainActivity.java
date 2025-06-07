package  com.vinay.newsapp;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {
    private static final String TAG = "API_Response";
    private static final String URL = "https://newsdata.io/api/1/latest?apikey=pub_5230629002244320a8ede36ac1fea37c&q=alwar";
    ArrayList<String> arrayList =new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}