package org.KeepActive.MIF_Aalen.helper;

/**
 * Created by virgile on 27.12.2016.
 */

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.format.DateFormat;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.KeepActive.MIF_Aalen.R;
import org.KeepActive.MIF_Aalen.fragment.New_Activity_Fragment;


public class DateTimePicker extends AppCompatActivity {

    static int hour, min;

    public static TextView txtdate, txttime;
    Button btntimepicker, btndatepicker;

    java.sql.Time timeValue;
    SimpleDateFormat format;
    Calendar c;
    int year, month, day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datepicker);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        c = Calendar.getInstance();
        hour = c.get(Calendar.HOUR_OF_DAY);
        min = c.get(Calendar.MINUTE);

        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);

        txtdate = (TextView) findViewById(R.id.txtdate);
        txttime = (TextView) findViewById(R.id.txttime);

        btndatepicker = (Button) findViewById(R.id.btndatepicker);
        btntimepicker = (Button) findViewById(R.id.btntimepicker);

        btndatepicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get Current Date

                DatePickerDialog dd = new DatePickerDialog(DateTimePicker.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {

                                try {
                                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                                    String dateInString = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                                    Date date = formatter.parse(dateInString);
                                    String Date_to = formatter.format(date).toString();
                                    txtdate.setText(Date_to);
                                    // reset View
                                    New_Activity_Fragment.DateView.setText("");
                                    New_Activity_Fragment.DateView.setText(Date_to);

                                   /* formatter = new SimpleDateFormat("dd/MMM/yyyy");

                                    txtdate.setText(txtdate.getText().toString()+"\n"+formatter.format(date).toString());

                                    formatter = new SimpleDateFormat("dd-MM-yyyy");

                                    txtdate.setText(txtdate.getText().toString()+"\n"+formatter.format(date).toString());

                                    formatter = new SimpleDateFormat("dd.MMM.yyyy");

                                    txtdate.setText(txtdate.getText().toString()+"\n"+formatter.format(date).toString());

                                    */

                                } catch (Exception ex) {

                                }


                            }
                        }, year, month, day);
                dd.show();
            }
        });
        btntimepicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                TimePickerDialog td = new TimePickerDialog(DateTimePicker.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                try {
                                    String dtStart = String.valueOf(hourOfDay) + ":" + String.valueOf(minute);
                                    format = new SimpleDateFormat("HH:mm");

                                    timeValue = new java.sql.Time(format.parse(dtStart).getTime());
                                    txttime.setText(String.valueOf(timeValue));
                                    String Time_to = timeValue.toString();
                                    // Reset View
                                    New_Activity_Fragment.TimeView.setText("");
                                    New_Activity_Fragment.TimeView.setText(Time_to);
                                    // String amPm = hourOfDay % 12 + ":" + minute + " " + ((hourOfDay >= 12) ? "PM" : "AM");
                                    //txttime.setText(amPm + "\n" + String.valueOf(timeValue));
                                } catch (Exception ex) {
                                    txttime.setText(ex.getMessage().toString());
                                }
                            }
                        },
                        hour, min,
                        DateFormat.is24HourFormat(DateTimePicker.this)
                );
                td.show();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            // finish the activity
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
