package com.toney.tempconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class TempConverterActivity extends AppCompatActivity {

    private TextView celciusTV;
    private EditText fahrenheitTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp_converter);

        celciusTV = (TextView) findViewById(R.id.celciusTV);
        fahrenheitTV = (EditText) findViewById(R.id.fahrenheitTV);

        fahrenheitTV.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    float f = Float.parseFloat(fahrenheitTV.getText().toString());
                    celciusTV.setText(String.valueOf(convertFahrenheitToCelcius(f)));
                    return true;
                }
                return false;
            }
        });
    }

        private float convertFahrenheitToCelcius(float fahrenheit) {
        return ((fahrenheit - 32) * 5/9);
    }
}
