package farid.example.com.retrofitrecyclerview.Helper;

import android.widget.EditText;

/**
 * Created by Farid on 20/04/2017.
 */

public class Helpernya {


    public static boolean isEmpty(EditText editText){
        if(editText.getText().toString().trim().length() > 0){
            return false;
        }else {
            return true;
        }

    }
}
