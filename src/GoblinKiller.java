import com.osbuddy.api.script.IterativeScript;
import com.osbuddy.api.script.meta.ScriptManifest;
import com.osbuddy.api.util.Utilities;
import com.osbuddy.api.wrappers.Npc;
import com.osbuddy.api.wrappers.Tile;
import com.osbuddy.api.wrappers.interaction.Result;
import com.osbuddy.market.encode.AES;

import java.lang.reflect.Field;

/**
 * @author rvbiljouw
 */
@ScriptManifest(name = "Goblin Killer", category = "Combat", author = "Rick", version = 1.0, description = "Kills goblins in lumbridge. Includes deathwalk.")
public class GoblinKiller extends IterativeScript {
    private static final Tile tile = new Tile(3259, 3231);

    @Override
    public int loop() {
        try {
            System.out.println("fuck");
            if (!player.isIdle()) {
                System.out.println("Player is not idle! M: " + player.isMoving() + " | A: " + (player.getAnimation() > -1) + " | I: " + (player.isInteracting()));
                return Utilities.random(750, 1000);
            } else if (player.getTile().distanceTo(tile) > 22) {
                System.out.println("Distance to goblins is too damn high.");
                walking.walk(tile);
                return Utilities.random(750, 1000);
            }

            Npc goblin = npcs.find("Goblin")
                    .fighting(false)
                    .moving(false)
                    .canReach()
                    .single();
            if (goblin != null) {
                Result result = goblin.interact("Attack");
                switch (result) {
                    case NOT_ON_SCREEN:
                        System.out.println("Goblin is not on screen yo!");
                        walking.walk(goblin);
                        break;

                    default:
                        System.out.println(result);
                        return 600;
                }
            } else {
                System.out.println("No goblin found");
            }
            return 100;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 3413;
    }

}
