package  com.vinay.newsapp;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.vinay.newsapp.adapters.newsadapter;
import com.vinay.newsapp.models.newsmodel;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {
    private static final String URL = "https://newsdata.io/api/1/latest?apikey=pub_5230629002244320a8ede36ac1fea37c&q=";
    ArrayList<newsmodel> list =new ArrayList<>();
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerView);
        loadData("alwar");
        LinearLayoutManager manager =new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        findViewById(R.id.srchbtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadData(((EditText)findViewById(R.id.search)).getText().toString());
            }
        });
    }
    public void loadData(String about)
    {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest =new JsonObjectRequest(Request.Method.GET,URL+about,null,response -> {
            try {
                if(response.getString("status").equals("success"))
                {
                    JSONArray jsonArray =response.getJSONArray("results");
                    list.clear();
                    for(int i=0;i<jsonArray.length();i++)
                    {
                        JSONObject jsonObject =jsonArray.getJSONObject(i);
                        newsmodel model =new newsmodel(jsonObject.getString("article_id"),jsonObject.getString("image_url"),jsonObject.getString("title"),jsonObject.getString("description"));
                        list.add(model);
                    }
                    newsadapter newsadapter =new newsadapter(list,this);
                    recyclerView.setAdapter(newsadapter);
                }
            }
            catch(Exception e)
            {
                Log.e("Error",e.getMessage());
            }
        },error -> {
            Log.e("error",error.getMessage());
        });
        requestQueue.add(jsonObjectRequest);
    }
}