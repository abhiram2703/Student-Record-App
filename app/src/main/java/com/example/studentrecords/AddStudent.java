package com.example.studentrecords;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class AddStudent extends AppCompatActivity {
    EditText et1,et2,et3,et4,et5,et6,et7,et8;
    AppCompatButton bt1;
    String apiurl="https://courseapplogix.onrender.com/addstudents";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_student);
        et1=(EditText) findViewById(R.id.fnet);
        et2=(EditText) findViewById(R.id.lnet);
        et3=(EditText) findViewById(R.id.clget);
        et4=(EditText) findViewById(R.id.dobet);
        et5=(EditText) findViewById(R.id.couret);
        et6=(EditText) findViewById(R.id.mobet);
        et7=(EditText) findViewById(R.id.mailet);
        et8=(EditText) findViewById(R.id.addet);
        bt1=(AppCompatButton) findViewById(R.id.addbtn);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fname=et1.getText().toString();
                String lname=et2.getText().toString();
                String clg=et3.getText().toString();
                String dob=et4.getText().toString();
                String course=et5.getText().toString();
                String mob=et6.getText().toString();
                String mail=et7.getText().toString();
                String addr=et8.getText().toString();
                JSONObject student=new JSONObject();
                try {
                    student.put("firstname",fname);
                    student.put("lastname",lname);
                    student.put("college",clg);
                    student.put("dob",dob);
                    student.put("course",course);
                    student.put("mobile",mob);
                    student.put("email",mail);
                    student.put("address",addr);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
                JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(
                        Request.Method.POST,
                        apiurl,
                        student,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                Toast.makeText(getApplicationContext(), "SUCCESSFULL", Toast.LENGTH_LONG).show();
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(getApplicationContext(),"ERROR",Toast.LENGTH_LONG).show();
                            }
                        }
                );
                RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
                requestQueue.add(jsonObjectRequest);

            }
        });

    }
}