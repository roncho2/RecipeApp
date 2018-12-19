package com.example.ronch02.recipeapp.authentication;import androidx.appcompat.app.AppCompatActivity;import android.content.Context;import android.content.Intent;import android.os.Bundle;import android.os.PersistableBundle;import android.util.Patterns;import android.view.View;import android.widget.Button;import android.widget.EditText;import android.widget.Toast;import com.bumptech.glide.Glide;import com.example.ronch02.recipeapp.MainActivity;import com.example.ronch02.recipeapp.R;public class LoginActivity extends AppCompatActivity {    private EditText email_Text;    private EditText passWord_Text;    private Button login_Button;    @Override    public void onCreate(Bundle savedInstanceState) {        super.onCreate(savedInstanceState);        setContentView(R.layout.activity_login_acivity);        email_Text = findViewById(R.id.input_email);        passWord_Text = findViewById(R.id.input_password);        login_Button = findViewById(R.id.btn_login);        login_Button.setOnClickListener(new View.OnClickListener() {            @Override            public void onClick(View view) {                doLogIn();            }        });    }    public  void  doLogIn(){        if(!validate()) {            Toast.makeText(this, "Error Login In!", Toast.LENGTH_SHORT).show();          return;        }        Intent intent = new Intent(this, MainActivity.class);        startActivity(intent);    }    public boolean validate() {        String inPutEmail = email_Text.getText().toString();        String inPutPassWord = passWord_Text.getText().toString();        if (inPutEmail.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(inPutEmail).matches()) {            email_Text.setError("Invalid email");            return false;        }        if (inPutPassWord.isEmpty() || inPutPassWord.length() < 6 || inPutPassWord.equals(" ")) {            passWord_Text.setError("It has to be alphanumeric character");            return false;        }        return true;    }}