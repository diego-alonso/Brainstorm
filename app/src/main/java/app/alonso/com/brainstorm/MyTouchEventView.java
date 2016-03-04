package app.alonso.com.brainstorm;

import android.app.ActionBar;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;
//import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.LinearLayout;
//import android.widget.LinearLayout;
import java.util.Random;

/**
 * Created by Diego Alonso on 2/28/2016.
 */
public class MyTouchEventView extends View {

    private Paint paint = new Paint();
    private Path path = new Path();
    private Paint circlePaint = new Paint();
    private Path circlePath = new Path();

    public Button buttonReset, buttonRandomColor;
    public ActionBar.LayoutParams params;

    LinearLayout parentLinearLayout;

    public MyTouchEventView(Context context) {
        super(context);

        params = new ActionBar.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        paint.setAntiAlias(true);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeWidth(5f);

        circlePaint.setAntiAlias(true);
        circlePaint.setColor(Color.BLUE);
        circlePaint.setStyle(Paint.Style.STROKE);
        circlePaint.setStrokeJoin(Paint.Join.MITER);
        circlePaint.setStrokeWidth(2f);

        // Linear Layout
        parentLinearLayout = new LinearLayout(context);

        // Buttons
        buttonReset = new Button(context);
        buttonReset.setText("Clear Screen");

        parentLinearLayout.addView(buttonReset);

        buttonReset.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                // Resets the screen
                path.reset();

                // Calls the onDraw() method
                postInvalidate();
            }
        });
    }

    @Override
    protected void onDraw(Canvas canvas) {

        canvas.drawPath(path, paint);
        canvas.drawPath(circlePath, circlePaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        // X and Y coordinates of the Event
        float x = event.getX();
        float y = event.getY();

        // Checks for the Event that occurs
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(x, y);

                return true;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(x, y);
                circlePath.reset();

                // Circle's center x-coordinate, y-coordinate, radius of the circle
                // direction to wind the shape
                circlePath.addCircle(x, y, 30, Path.Direction.CW);

                // circlePath.addRect(x - 25, y - 25
                break;

            case MotionEvent.ACTION_UP:
                circlePath.reset();

                break;

            default:
                return false;
        }

        // Schedules a repaint
        // Force a view to draw
        invalidate();
        return true;
    }

    @Override
    protected void onLayout(boolean change, int l, int t, int r, int b) {
        // TODO Auto-generated method stub

    }
}
