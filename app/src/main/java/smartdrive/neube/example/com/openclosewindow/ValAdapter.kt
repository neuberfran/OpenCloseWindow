package smartdrive.neube.example.com.openclosewindow

import android.databinding.BindingAdapter
import android.graphics.drawable.Drawable
import android.support.annotation.NonNull
import android.widget.Button
import android.widget.TextView

class ValAdapter {

    companion object {


        @BindingAdapter("android:background")
        @JvmStatic
        fun setIntToDrawable(@NonNull button: Button, @NonNull anInt: Int) {
            button.background = button.context.getDrawable(anInt)
            //         textView.background =  anInt.toString()

        }

    }
}
