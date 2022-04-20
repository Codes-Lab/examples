////////////////////////////////////////////////////////////////////////////////
//
// Created by AMundewal on 13.03.2022.
//
// Copyright (c) 2006 - 2022 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.example.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class People implements Serializable {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------
    //default serialVersion id
    private static final long serialVersionUID = 1L;

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------
    private List<Person> mPeople = new ArrayList<>();
    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    private People() {
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public List<Person> getPeople() {
        return mPeople;
    }

    public void addPerson(Person person) {
        mPeople.add(person);
    }

    public static class Builder {
        private static People Instance = new People();

        public List<Person> build() {
            return Instance.getPeople();
        }

        public Builder(String name, String[] email, String[] mobile, Address[] addresses) {
            final Person person = new Person(name, mobile, email, addresses);
            Instance.addPerson(person);
        }
    }
}
