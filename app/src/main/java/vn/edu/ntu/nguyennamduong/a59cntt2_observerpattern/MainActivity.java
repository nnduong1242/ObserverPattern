package vn.edu.ntu.nguyennamduong.a59cntt2_observerpattern;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity
        implements MyDateDialog.OnMyDateChangeListener {
    EditText editDate;
    ImageView imvDate;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addViews();
        addEvents();
    }
    private void addViews(){
        editDate = findViewById(R.id.edNgayDi);
        imvDate = findViewById(R.id.imvDate);
    }
    private void addEvents(){
        imvDate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                MyDateDialog dateDialog = new MyDateDialog(MainActivity.this)
                )
            }
        });
    }


    @Override
    public void dateUpdate(Calendar newDuate) {
        StringBuilder builder = new StringBuilder();
        builder.append(newDate.get(Calendar.DAY_OF_MONTH))
                .append("/")
                .append(newDate.get(Calendar.MONTH))
                .append("/")
                .append(newDate.get(Calendar.YEAR));
        editDate.setText(builder.toString());
    }
}
