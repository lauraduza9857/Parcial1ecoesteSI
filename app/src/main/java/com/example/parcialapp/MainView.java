package com.example.parcialapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.parcialapp.model.GroupModel;
import com.google.gson.Gson;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;

public class MainView extends AppCompatActivity {
    private Socket socket;
    private Writer writer;
    private int x;
    private int y;
    private EditText groupName;
    private EditText amount;
    private int r;
    private int g;
    private int b;
    private int[] color = new int[3];
    private Button btnBlue;
    private Button btnGreen;
    private Button btnRed;
    private Button create;
    private Button erase;
    private EditText pX;
    private EditText pY;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_view);
        r = 255;
        g = 0;
        b = 0;

        groupName =  findViewById(R.id.groupName);
        amount = findViewById(R.id.amount);
        pX = findViewById(R.id.posX);
        pY = findViewById(R.id.posY);
        btnBlue = findViewById(R.id.btnBlue);
        btnBlue.setOnClickListener((v)->{
            r = 0;
            g = 0;
            b = 255;
        });

        btnGreen = findViewById(R.id.btnGreen);
        btnGreen.setOnClickListener((v)->{

            r = 0;
            g = 255;
            b = 0;
        });

        btnRed = findViewById(R.id.buttonRed);
        btnRed.setOnClickListener((v)->{

            r = 255;
            g = 0;
            b = 0;
        });

        create = findViewById(R.id.btnCreate);
        create.setOnClickListener((v)->{
            if(groupName.getText().toString().equals("")||amount.getText().toString().equals("")
                    ||pX.getText().toString().equals("")||pY.getText().toString().equals("")){
                Toast.makeText(this, "llenar todos los campos", Toast.LENGTH_SHORT).show();
            } else{
                Gson gson = new Gson();

                int cant =  Integer.parseInt(amount.getText().toString());
                x =  Integer.parseInt(pX.getText().toString());
                y =  Integer.parseInt(pY.getText().toString());

                color[0]= r;
                color[1]= g;
                color[2]= b;

                GroupModel groupModel = new GroupModel(groupName.getText().toString(), cant, x,y,color);

                String json = gson.toJson(groupModel);
                msgController(json);
            }
        });

        erase = findViewById(R.id.btnErase);
        erase.setOnClickListener((v)->{
            msgController("Borrar");

        });

        create.setBackgroundColor(Color.DKGRAY);
        erase.setBackgroundColor(Color.DKGRAY);



        serverConfig();
    }

    public void serverConfig() {
        new Thread(
                ()->{
                    try {
                        // If you need change ip for conection then change this
                        socket = new Socket("10.0.2.2",5000);
                        OutputStream os = socket.getOutputStream();
                        OutputStreamWriter osw = new OutputStreamWriter(os);
                        writer = new BufferedWriter(osw);


                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }).start();
    }

    public void msgController(String msg){
        new Thread(()->{
            try {
                writer.write(msg+"\n");
                writer.flush();
            } catch (IOException e){
                e.printStackTrace();
            }
        }).start();
    }
}