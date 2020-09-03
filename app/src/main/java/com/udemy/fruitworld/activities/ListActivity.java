package com.udemy.fruitworld.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.udemy.fruitworld.R;
import com.udemy.fruitworld.adapters.FruitAdapter;
import com.udemy.fruitworld.model.Fruit;

import java.io.Serializable;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    private ListView listView;
    private int counter = 0;
    private FruitAdapter fruitAdapter;
    private List<Fruit> fruits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Forzar y cargar icono en el action bar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher_fruit);

        setContentView(R.layout.list_activity);

        listView = (ListView) findViewById(R.id.listView);
        //Datos a mostrar

        Intent intent = getIntent();

        counter = intent.getIntExtra("COUNTER", 0);

        fruits = (List<Fruit>) intent.getSerializableExtra("FRUITS");

        if (fruits == null) {
            fruits = Fruit.buildFruitList();
        }

        fruitAdapter = new FruitAdapter(this, R.layout.list_item, fruits);
        listView.setAdapter(fruitAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(ListActivity.this, fruits.get(position).getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_bar_menu, menu);
        menu.getItem(1).setIcon(R.drawable.ic_view_module_white_36dp);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                this.fruits.add(new Fruit(String.format("Added # %s", ++counter), "Desconocido", R.drawable.ic_unknown, "Fruta desconocida"));
                this.fruitAdapter.notifyDataSetChanged();
                return true;
            case R.id.change_view:
                Intent intent = new Intent(ListActivity.this, GridActivity.class);
                intent.putExtra("FRUITS", (Serializable) fruits);
                intent.putExtra("COUNTER", counter);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}