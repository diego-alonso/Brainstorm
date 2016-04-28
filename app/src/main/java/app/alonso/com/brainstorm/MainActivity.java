/*
 * Copyright (C) 2016
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package app.alonso.com.brainstorm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    // Variables for Drawing
    RelativeLayout relativeLayout;
    RelativeLayout.LayoutParams params;
    public Button buttonReset;
    public Button buttonRandomColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Buttons
        buttonReset = (Button) findViewById(R.id.buttonReset);
        buttonRandomColor = (Button) findViewById(R.id.buttonRandomColor);

        //For Drawing
        relativeLayout = (RelativeLayout) findViewById(R.id.parentRelativeLayout);
        params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        MyTouchEventView touch = new MyTouchEventView(this, buttonReset, buttonRandomColor);
        touch.setLayoutParams(params);
        relativeLayout.addView(touch);
    }

    @Override
    protected void onPause() {
        //TODO Auto-generated method stub
        super.onPause();
        finish();
    }
}
