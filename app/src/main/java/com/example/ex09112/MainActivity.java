package com.example.ex09112;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private TextView tv;
    private EditText etOp1,etOp2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.tv);
        etOp1 = findViewById(R.id.etOp1);
        etOp2 = findViewById(R.id.etOp2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);

        return super.onCreateOptionsMenu(menu);
    }

    public boolean validEditText()
    {
        try
        {
            Double.parseDouble(etOp1.getText().toString());
            Double.parseDouble(etOp2.getText().toString());
        }
        catch (NumberFormatException e)
        {
            return false;
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(validEditText())
        {
            if (id == R.id.plusItem)
            {
                tv.setText((Double.parseDouble(etOp1.getText().toString()) + Double.parseDouble(etOp2.getText().toString())) + "");
            }
            else if (id == R.id.minisItem)
            {
                tv.setText((Double.parseDouble(etOp1.getText().toString()) - Double.parseDouble(etOp2.getText().toString())) + "");
            }
            else if (id == R.id.multItem)
            {
                tv.setText(Double.parseDouble(etOp1.getText().toString()) * Double.parseDouble(etOp2.getText().toString()) + "");
            }
            else if (id == R.id.divItem)
            {
                if (Double.parseDouble(etOp2.getText().toString()) != 0)
                {
                    tv.setText(Double.parseDouble(etOp1.getText().toString()) / Double.parseDouble(etOp2.getText().toString()) + "");
                }
                else
                {
                    tv.setText("Can't division on 0!");
                }
            }
        }
        if (id == R.id.clearItem)
        {
            tv.setText("");
            etOp1.setText("");
            etOp2.setText("");
        }

        return super.onOptionsItemSelected(item);
    }
}