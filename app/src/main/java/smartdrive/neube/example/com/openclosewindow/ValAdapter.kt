package smartdrive.neube.example.com.openclosewindow

import android.graphics.drawable.Drawable
import android.widget.Button
import android.widget.TextView

class ValAdapter {

    companion object {


        @BindingAdapter("android:background")
        @JvmStatic
        fun setIntToDrawable(@androidx.annotation.NonNull button: Button, @androidx.annotation.NonNull anInt: Int) {
            button.background = button.context.getDrawable(anInt)
            //         textView.background =  anInt.toString()

        }

    }
}
