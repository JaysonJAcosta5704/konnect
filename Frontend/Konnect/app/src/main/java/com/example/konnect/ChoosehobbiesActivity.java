package com.example.konnect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ChoosehobbiesActivity extends AppCompatActivity {

    private String username_hobby;
    private List<CheckBox> checkBoxes = new ArrayList<>();
    private String url = "https://localhost/hobby";


    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_hobby);

        Intent intent = getIntent();
        username_hobby = intent.getStringExtra("USERNAME");

        checkBoxes.add((CheckBox) findViewById(R.id.checkBox1));
        checkBoxes.add((CheckBox) findViewById(R.id.checkBox2));
        checkBoxes.add((CheckBox) findViewById(R.id.checkBox3));
        checkBoxes.add((CheckBox) findViewById(R.id.checkBox4));
        checkBoxes.add((CheckBox) findViewById(R.id.checkBox5));
        checkBoxes.add((CheckBox) findViewById(R.id.checkBox6));
        checkBoxes.add((CheckBox) findViewById(R.id.checkBox7));
        checkBoxes.add((CheckBox) findViewById(R.id.checkBox8));
        checkBoxes.add((CheckBox) findViewById(R.id.checkBox9));
        checkBoxes.add((CheckBox) findViewById(R.id.checkBox10));

        Button submitButton = findViewById(R.id.hobby_choose_btn);

        submitButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                submitHobbies();
            }
        });



    }

    private void submitHobbies(){
        //JSON array for storing hobbies
        JSONArray hobbiesArray = new JSONArray();

        for(CheckBox checkBox : checkBoxes){
            if(checkBox.isChecked()){
                hobbiesArray.put(checkBox.getText().toString());

            }

        }

        JSONObject postBody = new JSONObject();
        try{
            postBody.put("HOBBY", hobbiesArray);
            postBody.put("USERNAME", username_hobby);
        }catch (JSONException e){
            e.printStackTrace();
        }

        sendPostRequest(url, postBody);


    }

    public void sendPostRequest(String url_post, JSONObject postBody){

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.POST,
                url_post,
                postBody,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Toast.makeText(ChoosehobbiesActivity.this, "Data submitted", Toast.LENGTH_SHORT).show();

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(ChoosehobbiesActivity.this, "Error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
        ){
            /**for later use
             *
             * @return
             */
            public Map<String, String> getParams(){
                Map<String, String> params = new HashMap<String, String>();

                return params;
            }
        };

        requestQueue.add(request);



    }


}