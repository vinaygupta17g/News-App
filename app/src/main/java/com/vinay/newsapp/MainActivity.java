package  com.vinay.newsapp;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "API_Response";
    private static final String URL = "https://newsdata.io/api/1/latest?apikey=pub_5230629002244320a8ede36ac1fea37c&q=alwar";
    ListView listView;
    ArrayList<String> arrayList =new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView =findViewById(R.id.listView);
        ArrayAdapter<String> adapter =new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(adapter);
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                URL,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            Log.d(TAG, "Response received");
                            if(response.getString("status").equals("success"))
                            {
                                JSONArray jsonArray = response.getJSONArray("results");
                                for(int i=0;i<jsonArray.length();i++)
                                {
                                    JSONObject jsonObject =jsonArray.getJSONObject(i);
                                    String name = jsonObject.getString("title");
                                    arrayList.add(name);
                                    adapter.notifyDataSetChanged();
                                }
                            }
                        } catch (Exception e) {
                            Log.e(TAG, "Parsing error: " + e.getMessage());
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e(TAG, "Volley error: " + error.getMessage());
                    }
                });

        requestQueue.add(jsonObjectRequest);
    }
}