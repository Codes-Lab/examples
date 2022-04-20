////////////////////////////////////////////////////////////////////////////////
//
// Created by AMundewal on 13.03.2022.
//
// Copyright (c) 2006 - 2022 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.example.pojo;

import java.io.Serializable;

/**
 *
 */
public class Address implements Serializable {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------
    //default serialVersion id
    private static final long serialVersionUID = 1L;

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------
    private final String mStreet;
    private final int mHouseNumber;
    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    public Address(String street, int houseNumber) {
        mStreet = street;
        mHouseNumber = houseNumber;
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getStreet() {
        return mStreet;
    }

    public int getHouseNumber() {
        return mHouseNumber;
    }
}
