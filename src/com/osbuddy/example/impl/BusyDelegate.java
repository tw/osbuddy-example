package com.osbuddy.example.impl;

import com.osbuddy.api.script.Delegate;

import static com.osbuddy.api.util.Utilities.random;

/**
 * @author rvbiljouw
 */
public class BusyDelegate extends Delegate {

    @Override
    public int handle() {
        // do some busy action or whatever..
        return 1000;
    }

}
