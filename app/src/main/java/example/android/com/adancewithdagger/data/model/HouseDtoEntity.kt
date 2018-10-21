package example.android.com.adancewithdagger.data.model

import io.realm.RealmList
import io.realm.RealmObject

class HouseDtoEntity (
    var url: String? = null,
    var name: String? = null,
    var region: String? = null,
    var coatOfArms: String? = null,
    var words: String? = null,
    var titles: RealmList<String>? = null,
    var seats: RealmList<String>? = null,
    var currentLord: String? = null,
    var heir: String? = null,
    var overlord: String? = null,
    var founded: String? = null,
    var founder: String? = null,
    var diedOut: String? = null,
    var ancestralWeapons: RealmList<String>? = null,
    var cadetBranches: RealmList<String>? = null,
    var swornMembers: RealmList<String>? = null
) : RealmObject()