package org.KeepActive.MIF_Aalen.RealtimeFirebase;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by Ravi Tamada on 07/10/16.
 * www.androidhive.info
 */

@IgnoreExtraProperties
public class ActivityObject {

    public String name;
    public String email;

    // Default constructor required for calls to
    // DataSnapshot.getValue(ActivityObject_Json.class)
    public ActivityObject() {
    }

    public ActivityObject(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
