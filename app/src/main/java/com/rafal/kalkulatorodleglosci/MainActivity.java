package com.rafal.kalkulatorodleglosci;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton milaM, milaL, jard, stopa, cal;
    private Button button;
    private TextView textView;
    private EditText dist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroup = (RadioGroup) findViewById(R.id.rgroup);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.rbmilaM) {
                    Toast.makeText(getApplicationContext(), "Wybrano: mile morskie", Toast.LENGTH_SHORT).show();
                } else if (i == R.id.rbmilaL) {
                    Toast.makeText(getApplicationContext(), "Wybrano: mile lądowe", Toast.LENGTH_SHORT).show();
                } else if (i == R.id.rbjard) {
                    Toast.makeText(getApplicationContext(), "Wybrano: jard", Toast.LENGTH_SHORT).show();
                } else if (i == R.id.rbstopa) {
                    Toast.makeText(getApplicationContext(), "Wybrano: stopa", Toast.LENGTH_SHORT).show();
                } else if (i == R.id.rbcal) {
                    Toast.makeText(getApplicationContext(), "Wybrano: cal", Toast.LENGTH_SHORT).show();
                }
            }
        });

        milaM = (RadioButton) findViewById(R.id.rbmilaM);
        milaL = (RadioButton) findViewById(R.id.rbmilaL);
        jard = (RadioButton) findViewById(R.id.rbjard);
        stopa = (RadioButton) findViewById(R.id.rbstopa);
        cal = (RadioButton) findViewById(R.id.rbcal);
        textView = (TextView) findViewById(R.id.wynik);
        button = (Button) findViewById(R.id.button);
        dist = (EditText) findViewById(R.id.etMetry);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                final double ds = new Double(dist.getText().toString());

                java.text.DecimalFormat df = new java.text.DecimalFormat();
                df.setMinimumFractionDigits(2);
                df.setMaximumFractionDigits(2);

                if (selectedId == milaM.getId()) {
                    Anglo mm = new Anglo(ds, IPrzeliczniki.milaPP);
                    textView.setText(String.format("Odległość w milach morskich: " + df.format(mm.policzOdl())));
                } else if (selectedId == milaL.getId()) {
                    Anglo mL = new Anglo(ds, IPrzeliczniki.milaPP);
                    textView.setText(String.format("Odległość w milach lądowych: " + df.format(mL.policzOdl())));
                } else if (selectedId == jard.getId()) {
                    Anglo jd = new Anglo(ds, IPrzeliczniki.milaPP);
                    textView.setText(String.format("Odległość w jardach: " + df.format(jd.policzOdl())));
                } else if (selectedId == stopa.getId()) {
                    Anglo st = new Anglo(ds, IPrzeliczniki.milaPP);
                    textView.setText(String.format("Odległość w stopach: " + df.format(st.policzOdl())));
                } else if (selectedId == cal.getId()) {
                    Anglo cl = new Anglo(ds, IPrzeliczniki.milaPP);
                    textView.setText(String.format("Odległość w calach: " + df.format(cl.policzOdl())));
                }
            }
        });

    }
}