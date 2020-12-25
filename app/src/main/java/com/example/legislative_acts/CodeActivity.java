package com.example.legislative_acts;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.legislative_acts.databinding.FragmentCodeBinding;
import com.example.legislative_acts.screen.LocalStorage;
import com.example.legislative_acts.screen.RSAUtil;



import java.util.Calendar;

public class CodeActivity extends AppCompatActivity {

    private FragmentCodeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentCodeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (!(LocalStorage.instance.getExpiredDate() <= Calendar.getInstance().getTimeInMillis())) {
            LocalStorage.instance.setAccepted(false);
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }

        binding.txtCode.setText(String.valueOf(System.currentTimeMillis()));

        binding.btnRestart.setOnClickListener(v -> {
            binding.txtCode.setText(String.valueOf(System.currentTimeMillis()));
        });

        binding.btnSend.setOnClickListener(v -> {
            if (!binding.txtCode.getText().toString().isEmpty()) {
                String url = "https://t.me/Umid_Yodgorov";
                String sendCode = binding.txtCode.getText().toString();
                Intent sendIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));

                ClipboardManager clipboard = (ClipboardManager)
                        this.getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("sent code", sendCode);
                clipboard.setPrimaryClip(clip);

                startActivity(sendIntent);
            } else {
                Toast.makeText(this, "Iltimos avval kodni kiriting", Toast.LENGTH_SHORT).show();
            }
        });

        binding.btnEnter.setOnClickListener(v -> {
            String code = binding.etCodeCameFromEmployee.getText().toString().trim();
            try {
                if (code.length() != 174) {
                    Toast.makeText(
                            this,
                            "Kiritayotgan kodingiz xodim belgilangan uzunlikda bo'lishi kerak. Iltimos qaytadan tekshirib ko'ring!!!",
                            Toast.LENGTH_SHORT
                    ).show();
                } else {
                    String cameCode =
                            RSAUtil.decrypt(code, RSAUtil.privateKey);
                    String userHashCode = binding.txtCode.getText().toString();
                    Log.d("T12T",cameCode);
                    Log.d("T12T",userHashCode);
                    if (userHashCode.equals(cameCode)) {
                        Toast.makeText(
                                this,
                                "Muvaffaqqiyatli aniqlandi",
                                Toast.LENGTH_SHORT
                        ).show();
                        LocalStorage.instance.setAccepted(true);
                        Calendar calendar = Calendar.getInstance();
                        calendar.add(Calendar.DAY_OF_MONTH, 2);
                        LocalStorage.instance.setExpiredDate(calendar.getTimeInMillis());
                        startActivity(new Intent(this, MainActivity.class));
                    } else {
                        Toast.makeText(
                                this,
                                "XATOLIK!!!.Xodim yuborgan kod sizdagi kod bilan bir xil emas",
                                Toast.LENGTH_SHORT
                        ).show();
                    }
                }
            } catch (Exception exception) {
                Toast.makeText(
                        this,
                        "Siz xodim yuborgan kodga o'zgartirish kiritgansiz. Iltimosa qaytadan tekshirib ko'ring!!!",
                        Toast.LENGTH_SHORT
                ).show();
            }
        });


    }
}