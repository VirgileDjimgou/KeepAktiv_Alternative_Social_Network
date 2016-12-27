package org.KeepActive.MIF_Aalen.helper;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by Ravi Tamada on 07/10/16.
 * www.androidhive.info
 */

@IgnoreExtraProperties
public class ActivityObject_Json {


    private String Act_Name;
    private String Act_Type;
    private String Act_Description;
    private String Act_Created_by;
    private String Created_at;
    private String Act_Street ;
    private int cityCode;
    private double Act_LatCoord ;
    private double Act_LonCoord ;

    // Default constructor required for calls to
    // DataSnapshot.getValue(ActivityObject_Json.class)


    public ActivityObject_Json(String activity_Name,
                               String activity_Type,
                               String activity_Description,
                               String Created_by,
                               String Created_at,
                               String param_street,
                               int param_cityCode,
                               double param_latCoord,
                               double param_lonCoord) {


        this.Act_Name = activity_Name;
        this.Act_Type = activity_Type;
        this.Act_Description = activity_Description;
        this.Act_Created_by = Created_by;
        this.Created_at = Created_at;
        this.Act_Street = param_street;
        this.cityCode = cityCode;
        this.Act_LatCoord = param_latCoord;
        this.Act_LonCoord = param_lonCoord;
    }


    public String getActivity_Name() {
        return this.Act_Name;
    }

    public void setActivity_Name(String activity_Name) {
        this.Act_Name = activity_Name;
    }

    public String getActivity_Type() {
        return this.Act_Type;
    }

    public void setActivity_Type(String activity_Type) {
        this.Act_Type = activity_Type;
    }

    public String getActivity_Description() {
        return this.Act_Description;
    }

    public void setActivity_Description(String Description) {
        this.Act_Description = Description;
    }

    public String getActivity_Created_by() {
        return this.Act_Created_by;
    }

    public void setActivity_Created_by(String Created_by) {
        this.Act_Created_by = Created_by;
    }

    public String getActivity_Created_at() {
        return this.Created_at;
    }

    public void setActivity_Created_at(String Created_at) {
        this.Created_at = Created_at;
    }

    public String getStreet() {
        return this.Act_Street;
    }

    public void setStreet(String param_street) {
        this.Act_Street = param_street;
    }

    public int getCityCode() {
        return cityCode;
    }

    public void setCityCode(int cityCode) {
        this.cityCode = cityCode;
    }

    public double getLatCoord() {
        return this.Act_LatCoord;
    }

    public void setLatCoord(double param_latCoord) {
        this.Act_LatCoord = param_latCoord;
    }

    public double getLonCoord() {
        return this.Act_LonCoord;
    }

    public void setLonCoord(double param_lonCoord) {
        this.Act_LonCoord = param_lonCoord;
    }
}
