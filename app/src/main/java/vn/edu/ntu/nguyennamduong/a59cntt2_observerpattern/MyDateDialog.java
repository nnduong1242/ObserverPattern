package vn.edu.ntu.nguyennamduong.a59cntt2_observerpattern;

import android.app.DatePickerDialog;
import android.content.Context;
import android.net.sip.SipSession;
import android.widget.DatePicker;

import java.util.Calendar;

public class MyDateDialog {
    Context context;
    OnMyDateChangeListener onMyDateChangeListener;
    Calendar calendar;


    public MyDateDialog(Context context, OnMyDateChangeListener onMyDateChangeListener, Calendar calendar) {
        this.context = context;
        this.onMyDateChangeListener = onMyDateChangeListener;
        this.calendar = calendar;
    }

    public void showDateDialog(){
        DatePickerDialog.OnDateSetListener Listener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(year, month, dayOfMonth);
                if (onMyDateChangeListener != null) onMyDateChangeListener.dateUpdate(calendar);
            }
        };
        DatePickerDialog datePickerDialog = new DatePickerDialog(context, Listener,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
        );
        datePickerDialog.show();
    }

    public static interface OnMyDateChangeListener{
        public void dateUpdate(Calendar newDate);
    }
}
