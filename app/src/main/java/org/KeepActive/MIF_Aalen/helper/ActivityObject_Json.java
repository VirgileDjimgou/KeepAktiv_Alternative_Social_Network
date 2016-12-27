package org.KeepActive.MIF_Aalen.helper;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by Ravi Tamada on 07/10/16.
 * www.androidhive.info
 */

@IgnoreExtraProperties
public class ActivityObject_Json {


    public String Activity_Name;
    public String Activity_Type;
    public String Activity_Description;
    public String Activity_Created_by;
    public String activity_Created_at;
    public String Street ;
    public int cityCode;
    public double LatCoord ;
    public double LonCoord ;

    // Default constructor required for calls to
    // DataSnapshot.getValue(ActivityObject_Json.class)


    public ActivityObject_Json(String activity_Name,
                               String activity_Type,
                               String activity_Description,
                               String activity_Created_by,
                               String activity_Created_at,
                               String street,
                               int cityCode,
                               double latCoord,
                               double lonCoord) {


        this.Activity_Name = activity_Name;
        this.Activity_Type = activity_Type;
        this.Activity_Description = activity_Description;
        this.Activity_Created_by = activity_Created_by;
        this.activity_Created_at = activity_Created_at;
        this.Street = street;
        this.cityCode = cityCode;
        this.LatCoord = latCoord;
        this.LonCoord = lonCoord;
    }


    public String getActivity_Name() {
        return Activity_Name;
    }

    public void setActivity_Name(String activity_Name) {
        Activity_Name = activity_Name;
    }

    public String getActivity_Type() {
        return Activity_Type;
    }

    public void setActivity_Type(String activity_Type) {
        Activity_Type = activity_Type;
    }

    public String getActivity_Description() {
        return Activity_Description;
    }

    public void setActivity_Description(String activity_Description) {
        Activity_Description = activity_Description;
    }

    public String getActivity_Created_by() {
        return Activity_Created_by;
    }

    public void setActivity_Created_by(String activity_Created_by) {
        Activity_Created_by = activity_Created_by;
    }

    public String getActivity_Created_at() {
        return activity_Created_at;
    }

    public void setActivity_Created_at(String activity_Created_at) {
        this.activity_Created_at = activity_Created_at;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public int getCityCode() {
        return cityCode;
    }

    public void setCityCode(int cityCode) {
        this.cityCode = cityCode;
    }

    public double getLatCoord() {
        return LatCoord;
    }

    public void setLatCoord(float latCoord) {
        LatCoord = latCoord;
    }

    public double getLonCoord() {
        return LonCoord;
    }

    public void setLonCoord(float lonCoord) {
        LonCoord = lonCoord;
    }
}
