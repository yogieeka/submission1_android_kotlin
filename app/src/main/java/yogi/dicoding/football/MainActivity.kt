package yogi.dicoding.football

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.Toast
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView
import yogi.dicoding.football.adapter.ClubAdapter
import yogi.dicoding.football.model.ClubData
import yogi.dicoding.football.ui.ClubDetailActivity

class MainActivity : AppCompatActivity() {

    var clubData: MutableList<ClubData> = mutableListOf()

    companion object {
        const val PARCELABLE_ITEM_DATA = "ItemData"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()

        verticalLayout {
            lparams(matchParent, matchParent)
            orientation = LinearLayout.VERTICAL

            relativeLayout {
                setBackgroundColor(Color.BLACK)

                textView {
                    setText("Football")
                    setTextSize(12f)
                    setTextColor(Color.WHITE)
                    gravity = Gravity.CENTER
                }.lparams(matchParent, matchParent)

            }.lparams(matchParent, dip(50))

            recyclerView {
                lparams(matchParent, matchParent)
                layoutManager = LinearLayoutManager(context)
                adapter = ClubAdapter(clubData) {
                    startActivity<ClubDetailActivity>(PARCELABLE_ITEM_DATA to it)
                    val toast = Toast.makeText(context, it.clubName, Toast.LENGTH_SHORT)
                    toast.show()
//                    snackbar(it.clubName!!)
                }
            }
        }
    }

    private fun initData() {
        val clubName = resources.getStringArray(R.array.club_name)
        val clubImage = resources.obtainTypedArray(R.array.club_image)
        val clubInfo = resources.getStringArray(R.array.club_info)

        clubData.clear()

        for (i in clubName.indices) {
            clubData.add(ClubData(clubName[i], clubInfo[i], clubImage.getResourceId(i, 0)))
        }
        Log.e("club Info ->", clubData.size.toString())

        clubImage.recycle()
    }

}
