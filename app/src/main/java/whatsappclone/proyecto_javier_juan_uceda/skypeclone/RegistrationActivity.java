package whatsappclone.proyecto_javier_juan_uceda.skypeclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class RegistrationActivity extends AppCompatActivity {

    private EditText etName, etEmail, etPassword;
    private Button btnRegister;
    private TextView tvAlreadyRegistered;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        setUI();
    }

    private void setUI() {
        etEmail = findViewById(R.id.etEmail);
        etName = findViewById(R.id.etName);
        etPassword = findViewById(R.id.etPassword);
        btnRegister = findViewById(R.id.btnRegister);
        tvAlreadyRegistered = findViewById(R.id.tvDontHaveAccount);

        auth = FirebaseAuth.getInstance();

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etName.getText().toString();
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();
            }
        });

        tvAlreadyRegistered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegistrationActivity.this, MainActivity.class));
            }
        });

    }
}