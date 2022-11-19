package com.demo.amion_learningtask41;

import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText input1, input2, input3;
    String strNum1, strNum2, strNum3, strSum, resultMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCompute = (Button) findViewById(R.id.btnCompute);
        btnCompute.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        Toast.makeText(this, "Computing....", Toast.LENGTH_SHORT).show();
        ComputeResult();
    }

    public void ComputeResult(){
        input1 = (EditText) findViewById(R.id.input1);
        input2 = (EditText) findViewById(R.id.input2);
        if (input1.getText().toString().isEmpty() || input2.getText().toString().isEmpty()) {
            strNum1 = "0";
            strNum2 = "0";
        } else {
            strNum1 = input1.getText().toString();
            strNum2 = input2.getText().toString();
        }
        double rawNum1 = Double.parseDouble(strNum1);
        double rawNum2 = Double.parseDouble(strNum2);

        double sum = rawNum1 + rawNum2;
        strSum = String.valueOf(sum);

        input3 = (EditText) findViewById(R.id.input3);
        if(input3.getText().toString().isEmpty()){
            strNum3 = "0";
        }else{
            strNum3 = input3.getText().toString();
        }
        double rawNum3 = Double.parseDouble(strNum3);
        double rawSum = Double.parseDouble(strSum);

        double result = rawNum3 * rawSum;
        resultMessage = "Your first input is "+(double) rawNum1 +" and your second input is "+(double) rawNum2 +" . " +'\n' + '\n'  + "(Step 1:) " +(double) rawNum1 +" + " +(double) rawNum2 +" = " +(double) rawSum +'\n' + '\n'
                + "Their sum is "+(double)rawSum +" ." +'\n' +'\n' + "You entered " +(double)rawNum3+ " to be multiplied with the sum."+'\n'+'\n' +"(Step 2:) " +(double) rawSum +" x " +(double) rawNum3 +" = " +(double) result +'\n' + '\n'+"Their product is " +(double) result;

        // Create Bundle instance, this will allow transfer of data from Activity to DialogFragment
        Bundle args = new Bundle();
        args.putString("result", resultMessage);

        // Create a dialog instance
        DialogFragmentCustom dialogFragmentImp = new DialogFragmentCustom();
        // Pass on dialog argument(args), the result
        dialogFragmentImp.setArguments(args);
        // Display the Dialog
        dialogFragmentImp.show(getSupportFragmentManager(),"Display Result");
        // Reset EditTexts
        clearEditText();
    }
    public void clearEditText(){
        input1.getText().clear();
        input2.getText().clear();
        input3.getText().clear();
        input1.requestFocus();
    }
    public double ToDecimal(double nbr){
        nbr = nbr/100;
        return nbr;
    }
}

