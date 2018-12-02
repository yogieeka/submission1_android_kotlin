package yogi.dicoding.football.ui

import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout
import org.jetbrains.anko.*
import yogi.dicoding.football.util.dp

/**
 * Created by yogi on 12/2/18.
 */
class ClubUI : AnkoComponent<ViewGroup> {

    companion object {
        val club_image = 1
        val club_name = 2
    }

    override fun createView(ui: AnkoContext<ViewGroup>) = with(ui) {
        verticalLayout {
            orientation = LinearLayout.HORIZONTAL
            padding = dip(16)

            imageView {
                id = club_image
            }.lparams(width = 50.dp, height = 50.dp)

            textView {
                id = club_name
            }.lparams(wrapContent, wrapContent) {
                gravity = Gravity.CENTER_VERTICAL
                margin = dip(10)
            }
        }
    }
}