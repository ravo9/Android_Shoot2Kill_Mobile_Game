package development.dreamcatcher.shoot2killmobile;

import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class GameActivity extends AppCompatActivity {

    private GameView gameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        hideSystemUI();

        Display display = getWindowManager().getDefaultDisplay();

        Point screenSize = new Point();
        display.getSize(screenSize);

        gameView = new GameView(this, screenSize);

        setContentView(gameView);
    }

    // Control Buttons Touch Events
    public boolean onTouchEvent(MotionEvent event){

        int action = event.getAction();

        int x = (int)event.getX();
        int y = (int)event.getY();

        switch(action){
            case MotionEvent.ACTION_DOWN:
                if (x >= ControlElements.leftX && x < (ControlElements.leftX + ControlElements.movementButtonWidth)
                        && y >= ControlElements.leftX && y < (ControlElements.leftX + ControlElements.movementButtonWidth))
                    //ControlElements.leftIsActive = true;
                    GameView.player.walkLeft();
                break;
            case MotionEvent.ACTION_UP:
                ControlElements.leftIsActive = false;
                break;
        }

        return true;
    }

    // These two methods are responsible for hiding and showing up the navigation bar (right side).
    private void hideSystemUI() {
        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
                        | View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
                        | View.SYSTEM_UI_FLAG_IMMERSIVE);
    }

    private void showSystemUI() {
        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }
}
