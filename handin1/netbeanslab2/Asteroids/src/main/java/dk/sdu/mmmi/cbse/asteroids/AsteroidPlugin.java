package dk.sdu.mmmi.cbse.asteroids;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

public class AsteroidPlugin implements IGamePluginService {
    
    final int astroidCount;
    
    private Entity[] astroids;
    
    public AsteroidPlugin(){
        this.astroidCount = 2;
        
    }
    @Override
    public void start(GameData gameData, World world) {
        astroids = new Entity[astroidCount];
        for (int i = 0; i < astroids.length; i++) {
            Entity astroid = createAstroid(gameData);
            astroids[i] = astroid;
            world.addEntity(astroid);
        }
    }

    /**
     *
     * @param gameData
     * @param world
     */
    @Override
    public void stop(GameData gameData, World world) {
        for (Entity astroid : astroids) {
            world.removeEntity(astroid);
        }
    }
    
    private Entity createAstroid(GameData gameData) {
        float deacceleration = 100;
        float acceleration = 600;
        float maxSpeed = 10000;
        float rotationSpeed = 5;
        float x = gameData.getDisplayWidth() / 2;
        float y = gameData.getDisplayHeight() / 2;
        float radians = 3.1415f / 2;
        
        Entity astroid = new Asteroid();
        astroid.add(new MovingPart(deacceleration, acceleration, maxSpeed, rotationSpeed));
        astroid.add(new PositionPart(x, y, radians));
        
        return astroid;
    }
}