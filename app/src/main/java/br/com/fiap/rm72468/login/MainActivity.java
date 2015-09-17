package br.com.fiap.rm72468.login;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnLogin = (Button) findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final EditText txtUsuario = (EditText) findViewById(R.id.txtUsuario);
                    final EditText txtSenha   = (EditText) findViewById(R.id.txtSenha);
                    String usuario = txtUsuario.getText().toString();
                    String senha = txtSenha.getText().toString();
                    Log.w(R.string.app_name+"."+this.getClass().getName(), "Usuário fazendo login:"+ usuario);
                    if(senha.equals("fiap") && usuario.equals("fiap")) {
                        imprimir("Login efetuado com sucesso!");
                    }else{
                        imprimir("Usuário ou senha errada!");
                    }

                    /*
                    Dialog dialog = new AlertDialog.Builder(getApplicationContext())
                            .setMessage(txtUsuario.getText() + ":"+txtSenha.getText())
                            .setNeutralButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    txtUsuario.setText("");
                                    txtSenha.setText("");
                                }
                            })
                            .create();
                    dialog.show();*/
                }
            });
    }


    protected void imprimir(String msg){
        Log.w(R.string.app_name+"."+this.getClass().getName(), "MSG: "+msg);
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
