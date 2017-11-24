package smartdrive.neube.example.com.openclosewindow

import android.databinding.BaseObservable
import android.databinding.Bindable

class News : BaseObservable() {

    private val mFavorite: Boolean = false

    @Bindable
    fun isFavorite(): Boolean {
        return mFavorite
    }

    fun setFavorite(favorite: Boolean) {
        mFavorite = favorite
        notifyPropertyChanged(BR.favorite)
    }

}