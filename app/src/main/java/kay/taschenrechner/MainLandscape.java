package kay.taschenrechner;

import android.app.Activity;
import android.content.Intent;

import android.content.res.Configuration;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.OrientationEventListener;
import android.view.View;
import android.widget.TextView;


public class MainLandscape extends Activity {

    OrientationEventListener listener;
    public TextView ausgabeTextfeld;
    String a = "";
    String b = "";
    String operator = "";
    float result = 0;

    public void onClickB0(final View cmd) {
        ausgabeTextfeld.setText(ausgabeTextfeld.getText() + "0");
    }

    public void onClickB1(final View cmd) {
        ausgabeTextfeld.setText(ausgabeTextfeld.getText() + "1");
    }

    public void onClickB2(final View cmd) {
        ausgabeTextfeld.setText(ausgabeTextfeld.getText() + "2");
    }

    public void onClickB3(final View cmd) {
        ausgabeTextfeld.setText(ausgabeTextfeld.getText() + "3");
    }

    public void onClickB4(final View cmd) {
        ausgabeTextfeld.setText(ausgabeTextfeld.getText() + "4");
    }

    public void onClickB5(final View cmd) {
        ausgabeTextfeld.setText(ausgabeTextfeld.getText() + "5");
    }

    public void onClickB6(final View cmd) {
        ausgabeTextfeld.setText(ausgabeTextfeld.getText() + "6");
    }

    public void onClickB7(final View cmd) {
        ausgabeTextfeld.setText(ausgabeTextfeld.getText() + "7");
    }

    public void onClickB8(final View cmd) {
        ausgabeTextfeld.setText(ausgabeTextfeld.getText() + "8");
    }

    public void onClickB9(final View cmd) {
        ausgabeTextfeld.setText(ausgabeTextfeld.getText() + "9");
    }

    public void onClickB10(final View cmd) {
        ausgabeTextfeld.setText(ausgabeTextfeld.getText() + "10");
    }

    public void onClickB11(final View cmd) {
        ausgabeTextfeld.setText(ausgabeTextfeld.getText() + "11");
    }

    public void onClickB12(final View cmd) {
        ausgabeTextfeld.setText(ausgabeTextfeld.getText() + "12");
    }

    public void onClickB13(final View cmd) {
        ausgabeTextfeld.setText(ausgabeTextfeld.getText() + "13");
    }

    public void onClickB14(final View cmd) {
        ausgabeTextfeld.setText(ausgabeTextfeld.getText() + "14");
    }

    public void onClickB15(final View cmd) {
        ausgabeTextfeld.setText(ausgabeTextfeld.getText() + "15");
    }

    public void onClickClear(final View cmd) {
        ausgabeTextfeld.setText("");
    }

    public void onClickAdd(final View cmd) {
        operator = "add";
        ausgabeTextfeld.setText(ausgabeTextfeld.getText());
        a = String.valueOf(ausgabeTextfeld.getText());
        ausgabeTextfeld.setText("");
    }

    public void onClickSubstract(final View cmd) {
        operator = "substract";
        ausgabeTextfeld.setText(ausgabeTextfeld.getText());
        a = String.valueOf(ausgabeTextfeld.getText());
        ausgabeTextfeld.setText("");
    }

    public void onClickDivide(final View cmd) {
        operator = "divide";
        ausgabeTextfeld.setText(ausgabeTextfeld.getText());
        a = String.valueOf(ausgabeTextfeld.getText());
        ausgabeTextfeld.setText("");
    }

    public void onClickMultiply(final View cmd) {
        operator = "multiply";
        ausgabeTextfeld.setText(ausgabeTextfeld.getText());
        a = String.valueOf(ausgabeTextfeld.getText());
        ausgabeTextfeld.setText("");
    }

    public void onClickQuadX(final View cmd) {
        operator = "x²";
        ausgabeTextfeld.setText(ausgabeTextfeld.getText());
        a = String.valueOf(ausgabeTextfeld.getText());
        ausgabeTextfeld.setText(String.valueOf(Float.valueOf(a)*Float.valueOf(a)));
    }

    public void onClickResult(final View cmd) {
        b = String.valueOf(ausgabeTextfeld.getText());

        if (operator.equals("add")) {
            result = Float.valueOf(a) + Float.valueOf(b);
        } else if (operator.equals("substract")) {
            result = Float.valueOf(a) - Float.valueOf(b);
        } else if (operator.equals("multiply")) {
            result = Float.valueOf(a) * Float.valueOf(b);
        } else if (operator.equals("divide")) {
            result = Float.valueOf(a) / Float.valueOf(b);
        }
        ausgabeTextfeld.setText(String.valueOf(result));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_landscape);

        listener = new OrientationEventListener(this, SensorManager.SENSOR_DELAY_FASTEST) {
            @Override
            public void onOrientationChanged(int orientation) {
                if (orientation == 0 || orientation == 180)
                    changeOrientation();

            }
        };

        if (listener.canDetectOrientation() == true) {
            listener.enable();
        }
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_landscape, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void changeOrientation() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
