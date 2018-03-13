package smartdrive.neube.example.com.openclosewindow

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.ViewOutlineProvider
import android.widget.Button
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main.*
import smartdrive.neube.example.com.openclosewindow.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()  {

    private val binding: ActivityMainBinding by lazy {

        DataBindingUtil.bind<ActivityMainBinding>(viewRoot)

    }

    private val viewModel: BackViewModel by lazy {
        ViewModelProviders.of(this).get(BackViewModel::class.java)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding.back = viewModel.back

        buttone1.setBackgroundResource(viewModel.back.mDrawableResource)

        buttone1.setOnClickListener { viewModel.updateDrawableResource()}

 //       val one: Button  = findViewById(R.id.buttone1)
//        val two: Button  = findViewById(R.id.buttond1)
//        val three: Button  = findViewById(R.id.buttonc)
//
//        val four: Button  = findViewById(R.id.buttone2)
//        val five: Button  = findViewById(R.id.buttond2)

 //        one.setOnClickListener(this)
//        two.setOnClickListener(this)
//        three.setOnClickListener(this)
//        four.setOnClickListener(this)
//        five.setOnClickListener(this)

    }

    /*
    val database = FirebaseDatabase.getInstance()
//      DatabaseReference ref = database.getReference();

     fun onClick(v: View) {

        when (v.id) {

            R.id.buttone1 -> {

                val ref = database.getReference("janeladireitaa")

                         v.setBackgroundResource(R.mipmap.jaesquerde);

     //           v.isSelected = true

                ref.setValue("1")
            }

  //          R.id.buttond1 ->

                //   ref.setValue("ON");

//                v.isSelected = true

//            R.id.buttonc ->

                //  ref.setValue("ON");

  //              v.isSelected = true

  //          R.id.buttone2 ->

                //    ref.setValue("ON");

    //            v.isSelected = true

      //      R.id.buttond2 ->

                //   ref.setValue("ON");

        //        v.isSelected = true
        }

    }
*/
}



