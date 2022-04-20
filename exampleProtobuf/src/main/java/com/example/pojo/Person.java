package com.example.pojo;

import java.io.Serializable;

/**
 *
 */
public class Person implements Serializable {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------
    //default serialVersion id
    private static final long serialVersionUID = 1L;

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------
    private final String mName;
    private final String[] mMobile;
    private final String[] mEmail;
    private final Address[] mAddress;
    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    public Person(String name, String[] mobile, String[] email, Address[] address) {
        mName = name;
        mMobile = mobile;
        mEmail = email;
        mAddress = address;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getName() {
        return mName;
    }

    public String[] getMobile() {
        return mMobile;
    }

    public String[] getEmail() {
        return mEmail;
    }

    public Address[] getAddress() {
        return mAddress;
    }
}
