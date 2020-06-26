package com.example.dialogfragmentdata;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

public class CustomDialogFragment extends DialogFragment {

    private Datable datable; //переменная интерфейса

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        datable=(Datable)context; //переменная интерфейса ссылается на объект класса (через контекст), который его реализует
    }

    public Dialog onCreateDialog(Bundle saveInstance){

        final String phone=getArguments().getString("phone");
        AlertDialog.Builder builder= new AlertDialog.Builder(getActivity());
        return builder
                .setTitle("Диалоговое окно")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setMessage("Вы хотите удалить" + phone +"?")
                .setPositiveButton("ОК", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        datable.remove(phone); //обращение к методу класса, который реализует интерфейс Datable
                    }
                })
                .setNegativeButton("Отмена", null)
                .create();


    }
}
