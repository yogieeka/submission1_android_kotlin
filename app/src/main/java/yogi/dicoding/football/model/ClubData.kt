package yogi.dicoding.football.model


/**
 * Created by yogi on 12/2/18.
 */
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ClubData(val clubName: String?, val clubInfo: String?, val clubLogo: Int?): Parcelable