package smartdrive.neube.example.com.openclosewindow

import android.content.Context
import androidx.lifecycle.ViewModel


class BackViewModel : ViewModel() {

    val back = Back()

    val partfirebase = Fireback().imageId()

    fun updateDrawableResource(){

        back.mDrawableResource=partfirebase


    }

}
