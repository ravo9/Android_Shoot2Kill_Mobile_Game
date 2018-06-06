package development.dreamcatcher.shoot2killmobile;

import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;

public class GameActivity extends AppCompatActivity {

    private GameView gameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        hideSystemUI();

        Display display = getWindowManager().getDefaultDisplay();

        Point screenSize = new Point();
        display.getRealSize(screenSize);

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

                // 'Walk left' button
                if (x >= ControlElements.leftX && x < (ControlElements.leftX + ControlElements.movementButtonWidth)
                        && y >= ControlElements.leftY && y < (ControlElements.leftY + ControlElements.movementButtonWidth))
                    ControlElements.leftIsActive = true;

                // 'Walk right' button
                if (x >= ControlElements.rightX && x < (ControlElements.rightX + ControlElements.movementButtonWidth)
                        && y >= ControlElements.rightY && y < (ControlElements.rightY + ControlElements.movementButtonWidth))
                    ControlElements.rightIsActive = true;

                break;
            case MotionEvent.ACTION_UP:
                ControlElements.leftIsActive = false;
                ControlElements.rightIsActive = false;
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
