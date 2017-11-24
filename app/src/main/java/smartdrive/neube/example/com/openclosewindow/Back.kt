package smartdrive.neube.example.com.openclosewindow

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.databinding.BindingAdapter
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Build
import android.support.annotation.ColorRes
import android.support.annotation.DrawableRes
import android.support.v4.content.ContextCompat
import android.view.View


class Back : BaseObservable() {

//    var mDrawableResource: Int? = R.mipmap.janelafrented
    var mDrawableResource: Int? = R.mipmap.jaesquerde
        @Bindable get
        set(value) {
            field = value
            notifyPropertyChanged(BR.mDrawableResource)
        }

    // here it notify to ui when value change now i am going by

//        private set //wait which repos
    var mColorResource: Int? = null
        private set
    var mColorValue: Int? = null
        private set
    lateinit var mDrawable: Drawable
        private set
    var mBitmap: Bitmap? = null
        private set

    private fun reset() {
        mDrawableResource = null
        mColorResource = null
        mColorValue = null
    }

    fun setDrawableResource(@DrawableRes drawableResource: Int) {
        reset()
        mDrawableResource = drawableResource
        notifyChange()
    }


    // i have notifychange here and
    fun setColorResource(@ColorRes colorResource: Int) {
        reset()
        mColorResource = colorResource
        notifyChange()
    }

    fun setColorValue(colorValue: Int) {
        reset()
        mColorValue = colorValue
        notifyChange()
    }

    fun setDrawable(drawable: Drawable) {
        mDrawable = drawable
        notifyChange()
    }

    fun setBitmap(bitmap: Bitmap) {
        reset()
        mBitmap = bitmap
        notifyChange()
    }

    fun clear() {
        reset()
        notifyChange()
    }
}
