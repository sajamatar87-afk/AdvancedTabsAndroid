package com.example.advancedtabsapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private EditText emailInput;
    private EditText passwordInput;
    private Button loginButton;
    private boolean exitWarningShown = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailInput = findViewById(R.id.emailInput);
        passwordInput = findViewById(R.id.passwordInput);
        loginButton = findViewById(R.id.loginButton);

        loginButton.setEnabled(false);

        emailInput.addTextChangedListener(new SimpleTextWatcher(this::validateForm));
        passwordInput.addTextChangedListener(new SimpleTextWatcher(this::validateForm));

        loginButton.setOnClickListener(v -> {
            if (isFormValid()) {
                Intent intent = new Intent(MainActivity.this, ModeActivity.class);
                startActivity(intent);
            } else {
                validateForm();
            }
        });

        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                long now = System.currentTimeMillis();
                if (exitWarningShown && now - lastBackPressedTime <= 2000) {
                    finish();
                    return;
                }

                exitWarningShown = true;
                lastBackPressedTime = now;
                Snackbar.make(findViewById(R.id.mainRoot),
                                "Press back again to exit",
                                Snackbar.LENGTH_SHORT)
                        .addCallback(new Snackbar.Callback() {
                            @Override
                            public void onDismissed(Snackbar transientBottomBar, int event) {
                                super.onDismissed(transientBottomBar, event);
                                if (System.currentTimeMillis() - lastBackPressedTime > 2000) {
                                    exitWarningShown = false;
                                }
                            }
                        })
                        .show();
            }
        });
    }

    private long lastBackPressedTime = 0L;

    private void validateForm() {
        boolean valid = isFormValid();
        loginButton.setEnabled(valid);

        if (!emailInput.getText().toString().trim().isEmpty()
                && !Patterns.EMAIL_ADDRESS.matcher(emailInput.getText().toString().trim()).matches()) {
            emailInput.setError("Enter a valid email address");
        } else {
            emailInput.setError(null);
        }

        if (!passwordInput.getText().toString().isEmpty()
                && passwordInput.getText().toString().length() < 6) {
            passwordInput.setError("Password must be at least 6 characters");
        } else {
            passwordInput.setError(null);
        }
    }

    private boolean isFormValid() {
        String email = emailInput.getText().toString().trim();
        String password = passwordInput.getText().toString();
        return Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length() >= 6;
    }
}
