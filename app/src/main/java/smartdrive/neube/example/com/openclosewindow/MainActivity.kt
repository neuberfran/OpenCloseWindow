package smartdrive.neube.example.com.openclosewindow


import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewOutlineProvider
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main.*
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import kotlinx.android.synthetic.main.activity_main.*
import smartdrive.neube.example.com.openclosewindow.databinding.ActivityMainBinding
import java.util.logging.Logger

class MainActivity : AppCompatActivity()  {

    public var LOG = Logger.getLogger(this.javaClass.name)

    val db = FirebaseFirestore.getInstance()
    var janela1 = db.collection("smartmodel").document("motores")
    val pararRef = db.collection("smartmodel").document("motores")

    private val binding: ActivityMainBinding by lazy {

        DataBindingUtil.bind<ActivityMainBinding>(viewRoot)!!

    }

    private val viewModel: BackViewModel by lazy {
        ViewModelProviders.of(this).get(BackViewModel::class.java)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding.back1 = viewModel.back

        viewModel.updateDrawableResource()

        janela1.addSnapshotListener { snapshot,e ->

            if (e!=null) {
                Log.w(LOG.toString(),"Listen failed.",e)
                return@addSnapshotListener
            }

            var fcmotoruma=snapshot?.toObject(SmartModel::class.java)?.fcmotoruma

            Log.i(LOG.toString(),"a 9410 9410 9410" + fcmotoruma)
            if (fcmotoruma!!.equals(1)) {
                buttond1.background=getDrawable(R.mipmap.jesqpretae)
                buttond1.isEnabled=false
                buttonc.isEnabled=false
            } else if (fcmotoruma.equals(0)) {
                Log.i(LOG.toString(),"c 9412 9412 9412" + fcmotoruma)
                buttond1.isEnabled=true
                buttonc.isEnabled=true
            }

            Log.d(LOG.toString(),"Current data: ${snapshot?.data}")

            var PararUm=snapshot?.toObject(SmartModel::class.java)?.PararUm

            Log.i(LOG.toString(),"c 9413 9413 9413" + PararUm)

            if (PararUm!!.equals(1) && buttond1.isEnabled) {
                buttond1.background=getDrawable(R.mipmap.janelafrentee)
                buttonc.background=getDrawable(R.mipmap.stopbb)
            } else if (PararUm.equals(0) && buttond1.isEnabled) {
                Log.i(LOG.toString(),"c 9414 9414 9414" + PararUm)
                buttonc.background=getDrawable(R.mipmap.stopaa)
                buttond1.background=getDrawable(R.mipmap.jesqpretae)
            }

            buttond1.setOnClickListener {

                Log.d(LOG.toString(),"Current data: ${snapshot?.data}")

                var PararUm=snapshot?.toObject(SmartModel::class.java)?.PararUm

                Log.i(LOG.toString(),"c 94710 94710 94710" + PararUm)

                if (PararUm!!.equals(1)) {

                    var data=hashMapOf("DirecaoUm" to 1)

                    var data2=hashMapOf("PararUm" to 0)

                    Log.i(LOG.toString(),"c 94711 94711 94711" + PararUm)

                    db.collection("smartmodel").document("motores").set(data, SetOptions.merge())
                    db.collection("smartmodel").document("motores").set(data2, SetOptions.merge())

                    Log.i(LOG.toString(),"c 94712 94712 94712" + PararUm)
                }

            }

            buttonc.setOnClickListener {

                var data3=hashMapOf("PararUm" to 1)

                db.collection("smartmodel").document("motores").set(data3, SetOptions.merge())

                buttonc.background=getDrawable(R.mipmap.stopbb)

            }
        }
    }

    fun displayToast(context: Context = this, message: String, duration: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(context, message, duration).show()
    }
}



