package development.dreamcatcher.shoot2killmobile;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;

public class ControlElements {

    private static int screenWidth;
    private static int screenHeight;
    public static int movementButtonWidth;

    private Bitmap movementButtonTexture;

    public static int leftX;
    public static int leftY;

    public static boolean leftIsActive;
    public static boolean rightIsActive;

    public static int rightX;
    public static int rightY;

    static {

        screenWidth = GameView.screenSize.x;
        screenHeight =  GameView.screenSize.y;

        movementButtonWidth = (int)(screenWidth * 0.09 );

        leftX = (int)(screenWidth * 0.15);
        leftY = (int)(screenHeight * 0.78);

        rightX = (int)(screenWidth * 0.85 - movementButtonWidth);
        rightY = (int)(screenHeight * 0.78);

        leftIsActive = false;
        rightIsActive = false;
    }

    ControlElements(Context context) {

        movementButtonTexture = BitmapFactory.decodeResource(context.getResources(), R.drawable.movement_button);
        movementButtonTexture = Bitmap.createScaledBitmap(movementButtonTexture, movementButtonWidth, movementButtonWidth, false);
    }

    public void update(){

        if (leftIsActive && rightIsActive);
        else if (leftIsActive)
            GameView.player.walkLeft();
        else if (rightIsActive)
            GameView.player.walkRight();
    }

    public Bitmap getMovementButtonTexture() {
        return movementButtonTexture;
    }

    public int getLeftX() {
        return leftX;
    }

    public int getLeftY() {
        return leftY;
    }

    public int getRightX() {
        return rightX;
    }

    public int getRightY() {
        return rightY;
    }
}
