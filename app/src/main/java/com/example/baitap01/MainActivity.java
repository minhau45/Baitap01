package com.example.baitap01;

import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText edtArray, edtInput;
    TextView tvKetQua;
    Button btnArray, btnXuLy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);


        edtArray = findViewById(R.id.edtArray);
        edtInput = findViewById(R.id.edtInput);
        tvKetQua = findViewById(R.id.tvKetQua);
        btnArray = findViewById(R.id.btnArray);
        btnXuLy = findViewById(R.id.btnXuLy);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.imgSinhVien), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnArray.setOnClickListener(v -> {
            String input = edtArray.getText().toString().trim();
            if (input.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập dãy số!", Toast.LENGTH_SHORT).show();
                return;
            }

            String[] parts = input.split("\\s+");
            ArrayList<Integer> chan = new ArrayList<>();
            ArrayList<Integer> le = new ArrayList<>();

            try {
                for (String p : parts) {
                    int n = Integer.parseInt(p);
                    if (n % 2 == 0) chan.add(n);
                    else le.add(n);
                }
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Vui lòng chỉ nhập số!", Toast.LENGTH_SHORT).show();
                return;
            }

            Log.d("ARRAY_LIST", "Số chẵn: " + chan);
            Log.d("ARRAY_LIST", "Số lẻ: " + le);

            tvKetQua.setText("Số chẵn: " + chan + "\nSố lẻ: " + le);
        });
        btnXuLy.setOnClickListener(v -> {
            String input = edtInput.getText().toString().trim();

            if (input.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập chuỗi!", Toast.LENGTH_SHORT).show();
                return;
            }

            String[] words = input.split(" ");
            StringBuilder reversed = new StringBuilder();
            for (int i = words.length - 1; i >= 0; i--) {
                reversed.append(words[i]).append(" ");
            }

            String result = reversed.toString().trim().toUpperCase();
            tvKetQua.setText("Chuỗi đảo ngược: " + result);
            Toast.makeText(this, result, Toast.LENGTH_LONG).show();
        });
    }
}
