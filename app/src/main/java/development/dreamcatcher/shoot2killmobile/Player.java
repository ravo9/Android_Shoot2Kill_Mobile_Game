package development.dreamcatcher.shoot2killmobile;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Display;

public class Player {

    private static int screenWidth;
    private static int screenHeight;

    private static int characterWidth;
    private static int characterHeight;

    private static int stepDistance;

    private Bitmap playerTexture;

    private int x;
    private int y;

    static {

        screenWidth = GameView.screenSize.x;
        screenHeight = GameView.screenSize.y;

        characterWidth = (int)(screenWidth * 0.14 );
        characterHeight = (int)(characterWidth * 0.5);

        stepDistance = (int)(screenWidth * 0.006);
    }

    Player(Context context) {

        x = 675;
        y = 350;

        playerTexture = BitmapFactory.decodeResource(context.getResources(), R.drawable.simon_ar_15);
        playerTexture = Bitmap.createScaledBitmap(playerTexture, characterHeight, characterWidth, false);
    }

    public void update(){

    }

    public void walkLeft() { x -= stepDistance; }

    public void walkRight() { x += stepDistance; }

    public Bitmap getPlayerTexture() {
        return playerTexture;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
