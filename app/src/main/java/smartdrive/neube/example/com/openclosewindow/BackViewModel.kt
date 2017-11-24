package smartdrive.neube.example.com.openclosewindow

import android.arch.lifecycle.ViewModel
import android.content.Context


class BackViewModel : ViewModel() {

    val back = Back()

    val partfirebase = Fireback().imageId()

    fun updateDrawableResource(){

        back.mDrawableResource=partfirebase


    }

}
