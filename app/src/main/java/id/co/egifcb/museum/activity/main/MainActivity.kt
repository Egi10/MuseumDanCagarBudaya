package id.co.egifcb.museum.activity.main

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import id.co.egifcb.museum.R
import id.co.egifcb.museum.activity.cagarbudaya.CagarBudayaActivity
import id.co.egifcb.museum.activity.museum.MuseumActivity
import android.widget.Toast
import com.smarteist.autoimageslider.SliderLayout
import com.smarteist.autoimageslider.SliderView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), View.OnClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageSlider.setIndicatorAnimation(SliderLayout.Animations.SLIDE)
        imageSlider.scrollTimeInSec = 1

        setSliderViews()

        cv_cagar_budaya.setOnClickListener(this)
        cv_museum.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.cv_cagar_budaya -> {
                val intent = Intent(this, CagarBudayaActivity::class.java)
                startActivity(intent)
            }

            R.id.cv_museum -> {
                val intent = Intent(this, MuseumActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun setSliderViews() {

        for (i in 0..3) {

            val sliderView = SliderView(this)

            when (i) {
                0 -> {
                    sliderView.imageUrl = "https://2.bp.blogspot.com/-U_QGEo4nlRI/WBBCjNBb9aI/AAAAAAAACyA/rJuSKqnbclAkNDzgJKS45dnnozR3uXVEwCLcB/s1600/jam-gadang23.jpg"
//                    sliderView.setDescription("Jam Gadang")
                }

                1 -> {
                    sliderView.imageUrl = "https://assets.kompasiana.com/statics/crawl/55280cb26ea834801c8b4569.jpg?t=o&v=700"
//                    sliderView.setDescription("Benteng Portugis Pulau Cingkuak")
                }

                2 -> {
                    sliderView.imageUrl = "http://kakimelancong.com/wp-content/uploads/2015/11/istana-pagaruyung.jpg"
//                    sliderView.setDescription("Museum Istana Pagaruyung")
                }

                3 -> {
                    sliderView.imageUrl = "https://heritage.kai.id/media/DSC_0493%20ed.jpg?1505614871151"
//                    sliderView.setDescription("Museum Kereta Api Sawah Lunto")
                }
            }

            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP)

            //at last add this view in your layout :
            imageSlider.addSliderView(sliderView)
        }
    }
}
