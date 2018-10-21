package example.android.com.adancewithdagger.data.transformer

import example.android.com.adancewithdagger.data.model.HouseDto
import example.android.com.adancewithdagger.data.model.HouseDtoEntity
import io.realm.RealmList
import java.util.function.Function
import javax.inject.Inject

class HouseDtoTransformer
    @Inject constructor(): Function<HouseDto, HouseDtoEntity> {

    override fun apply(houseDto: HouseDto): HouseDtoEntity =
        HouseDtoEntity().apply {
            url = houseDto.url
            name = houseDto.name
            region = houseDto.region
            coatOfArms = houseDto.coatOfArms
            words = houseDto.words
            titles  = RealmList<String>().apply { houseDto.titles }
            seats  = RealmList<String>().apply { houseDto.seats }
            currentLord = houseDto.currentLord
            heir = houseDto.heir
            overlord = houseDto.overlord
            founded = houseDto.founded
            founder = houseDto.founder
            diedOut = houseDto.diedOut
            ancestralWeapons  = RealmList<String>().apply { houseDto.ancestralWeapons}
            cadetBranches  = RealmList<String>().apply { houseDto.cadetBranches }
            swornMembers  = RealmList<String>().apply { houseDto.swornMembers }
        }
}