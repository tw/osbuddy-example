package com.osbuddy.example.impl;

import com.osbuddy.api.script.Delegate;

import static com.osbuddy.api.util.Utilities.random;
import static com.osbuddy.example.ExampleConstants.ACTION_AREA;

/**
 * @author rvbiljouw
 */
public class DisorientedDelegate extends Delegate {

    @Override
    public int handle() {
        walking.walk(ACTION_AREA);
        return random(300, 600);
    }

}
