package com.example.easydrip.ui.login;

import android.app.Activity;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import android.content.Context;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.easydrip.MainActivity;
import com.example.easydrip.R;
import com.example.easydrip.model.Usuario;
import com.example.easydrip.ui.login.LoginViewModel;
import com.example.easydrip.ui.login.LoginViewModelFactory;
import com.example.easydrip.databinding.ActivityLoginBinding;
import com.google.android.material.snackbar.Snackbar;

import java.io.IOException;

import io.response.ApiAdapter;
import io.response.ApiService;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    private LoginViewModel loginViewModel;
    Button Registro;
    Button Vuelta;
    Button ConfirmarRegistro;
    Button Loguin;

    Button ConfirmarLogin;
    EditText Nombre,Apellidos,Nick,Contraseña,Contraseña2,email;


    String NombreForm; String ApellidosForm; String NickForm; String ContraseñaForm;
    String Contraseña2Form; String emailForm;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Loguin=findViewById(R.id.btnLoguearse);
        Loguin.setVisibility(View.VISIBLE);
        ConfirmarLogin=findViewById(R.id.btnSubmitLogin);
        ConfirmarLogin.setVisibility(View.INVISIBLE);
        Registro=findViewById(R.id.btnRegistrarse);
        Registro.setVisibility(View.VISIBLE);
        Vuelta=findViewById(R.id.volver);
        Vuelta.setVisibility(View.VISIBLE);
        ConfirmarRegistro=findViewById(R.id.btnSubmitRegistro);
        ConfirmarRegistro.setVisibility(View.INVISIBLE);
        Nombre=findViewById(R.id.eT_Nombre);
        Nombre.setVisibility(View.INVISIBLE);
        Apellidos=findViewById(R.id.eT_Apellidos);
        Apellidos.setVisibility(View.INVISIBLE);
        Nick=findViewById(R.id.eT_Nick);
        Nick.setVisibility(View.INVISIBLE);
        Contraseña=findViewById(R.id.eT_Contraseña);
        Contraseña.setVisibility(View.INVISIBLE);
        Contraseña2=findViewById(R.id.eT_ContraseñaX2);
        Contraseña2.setVisibility(View.INVISIBLE);
        email=findViewById(R.id.eT_Correo);
        email.setVisibility(View.INVISIBLE);







       loginViewModel = new ViewModelProvider(this, new LoginViewModelFactory())
                .get(LoginViewModel.class);


       /*
        loginViewModel.getLoginFormState().observe(this, new Observer<LoginFormState>() {
            @Override
            public void onChanged(@Nullable LoginFormState loginFormState) {
                if (loginFormState == null) {
                    return;
                }
                loginButton.setEnabled(loginFormState.isDataValid());
                if (loginFormState.getUsernameError() != null) {
                    usernameEditText.setError(getString(loginFormState.getUsernameError()));
                }
                if (loginFormState.getPasswordError() != null) {
                    passwordEditText.setError(getString(loginFormState.getPasswordError()));
                }
            }
        });

        loginViewModel.getLoginResult().observe(this, new Observer<LoginResult>() {
            @Override
            public void onChanged(@Nullable LoginResult loginResult) {
                if (loginResult == null) {
                    return;
                }
                loadingProgressBar.setVisibility(View.GONE);
                if (loginResult.getError() != null) {
                    showLoginFailed(loginResult.getError());
                }
                if (loginResult.getSuccess() != null) {
                    updateUiWithUser(loginResult.getSuccess());
                }
                setResult(Activity.RESULT_OK);

                //Complete and destroy login activity once successful
                finish();
            }
        });

        TextWatcher afterTextChangedListener = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // ignore
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // ignore
            }

            @Override
            public void afterTextChanged(Editable s) {
                loginViewModel.loginDataChanged(usernameEditText.getText().toString(),
                        passwordEditText.getText().toString());
            }
        };
        usernameEditText.addTextChangedListener(afterTextChangedListener);
        passwordEditText.addTextChangedListener(afterTextChangedListener);
        passwordEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    loginViewModel.login(usernameEditText.getText().toString(),
                            passwordEditText.getText().toString());
                }
                return false;
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingProgressBar.setVisibility(View.VISIBLE);
                loginViewModel.login(usernameEditText.getText().toString(),
                        passwordEditText.getText().toString());
            }
        }); */
    }

    public void formRegistrarse(View view) {
        ConfirmarRegistro.setVisibility(View.VISIBLE);
        Nombre.setVisibility(View.VISIBLE);
        Apellidos.setVisibility(View.VISIBLE);
        Contraseña.setVisibility(View.VISIBLE);
        Contraseña2.setVisibility(View.VISIBLE);
        Nick.setVisibility(View.VISIBLE);
        email.setVisibility(View.VISIBLE);
    }

    public void volverAlMain(View view) {

    }

    public void formIniciarSesion(View view) {
        Nick.setVisibility(View.VISIBLE);
        Contraseña.setVisibility(View.VISIBLE);
        Registro.setVisibility(View.INVISIBLE);
        Nick.setText("");
        Contraseña.setText("");
        ConfirmarLogin.setVisibility(View.VISIBLE);


    }
    public void loginAPI(String nick,String contraseña){
        Retrofit retrofit= new Retrofit.Builder().baseUrl("http://localhost:8086/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        ApiService apiService = retrofit.create(ApiService.class);
        Call<Usuario> call=apiService.loginUsuario(nick,contraseña);
        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                try {

                    if(response.isSuccessful()){
                        Usuario user=response.body();
                       // Usuario.setNick(Nick.getText().toString());


                    }

                }catch (Exception ex){
                    Toast.makeText(LoginActivity.this, ex.getMessage(), Toast.LENGTH_SHORT);
                }
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {

            }
        });
    }

    public void formConfirmarRegistrarse(View view) {
        ConfirmarRegistro.setVisibility(View.INVISIBLE);
        Nombre.setVisibility(View.INVISIBLE);
        Apellidos.setVisibility(View.INVISIBLE);
        Contraseña.setVisibility(View.INVISIBLE);
        Contraseña2.setVisibility(View.INVISIBLE);
        Nick.setVisibility(View.INVISIBLE);
        email.setVisibility(View.INVISIBLE);
        Registro.setVisibility(View.INVISIBLE);

        String NombreForm = String.valueOf(Nombre.getText().toString());
        String ApellidosForm = String.valueOf(Apellidos.getText().toString());
        String NickForm = String.valueOf(Nick.getText().toString());
        String ContraseñaForm = String.valueOf(Contraseña.getText().toString());
        String Contraseña2Form = String.valueOf(Contraseña2.getText().toString());
        String emailForm = String.valueOf(email.getText().toString());

        if(!ContraseñaForm.toString().equals(Contraseña2Form.toString())) {

            Nombre.setText("");Apellidos.setText("");Contraseña.setText("");Contraseña2.setText("");Nick.setText("");email.setText("");
            Nombre.setVisibility(View.VISIBLE);
            Apellidos.setVisibility(View.VISIBLE);
            Contraseña.setVisibility(View.VISIBLE);
            Contraseña2.setVisibility(View.VISIBLE);
            Nick.setVisibility(View.VISIBLE);
            email.setVisibility(View.VISIBLE);

            NombreForm = String.valueOf("");
            ApellidosForm = String.valueOf("");
            NickForm = String.valueOf("");
            ContraseñaForm = String.valueOf("");
            Contraseña2Form = String.valueOf("");
            emailForm = String.valueOf("");
            ConfirmarRegistro.setVisibility(View.VISIBLE);
            Toast errorPass =
                    Toast.makeText(getApplicationContext(),"Error de datos insertados", Toast.LENGTH_SHORT);
            errorPass.show();
        }

        Toast toast1 =
                Toast.makeText(getApplicationContext(),NickForm + ApellidosForm + ContraseñaForm + Contraseña2Form + NombreForm + emailForm, Toast.LENGTH_SHORT);

        toast1.show();
    }

    private void registrarUsuario() {
        NickForm = Nick.getText().toString().trim();
        ContraseñaForm = Contraseña.getText().toString().trim();
        NickForm = Nick.getText().toString().trim();
        ContraseñaForm = Contraseña.getText().toString().trim();
        NickForm = Nick.getText().toString().trim();

        if (NickForm.isEmpty()) {
            Nick.setError("El Nick es obligatorio");
            Nick.requestFocus();
            return;
        } else if (ContraseñaForm.isEmpty()) {
            Contraseña.setError("La contraseña es obligatoria");
            Contraseña.requestFocus();
            return;
        }
        String nick =Nick.getText().toString().trim();
        String contraseña =Contraseña.getText().toString().trim() ;
        Call<ResponseBody> call = ApiAdapter
                .getInstance()
                .getAPI()
                .loginUsuario(new Usuario(NickForm, ContraseñaForm));

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                String s = "";
                try {
                    s = response.body().string();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if(s.equals("SUCCESS")) {
                    Toast.makeText(LoginActivity.this, "Registrado correctamente, ahora inicia sesión", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(LoginActivity.this, LoginActivity.class));
                } else {
                    Toast.makeText(LoginActivity.this,"Este Usuario ya existe", Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(LoginActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }

    public void btnAccederContenido(View view) {

    }

    public void formConfirmarLogin(View view) {

    }

   /* private void updateUiWithUser(LoggedInUserView model) {
        String welcome = getString(R.string.welcome) + model.getDisplayName();
        // TODO : initiate successful logged in experience
        Toast.makeText(getApplicationContext(), welcome, Toast.LENGTH_LONG).show();
    }

    private void showLoginFailed(@StringRes Integer errorString) {
        Toast.makeText(getApplicationContext(), errorString, Toast.LENGTH_SHORT).show();
    }*/
}