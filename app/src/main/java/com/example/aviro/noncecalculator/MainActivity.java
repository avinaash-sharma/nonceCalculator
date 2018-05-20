package com.example.aviro.noncecalculator;

import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.renderscript.Element;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;


import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import static android.util.Base64.encodeToString;

public class MainActivity extends AppCompatActivity {

    Button check, mine;
    TextView inputHash, inputValue, inputNonce,output;
    RelativeLayout relativeLayout;
    String hash, userValue, nonce;
    String finalValue, generatedHash;
    byte[]md5Input;
    BigInteger md5Data;
    String newString;
    String extractedHash;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        check = findViewById(R.id.check);
        mine = findViewById(R.id.mine);
        inputHash = findViewById(R.id.inputHash);
        inputValue = findViewById(R.id.inputValue);
        inputNonce = findViewById(R.id.inputNonce);
        relativeLayout = findViewById(R.id.relativeLayout);
        progressBar=findViewById(R.id.progressBar);
        output=findViewById(R.id.output);

    }

    public void check(View view) {
        hash = inputHash.getText().toString();
        userValue = inputValue.getText().toString();
        nonce = inputNonce.getText().toString();
        finalValue = hash + userValue + nonce;
        System.out.println("HASH---->>" + hash);
        System.out.println("userValue---->>" + userValue);
        System.out.println("Nonce---->>" + nonce);
        System.out.println("Final Value---->>" + finalValue);

        try {
            newString=md5.encryptMD5(finalValue.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Encoded Value===>>"+newString.toString().toLowerCase());
        output.setText(newString.toString().toLowerCase());
        extractedHash=newString.substring(0,4);
        if(extractedHash.equals("0000"))
        {
            relativeLayout.setBackgroundColor(Color.GREEN);
        }
        else
        {
            relativeLayout.setBackgroundColor(Color.RED);
        }
    }



    public void mine(View view)
    {
        mine.setText("Wait");
        mine.setEnabled(false);
        relativeLayout.setBackgroundColor(Color.RED);



        int i=0,j=0;
        Random rand=new Random();
        long longInteger=0;
        longInteger=rand.nextLong();

        if(longInteger<0)
        {
            longInteger=longInteger*-1;
        }
        hash = inputHash.getText().toString();
        userValue = inputValue.getText().toString();
        nonce=Long.toString(longInteger);
        finalValue=hash+userValue+nonce;
        System.out.println("Hash--->>"+hash);
        System.out.println("userValue--->>"+userValue);
        System.out.println("nonce====>"+nonce);
        System.out.println("Final Value--------->>"+finalValue);

        md5Data=null;
        try {
            newString=md5.encryptMD5(finalValue.getBytes());

        } catch (Exception e) {
            e.printStackTrace();
        }
        generatedHash=newString.toString().toLowerCase();
        System.out.println("Value--->>"+generatedHash);
        extractedHash=generatedHash.substring(0,4);
        if(extractedHash.equals("0000"))
        {
            i=1;
        }
        else
        {
            i=2;
        }
        while(i!=1)
        {

            longInteger=rand.nextLong();
            if(longInteger<0)
            {
                longInteger=longInteger*-1;
            }
            hash = inputHash.getText().toString();
            userValue = inputValue.getText().toString();
            nonce=Long.toString(longInteger);
            finalValue=hash+userValue+nonce;
            System.out.println("Hash--->>"+hash);
            System.out.println("userValue--->>"+userValue);
            System.out.println("long====>"+nonce);
            System.out.println("Final Value--------->>"+finalValue);



            try {
                newString=md5.encryptMD5(finalValue.getBytes());

            } catch (Exception e) {
                e.printStackTrace();
            }
            generatedHash=newString.toString().toLowerCase();
            System.out.println("Value--->>"+generatedHash);

            extractedHash=generatedHash.substring(0,4);
            if(extractedHash.equals("0000"))
            {
                i=1;
                inputNonce.setText(nonce.toString());
            }
            else
            {
                i=2;
            }
            System.out.println(j);
            j++;
        }
        output.setText("OutPut:"+generatedHash);
        progressBar.setVisibility(View.GONE);
        relativeLayout.setBackgroundColor(Color.GREEN);
        System.out.println("DDDONEEEEEE");



    }
}
