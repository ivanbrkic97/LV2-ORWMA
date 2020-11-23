package dev.brkic.lv2_orwma;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import dev.brkic.lv2_orwma.adapters.StudentsAdapter;
import dev.brkic.lv2_orwma.common.RemoveClickListener;

public class MainActivity extends AppCompatActivity implements RemoveClickListener {

    private RecyclerView recyclerView;
    private StudentsAdapter adapter;
    private EditText nameEditTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupRecycler();
        setupRecyclerData();
        nameEditTextView = findViewById(R.id.nameEditTextView);
    }

    private  void setupRecycler()
    {
        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new StudentsAdapter(this);
        recyclerView.setAdapter(adapter);
    }

    public void setupRecyclerData()
    {
        List<String> data = new ArrayList<>();
        data.add(getText(R.string.student_one).toString());
        data.add(getText(R.string.student_two).toString());
        data.add(getText(R.string.student_three).toString());
        adapter.addData(data);
    }

    public void addCell(View view)
    {

        adapter.addNewCell(nameEditTextView.getText().toString(),adapter.getItemCount());
    }

    @Override
    public void onNameClick(int position)
    {
        adapter.removeCell(position);
    }
}