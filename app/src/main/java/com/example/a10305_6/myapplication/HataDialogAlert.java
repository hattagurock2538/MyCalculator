package com.example.a10305_6.myapplication;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class HataDialogAlert {

    private AlertDialog.Builder objAlertDialog;

    public void HavespaceDialog(Context context) {
        objAlertDialog=new AlertDialog.Builder(context);
        // objAlertDialog.setIcon(R.drawable.icon1);
        objAlertDialog.setTitle("Have space");
        objAlertDialog.setMessage("Enter Temperature!!!");
        objAlertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        objAlertDialog.show();
    }


    public void ShowAnwer(Context context, String strTemperature, String strAnswer, String strTem) {
        objAlertDialog = new AlertDialog.Builder(context);
        // objAlertDialog.setIcon(R.drawable.);
        objAlertDialog.setTitle("Temperature is");
        objAlertDialog.setMessage("Your Enter "+ strTemperature +"\n" + "Exchange Temperature to "+ strAnswer + " " + strTem);
        objAlertDialog.setCancelable(false);
        objAlertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        objAlertDialog.show();}
}