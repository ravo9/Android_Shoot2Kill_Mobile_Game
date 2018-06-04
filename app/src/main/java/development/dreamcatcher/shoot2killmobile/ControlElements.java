package development.dreamcatcher.shoot2killmobile;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.MotionEvent;

public class ControlElements {

    private static int screenWidth;
    private static int screenHeight;
    public static int movementButtonWidth;

    private Bitmap movementButtonTexture;

    public static int leftX;
    public static int leftY;
    public static boolean leftIsActive;

    public static int rightX;
    public static int rightY;

    static {

        screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
        screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;
        movementButtonWidth = (int)(screenWidth * 0.12 );

        leftX = (int)(screenWidth * 0.15);
        leftY = (int)(screenHeight * 0.78);

        rightX = (int)(screenWidth * 0.85 - movementButtonWidth);
        rightY = (int)(screenHeight * 0.78);

        leftIsActive = false;
    }

    ControlElements(Context context) {

        movementButtonTexture = BitmapFactory.decodeResource(context.getResources(), R.drawable.movement_button);
        movementButtonTexture = Bitmap.createScaledBitmap(movementButtonTexture, movementButtonWidth, movementButtonWidth, false);
    }

    public void update(){

        if (leftIsActive)
            GameView.player.walkLeft();
    }

    public void onTouchEvent(MotionEvent event){
        int action = event.getAction();
        int x = (int)event.getX();  // or getRawX();
        int y = (int)event.getY();

        switch(action){
            case MotionEvent.ACTION_DOWN:
                if (x >= leftX && x < (leftX + movementButtonWidth)
                        && y >= leftY && y < (leftX + movementButtonWidth)) {
                    leftIsActive = true;
                }
                break;
            case MotionEvent.ACTION_UP:
               leftIsActive = false;
                break;
        }
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
