package com.osbuddy.example;

import com.osbuddy.api.APIBinding;
import com.osbuddy.api.script.StatefulScript;
import com.osbuddy.api.script.meta.ScriptManifest;
import com.osbuddy.example.impl.BusyDelegate;
import com.osbuddy.example.impl.DisorientedDelegate;
import com.osbuddy.example.impl.IdleDelegate;
import com.osbuddy.example.override.CustomAPIModule;

import static com.osbuddy.example.ExampleConstants.ACTION_AREA;
import static com.osbuddy.example.ExampleConstants.ACTION_RADIUS;

/**
 * @author rvbiljouw
 */
@ScriptManifest(
        name = "Example Script",
        author="Rick",
        category="Combat",
        description = "An example script that kills goblins."
)
@APIBinding(CustomAPIModule.class)
public class ExampleScript extends StatefulScript<ExampleState> {

    @Override
    public void onStart() {
        define(ExampleState.DISORIENTED, new DisorientedDelegate());
        define(ExampleState.IDLE, new IdleDelegate());
        define(ExampleState.BUSY, new BusyDelegate());
    }

    @Override
    public ExampleState determine() {
        if(player.isIdle()) {
            if(player.distanceTo(ACTION_AREA) > ACTION_RADIUS) {
                return ExampleState.DISORIENTED;
            }
            return ExampleState.IDLE;
        }
        return ExampleState.BUSY;
    }

}
