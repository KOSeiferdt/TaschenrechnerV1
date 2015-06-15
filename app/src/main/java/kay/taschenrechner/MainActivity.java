package kay.taschenrechner;

import android.app.Activity;
import android.content.Intent;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.OrientationEventListener;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

    private OrientationEventListener listener;
    public TextView ausgabeTextfeld;
    String a = "";
    String b= "";
    String operator = "";
    float result = 0;

    public void onClickB0 (final View cmd)
    {
        ausgabeTextfeld.setText(ausgabeTextfeld.getText()+"0");
    }

    public void onClickB1 (final View cmd)
    {
        ausgabeTextfeld.setText(ausgabeTextfeld.getText()+"1");
    }

    public void onClickB2 (final View cmd)
    {
        ausgabeTextfeld.setText(ausgabeTextfeld.getText()+"2");
    }

    public void onClickB3 (final View cmd)
    {
        ausgabeTextfeld.setText(ausgabeTextfeld.getText()+"3");
    }

    public void onClickB4 (final View cmd)
    {
        ausgabeTextfeld.setText(ausgabeTextfeld.getText()+"4");
    }

    public void onClickB5 (final View cmd)
    {
        ausgabeTextfeld.setText(ausgabeTextfeld.getText()+"5");
    }

    public void onClickB6 (final View cmd)
    {
        ausgabeTextfeld.setText(ausgabeTextfeld.getText()+"6");
    }

    public void onClickB7 (final View cmd)
    {
        ausgabeTextfeld.setText(ausgabeTextfeld.getText()+"7");
    }

    public void onClickB8 (final View cmd)
    {
        ausgabeTextfeld.setText(ausgabeTextfeld.getText()+"8");
    }

    public void onClickB9 (final View cmd)
    {
        ausgabeTextfeld.setText(ausgabeTextfeld.getText()+"9");
    }

    public void onClickClear (final View cmd)
    {
        ausgabeTextfeld.setText("");
    }

    public void onClickAdd (final View cmd)
    {
        operator = "add";
        ausgabeTextfeld.setText(ausgabeTextfeld.getText());
        a = String.valueOf(ausgabeTextfeld.getText());
        ausgabeTextfeld.setText("");
    }

    public void onClickSubstract (final View cmd)
    {
        operator = "substract";
        ausgabeTextfeld.setText(ausgabeTextfeld.getText());
        a = String.valueOf(ausgabeTextfeld.getText());
        ausgabeTextfeld.setText("");
    }

    public void onClickDivide (final View cmd)
    {
        operator ="divide";
        ausgabeTextfeld.setText(ausgabeTextfeld.getText());
        a = String.valueOf(ausgabeTextfeld.getText());
        ausgabeTextfeld.setText("");
    }

    public void onClickMultiply (final View cmd)
    {
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

    public void onClickDivX(final View cmd) {
        operator = "1/X";
        ausgabeTextfeld.setText(ausgabeTextfeld.getText());
        a = String.valueOf(ausgabeTextfeld.getText());
        ausgabeTextfeld.setText(String.valueOf(1 / Float.valueOf(a)));
    }



    public void onClickResult (final View cmd)
    {
        b = String.valueOf(ausgabeTextfeld.getText());

        if (operator.equals("add"))
        {
            result = Float.valueOf(a) + Float.valueOf(b);
        } else
        if (operator.equals("substract"))
        {
            result = Float.valueOf(a) - Float.valueOf(b);
        } else
        if (operator.equals("multiply"))
        {
            result = Float.valueOf(a) * Float.valueOf(b);
        }else
        if (operator.equals("divide"))
        {
            result = Float.valueOf(a) / Float.valueOf(b);
        }
        ausgabeTextfeld.setText(String.valueOf(result));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(ausgabeTextfeld == null) ausgabeTextfeld = (TextView)findViewById(R.id.txtausgabe);

        listener = new OrientationEventListener(this, SensorManager.SENSOR_DELAY_FASTEST) {
            @Override
            public void onOrientationChanged(int orientation) {
                if(/*(orientation >= 75  && orientation <= 105) ||*/ (orientation >= 255 && orientation <= 285))
                    changeOrientation();

            }
        };

        if (listener.canDetectOrientation()) {
            listener.enable();
        }

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    private void changeOrientation(){
        Intent i = new Intent(this, MainLandscape.class);
        startActivity(i);
    }

}
