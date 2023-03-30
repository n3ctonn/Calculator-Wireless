package com.example.calculatorwireless;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {
    RadioButton radAdd;
    RadioButton radSott;
    RadioButton radMolt;
    RadioButton radDiv;

    EditText primo;
    EditText secondo;
    EditText risultato;

    Button invia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radAdd = findViewById(R.id.rad_add);
        radSott = findViewById(R.id.rad_sott);
        radMolt = findViewById(R.id.rad_molt);
        radDiv = findViewById(R.id.rad_div);

        primo = findViewById(R.id.first);
        secondo = findViewById(R.id.second);
        risultato = findViewById(R.id.resoult);

        invia = findViewById(R.id.calculate);
        invia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numerouno = primo.getText().toString();
                int X = Integer.parseInt(numerouno);

                String numerodue = secondo.getText().toString();
                int Y = Integer.parseInt(numerodue);

                String operazione = "";
                if (radAdd.isChecked()) {
                    operazione = "add";
                } else if (radSott.isChecked()) {
                    operazione = "sub";
                } else if (radMolt.isChecked()) {
                    operazione = "mul";
                } else if (radDiv.isChecked()) {
                    operazione = "div";
                }

                String url = "https://tc.heiz.cc/Calcolatrice/" + operazione + "?X=" + X + "&Y=" + Y + "";
                StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                risultato.setText(response);
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "Errore nella richiesta", Toast.LENGTH_SHORT).show();
                    }
                });
                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                queue.add(stringRequest);
            }
        });
    }
}
