package com.indysoft.amazingtetris;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.widget.LinearLayout;


public class GameActivity extends Activity {

    int[][] gameMatrix;
    final int NUM_ROWS = 20;
    final int NUM_COLUMNS = 12;
    final int BOARD_HEIGHT = 800;
    final int BOARD_WIDTH = 480;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        GameInit();

    }

    void GameInit() {
        gameMatrix = new int[NUM_ROWS][NUM_COLUMNS];

        Bitmap bg = Bitmap.createBitmap(BOARD_WIDTH, BOARD_HEIGHT, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bg);
        Paint paint = new Paint();

        paint.setColor(Color.BLACK);
        canvas.drawRect(0, 0, BOARD_WIDTH, BOARD_HEIGHT, paint);

        paint.setColor(Color.WHITE);
        for (int i = 0; i <= NUM_ROWS; ++i) {
            canvas.drawLine(0, i * (BOARD_HEIGHT / NUM_ROWS), BOARD_WIDTH, i * (BOARD_HEIGHT / NUM_ROWS), paint);
        }
        for (int i = 0; i <= NUM_COLUMNS; ++i) {
            canvas.drawLine(i * (BOARD_WIDTH / NUM_COLUMNS), 0, i * (BOARD_WIDTH / NUM_COLUMNS), BOARD_HEIGHT, paint);
        }


        LinearLayout ll = (LinearLayout) findViewById(R.id.game_board);
        ll.setBackgroundDrawable(new BitmapDrawable(bg));
    }
}
