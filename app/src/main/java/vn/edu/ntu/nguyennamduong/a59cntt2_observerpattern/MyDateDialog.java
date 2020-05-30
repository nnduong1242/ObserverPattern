package vn.edu.ntu.nguyennamduong.a59cntt2_observerpattern;

import android.app.DatePickerDialog;
import android.content.Context;
import android.net.sip.SipSession;
import android.widget.DatePicker;

import java.util.Calendar;

public class MyDateDialog {
    Calendar calendar;
    OnMyDateChangeListener onMyDateChangeListener;
    Context context;

    public MyDateDialog(Calendar calendar, OnMyDateChangeListener onMyDateChangeListener, Context context) {
        this.calendar = calendar;
        this.onMyDateChangeListener = onMyDateChangeListener;
        this.context = context;
    }

    public void showDateDialog(){
        DatePickerDialog.OnDateSetListener Listener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(year, month, dayOfMonth);
                onMyDateChangeListener.dateUpdate(calendar);
            }
        };
        DatePickerDialog datePickerDialog = new DatePickerDialog(context, Listener,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
        );
    }

    public static interface OnMyDateChangeListener{
        public void dateUpdate(Calendar newDate);
    }
}
