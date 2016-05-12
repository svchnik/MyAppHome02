package com.example.nik.myapphome02;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class MainActivity extends Activity {
    public static final String T_STACK = "stackT";

    FragmentManager fragmentManager;
    FragmentR fragmentR;
    FragmentG fragmentG;
    FragmentB fragmentB;
    CheckBox checkBoxR;
    CheckBox checkBoxG;
    CheckBox checkBoxB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBoxR = (CheckBox) findViewById(R.id.checkbox1);
        checkBoxG = (CheckBox) findViewById(R.id.checkbox2);
        checkBoxB = (CheckBox) findViewById(R.id.checkbox3);
    }


    public void onClick(View v){
        fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        switch (v.getId()){
            case R.id.checkbox1:
                if (checkBoxR.isChecked()){
                    fragmentR = new FragmentR();
                    fragmentTransaction.add(R.id.fragmentcont,fragmentR);
                    fragmentTransaction.addToBackStack(T_STACK);
                }else {
                    fragmentTransaction.remove(fragmentR);
                }
                break;

            case R.id.checkbox2:
                if (checkBoxG.isChecked()){
                    fragmentG = new FragmentG();
                    fragmentTransaction.add(R.id.fragmentcont,fragmentG);
                    fragmentTransaction.addToBackStack(T_STACK);
                }else {
                    fragmentTransaction.remove(fragmentG);
                }
                break;
            case R.id.checkbox3:
                if (checkBoxB.isChecked()){
                    fragmentB = new FragmentB();
                    fragmentTransaction.add(R.id.fragmentcont,fragmentB);
                    fragmentTransaction.addToBackStack(T_STACK);
                }else {
                    fragmentTransaction.remove(fragmentB);
                }
                break;
        }
        fragmentTransaction.commit();
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();

        if(fragmentR != null) {
            if (getFragmentManager().findFragmentById(fragmentR.getId()) != null) {
                checkBoxR.setChecked(true);
            } else {
                checkBoxR.setChecked(false);
            }
        }

        if(fragmentG != null) {
            if (getFragmentManager().findFragmentById(fragmentG.getId()) != null) {
                checkBoxG.setChecked(true);
            } else {
                checkBoxG.setChecked(false);
            }
        }

        if(fragmentB != null) {
            if (getFragmentManager().findFragmentById(fragmentB.getId()) != null) {
                checkBoxB.setChecked(true);
            } else {
                checkBoxB.setChecked(false);
            }
        }

        if(!checkBoxR.isChecked()) {
            if(!checkBoxG.isChecked()) {
                if(!checkBoxB.isChecked()) {
                    fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                }
            }
        }

    }
}
