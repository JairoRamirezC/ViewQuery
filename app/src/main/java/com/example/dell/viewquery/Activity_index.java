package com.example.dell.viewquery;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class Activity_index extends AppCompatActivity{
    ListView noticias;
    String [] datos={"Samsung","Sony","Huawei","Motorola","Iphone 6","HTC","Windows Phone","Avio","Lenovo"};
    Button fra;
    Context context=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        floating_button();

        noticias=(ListView)findViewById(R.id.lv_1);
        ArrayAdapter<String> ada = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,datos);
        noticias.setAdapter(ada);
        noticias.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast msg=Toast.makeText(getApplicationContext(),"Posición "+position+1+" SmartPhone "+datos[position],Toast.LENGTH_SHORT);
                msg.setGravity(Gravity.CENTER,0,0);
                msg.setMargin(0,0);
                msg.show();
            }
        });

        fra=(Button)findViewById(R.id.btn_fragment);
        fra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder diag = new AlertDialog.Builder(context);
                diag.setTitle("Mensage")
                        .setMessage("Desea abrir la siguiente pagina")
                        .setPositiveButton("SI", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent pag_frag=new Intent(Activity_index.this,Activity_Fragments.class);
                                startActivity(pag_frag);
                            }
                        })
                        .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(Activity_index.this,"Sera luego",Toast.LENGTH_SHORT).show();
                            }
                        });
                diag.create().show();
            }
        });
    }

    public void floating_button(){
        FloatingActionButton mifloat = (FloatingActionButton) findViewById(R.id.btn_floating);
        mifloat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Activity_index.this,"Seleccionaste el FloatingActionButton", Toast.LENGTH_SHORT).show();
                /*Toast msj=Toast.makeText(Activity_index.this,"Seleccionaste el FloatingActionButton", Toast.LENGTH_SHORT);
                msj.setGravity(Gravity.CENTER,0,0);
                msj.show();*/
            }
        });
    }
}