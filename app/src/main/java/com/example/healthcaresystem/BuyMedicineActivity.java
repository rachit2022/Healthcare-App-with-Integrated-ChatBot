package com.example.healthcaresystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class BuyMedicineActivity extends AppCompatActivity {

    private String[][] packages={
            {"Uprise-D3 1000TU Capsule","","","","50"},
            {"HealthVit Chromium Picolinate 200mcg Capsule","","","","305"},
            {"Vitamin B Complex Capsules","","","","448"},
            {"Inlife Vitamin E Wheat Germ Oil Capsule","","","","539"},
            {"Dolo 650 Tablet","","","","30"},
            {"Crocin-650 Advance Tablet","","","","50"},
            {"Strepsils Medicated Lozenges for Sore Throat","","","","40"},
            {"Tata 1mg Calcium + Vitamin D3","","","","30"},
            {"Feronia -XT Tablet","","","","130"}
    };
    private String[] package_details={
            "Building and keeping the bones and teeth strong\n"+
                    "Reducing Fatigue/stress and muscular pains\n"+
                    "Boosing immunity and increasing resistance against infection",
            "Chromium is an essential trace minerals that plays an important role in helping insuline regulate blood glucose",
            "Provide relief from vitamin B deficiencies\n"+
                    "Helps in formation in red blood cells\n"+
                    "Maintain healthy nervous system",
            "It promotes health as well as skin benifit.\n"+
                    "It helps reduce skin blemish and pigmentation.\n"+
                    "It act as safegaurd the skin from the harsh UVA and UVB sun rays.",
            "Dolo 650 Tablet helps relieve pain and fever by blocking the releaase of certain chemical messengers responsible for fever and pain",
            "Helps relieve fever and bring down high temperature\n"+
                    "Suitable for people with a heart condition or high blood pressure",
            "Relieves the symptons of the bacterial throat infection and soothens the recovery process\n"+
                    "Provides a warm and comforting feeling during the sore thorat",
            "Reduces the risk of calcium deficiency, Rickets and Osteoporosis\n"+
                    "Promote mobility and flexibility of joints",
            "Helps to reduce the iron defficiency due to the chornic blood loss or low intake of iron"
    };

    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    ListView lst;
    Button btnBack,btnGoToCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine);

        lst=findViewById(R.id.listViewBMCart);
        btnBack=findViewById(R.id.buttonBMCartBack);
        btnGoToCart=findViewById(R.id.buttonBMCheckout);

        btnGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BuyMedicineActivity.this,CartBuyMedicineActivity.class));
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BuyMedicineActivity.this,HomeActivity.class));
            }
        });

        list =new ArrayList();
        for(int i=0;i<packages.length;i++){
            item=new HashMap<String,String>();
            item.put("line1",packages[i][0]);
            item.put("line2",packages[i][1]);
            item.put("line3",packages[i][2]);
            item.put("line4",packages[i][3]);
            item.put("line5","Total cost:"+packages[i][4]+"/-");
            list.add(item);
        }

        sa=new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[] {"line1","line2","line3","line4","line5"},
                new int[] {R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Intent it=new Intent(BuyMedicineActivity.this,BuyMedicineDetailsActivity.class);
                it.putExtra("text1",packages[i][0]);
                it.putExtra("text2",package_details[i]);
                it.putExtra("text3",packages[i][4]);
                startActivity(it);
            }
        });
    }
}