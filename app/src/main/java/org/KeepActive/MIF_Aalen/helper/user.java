package org.KeepActive.MIF_Aalen.helper;

/**
 * Created by virgile on 16.12.2016.
 */
import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class user {

    public String name;
    public String email;

    // Default constructor required for calls to
    // DataSnapshot.getValue(ActivityObject_Json.class)
    public user() {
    }

    public user(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
