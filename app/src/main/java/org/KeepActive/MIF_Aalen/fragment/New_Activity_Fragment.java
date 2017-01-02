/**
 * Author: Djimgou Patrick Virgile
 * URL: http://virgiledjimgou.esy.es
 * Github https://github.com/chichikolon
 * */
package org.KeepActive.MIF_Aalen.fragment;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.KeepActive.MIF_Aalen.R;
import org.KeepActive.MIF_Aalen.app.LoginActivity;
import org.KeepActive.MIF_Aalen.app.MainActivity;
import org.KeepActive.MIF_Aalen.app.UserDashboard;
import org.KeepActive.MIF_Aalen.helper.ActivityObject_Json;
import org.KeepActive.MIF_Aalen.helper.DateTimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class New_Activity_Fragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private DrawerLayout drawer;

    private OnFragmentInteractionListener mListener;

    public New_Activity_Fragment() {
        // Required empty public constructor
    }

    private static final String TAG = New_Activity_Fragment.class.getSimpleName();
    EditText  Activity_Name;
    EditText  when ;
    EditText  where; // with custom Location Option
    EditText  Description ;
    public static TextView TimeView;
    public static TextView DateView;
    Button    Create_Activity;
    Button    ButtonDateTime;
    Button    ButtonTime ;
    private TextView txtDetails;
    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;
    private String userId;


    // TODO: Rename and change types and number of parameters
    public static New_Activity_Fragment newInstance(String param1, String param2) {
        New_Activity_Fragment fragment = new New_Activity_Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_neu_activity, container, false);
        Activity_Name = (EditText)view.findViewById(R.id.Activity_Name);
        //when = (EditText)view.findViewById(R.id.when);
        txtDetails = (TextView)view.findViewById(R.id.TextDetails) ;
        Create_Activity = (Button)view.findViewById(R.id.btn_save);
        DateView = (TextView) view.findViewById(R.id.DateView);
        TimeView = (TextView) view.findViewById(R.id.TimeView);

        ButtonDateTime = (Button)view.findViewById(R.id.Button_Date_Time);

        // diable Create Activity Button
        // User muss give all Information  in Fields to Create a Correcty Activity
        Create_Activity.setEnabled(false);

        ButtonDateTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentDateTime = new Intent(New_Activity_Fragment.this.getActivity(), DateTimePicker.class);
                startActivity(intentDateTime);
                // drawer.closeDrawers();

                // enable  Create Activity  Button
                Create_Activity.setEnabled(true);



            }
        });


        Create_Activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Act_name = Activity_Name.getText().toString();
                String Act_type = when.getText().toString();
                // startActivity(new Intent(MainActivity.this, UserDashboard.class));


                Toast.makeText(New_Activity_Fragment.this.getActivity() ,
                        "Create and save  new Activity on Firebase  Database ... !", Toast.LENGTH_LONG)
                        .show();
//

                // Check for already existed userId
                 if (TextUtils.isEmpty(userId)) {
                        userId = mFirebaseDatabase.push().getKey();
                    }

                    // ActivityObject activityObject = new ActivityObject(Act_Name, Act_Type);
                    ActivityObject_Json Object_zu_Senden = new ActivityObject_Json(
                            Act_name,
                            Act_type,
                            "Fake Description ...",
                            "Created by",
                            "Created at",
                            "Act_Street",
                            55,
                            33.56986f,
                            45.69898
                    );

                    mFirebaseDatabase.child(userId).setValue(Object_zu_Senden);

                    addUserChangeListener();

            }

        });
        toggleButton();


        // create of Firebase Instance
        mFirebaseInstance = FirebaseDatabase.getInstance();

        // get reference to 'users' node
        mFirebaseDatabase = mFirebaseInstance.getReference("Liste of Activities");

        // store app title to 'app_title' node
        mFirebaseInstance.getReference("app_title").setValue("Activities Realtime Database");

        // app_title change listener
        mFirebaseInstance.getReference("app_title").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.e(TAG, "App title updated");

                String appTitle = dataSnapshot.getValue(String.class);

                // update toolbar title
                // momentan nicht funktionfaghig mit Fragment ....
                // getSupportActionBar().setTitle(appTitle);
                Toast.makeText(New_Activity_Fragment.this.getActivity() ,
                        "Update apptitle !" + appTitle, Toast.LENGTH_LONG)
                        .show();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.e(TAG, "Failed to read app title value.", error.toException());
            }
        });


        return view ;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    /// firebase
    private void createUser(String Act_Name,
                            String Act_Type ,
                            String Act_Desc ,
                            String Act_Created_by ,
                            String Act_Created_at ,
                            String Act_Street ,
                            int Act_city_code ,
                            float latCoord ,
                            float lonCoord ) {
        // TODO
        // In real apps this userId should be fetched
        // by implementing firebase auth

    }


    // Changing button text
    private void toggleButton() {

    }

    /**
     * ActivityObject_Json data change listener
     */
    private void addUserChangeListener() {
        // ActivityObject_Json data change listener
        mFirebaseDatabase.child(userId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ActivityObject_Json Object_zu_Senden = dataSnapshot.getValue(ActivityObject_Json.class);


                // Check for null
                if (Object_zu_Senden == null) {
                    Log.e(TAG, "ActivityObject_Json data is null!");
                    return;
                }

                Log.e(TAG, "ActivityObject_Json data is changed!" + Object_zu_Senden.getActivity_Name() + ", " + Object_zu_Senden.getActivity_Type());

                // Display newly updated name and email
                txtDetails.setText(Object_zu_Senden.getActivity_Name() + ", " +Object_zu_Senden.getActivity_Type());

                // clear edit text
                Activity_Name.setText("");
                when.setText("");

                toggleButton();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.e(TAG, "Failed to read Activities ", error.toException());
            }
        });
    }

    private void updateUser(String name, String email) {
        // updating the user via child nodes
        if (!TextUtils.isEmpty(name))
            mFirebaseDatabase.child(userId).child("name").setValue(name);

        if (!TextUtils.isEmpty(email))
            mFirebaseDatabase.child(userId).child("email").setValue(email);
    }

}
