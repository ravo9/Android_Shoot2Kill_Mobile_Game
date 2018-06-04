package development.dreamcatcher.shoot2killmobile;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GameView extends SurfaceView implements Runnable {

    public static Player player;
    public static ControlElements controlElements;

    public static Point screenSize;

    private Paint paint;
    private Canvas canvas;
    private SurfaceHolder surfaceHolder;

    volatile boolean playing;
    private Thread gameThread = null;

    public GameView(Context context, Point screenSize) {
        super(context);

        this.screenSize = screenSize;

        surfaceHolder = getHolder();
        paint = new Paint();

        controlElements = new ControlElements((context));
        player = new Player(context);

        // Start the game using 'resume' method.
        resume();
    }

    @Override
    public void run() {
        while (playing) {

            update();
            draw();
            control();
        }
    }

    public void pause() {
        playing = false;
        try {
            gameThread.join();
        } catch (InterruptedException e) {
        }
    }

    public void resume() {
        playing = true;
        gameThread = new Thread(this);
        gameThread.start();
    }

    private void update() {

        player.update();
        controlElements.update();
    }

    private void draw() {

        if (surfaceHolder.getSurface().isValid()) {

            canvas = surfaceHolder.lockCanvas();

            canvas.drawColor(Color.WHITE);

            //Drawing the control elements
            canvas.drawBitmap(controlElements.getMovementButtonTexture(), controlElements.getLeftX(), controlElements.getLeftY(), paint);
            canvas.drawBitmap(controlElements.getMovementButtonTexture(), controlElements.getRightX(), controlElements.getRightY(), paint);

            //Drawing the player
            canvas.drawBitmap(player.getPlayerTexture(), player.getX(), player.getY(), paint);

            surfaceHolder.unlockCanvasAndPost(canvas);
        }
    }

    private void control() {
        try {
            gameThread.sleep(17);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
