package com.osbuddy.example.override;

import com.osbuddy.api.MethodContext;
import com.osbuddy.api.impl.game.WalkingImpl;
import com.osbuddy.api.wrappers.Npc;
import com.osbuddy.api.wrappers.interaction.SceneNode;

/**
 * An example of how to override API methods.
 * @author rvbiljouw
 */
public class AlternativeWalking extends WalkingImpl {
    public AlternativeWalking(MethodContext ctx) {
        super(ctx);
    }

    @Override
    public void walk(SceneNode object) {
        if(object instanceof Npc && ((Npc)object).getName().equals("Goblin")) {
            System.out.println("Hi, we're walking to a goblin.");
        }
        super.walk(object);
    }

}
