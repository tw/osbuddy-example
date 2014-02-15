package com.osbuddy.example.impl;

import com.osbuddy.api.collection.queries.NpcQuery;
import com.osbuddy.api.script.Delegate;
import com.osbuddy.api.wrappers.Npc;

import static com.osbuddy.api.util.Utilities.random;

/**
 * @author rvbiljouw
 */
public class IdleDelegate extends Delegate {
    @Override
    public int handle() {
        NpcQuery query = formulateQuery();
        if (query.exists()) {
            Npc target = query.single();
            switch (target.interact("Attack")) {
                case NOT_ON_SCREEN:
                    walking.walk(target);
                    return random(300, 600);

                case MISSED:
                case NOT_IN_MENU:
                    return 10; // quicky!

            }
        }
        return random(300, 600);
    }

    private NpcQuery formulateQuery() {
        return npcs.find("Goblin")
                .fighting(false)
                .canReach();
    }
}
