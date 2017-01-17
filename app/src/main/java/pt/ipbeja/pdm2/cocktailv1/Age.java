package pt.ipbeja.pdm2.cocktailv1;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Age extends AppCompatActivity {


    final Context context = this;
    private Button button;
    private EditText result;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_age);


        LayoutInflater li = LayoutInflater.from(context);
        View promptsView = li.inflate(R.layout.prompts, null);

        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                context);


        alertDialogBuilder.setView(promptsView);

        final EditText userInput = (EditText) promptsView
                .findViewById(R.id.editTextDialogUserInput);

        // set dialog message
        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {

                                if(Integer.parseInt(userInput.getText().toString()) >= 18) {
                                    Intent intent = new Intent(Age.this, MainActivity.class);
                                    startActivity(intent);
                                    Age.this.finish();
                                    overridePendingTransition(R.anim.fadein, R.anim.fadeout);

                                }
                                    else
                                {
                                   ageerror();

                                }

                            }
                        })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                dialog.cancel();
                                System.exit(0);


                            }
                        });


        AlertDialog alertDialog = alertDialogBuilder.create();

        alertDialog.show();

    }
    public void ageerror()
    {
        new AlertDialog.Builder(context)
                .setTitle("18+")
                .setMessage("You must be over 18 to use this app")
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        System.exit(0);
                    }
                })
                .show();


    }
}