package tuomomees.Ex1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static ArrayList<String> carList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getCars();


        final ListView myListView = (ListView) findViewById(R.id.myListView);
        final ArrayAdapter<String> aa;
        aa = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, carList);
        myListView.setAdapter(aa);

        Button addCard = (Button) findViewById(R.id.button1);
        final EditText line = (EditText) findViewById(R.id.editText1);

        addCard.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String mark = line.getText().toString();
                carList.add(mark);
                myListView.setAdapter(aa);
            }
        });

        Button editCar = (Button) findViewById(R.id.button2);
        editCar.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View arg0) {
                myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> arg0, View v, int position, long arg3) {
                        String selectedCar = carList.get(position);
                        Toast.makeText(getApplicationContext(), "Car Selected : " + selectedCar, Toast.LENGTH_LONG).show();
                        line.setText(selectedCar);

                        Log.d("edit", "edit");
                    }
                });
            }
        });


        Button removeCar = (Button) findViewById(R.id.button3);
        removeCar.setOnClickListener(new Button.OnClickListener() {


            @Override
            public void onClick(View arg0) {
                myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String selectedCar = carList.get(position);
                        Toast.makeText(getApplicationContext(), "car selected to remove: " + selectedCar, Toast.LENGTH_LONG).show();
                        line.setText(selectedCar);
                    }
                });

                String mark = line.getText().toString();
                carList.remove(mark);
                myListView.setAdapter(aa);
            }
        });

        //
        Button secondActivity = (Button) findViewById(R.id.button4);
        secondActivity.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Second Activitry Selected: ", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                startActivity(intent);
            }
        });




    }

    //Kommentti
    private void getCars() {
        carList.add("AlfaRomeo");
        carList.add("BMW");
        carList.add("Corvette");
    }

    private void onButtonAddClicked(){

    }
}
