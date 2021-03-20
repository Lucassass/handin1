package dk.sdu.mmmi.cbse.bullet;



import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

public class BulletPlugin implements IGamePluginService {

    private Entity bullet;

    public BulletPlugin() {

    }

    @Override
    public void start(GameData gameData, World world) {

        // Add entities to the world
        bullet = createBullet(gameData);
        world.addEntity(bullet);
    }

    private Entity createBullet(GameData gameData) {
        float deacceleration = 10;
        float acceleration = 200;
        float maxSpeed = 600;
        float rotationSpeed = 5;
        float x = gameData.getDisplayWidth() / 1;
        float y = gameData.getDisplayHeight() / 1;
        float radians = 3.1415f / 1;

        Entity bullet = new Bullet();
        bullet.add(new MovingPart(deacceleration, acceleration, maxSpeed, rotationSpeed));
        bullet.add(new PositionPart(x, y, radians));

        return bullet;
    }

    @Override
    public void stop(GameData gameData, World world) {
        // Remove entities
        world.removeEntity(bullet);
    }
}
