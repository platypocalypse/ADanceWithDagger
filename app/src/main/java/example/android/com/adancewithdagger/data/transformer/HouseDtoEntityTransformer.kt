package example.android.com.adancewithdagger.data.transformer

import example.android.com.adancewithdagger.data.model.HouseDto
import example.android.com.adancewithdagger.data.model.HouseDtoEntity
import java.util.function.Function
import javax.inject.Inject

class HouseDtoEntityTransformer
    @Inject constructor(): Function<HouseDtoEntity, HouseDto> {
    override fun apply(entity: HouseDtoEntity): HouseDto =
        HouseDto(
            entity.url,
            entity.name,
            entity.region,
            entity.coatOfArms,
            entity.words,
            entity.titles,
            entity.seats,
            entity.currentLord,
            entity.heir,
            entity.overlord,
            entity.founded,
            entity.founder,
            entity.diedOut,
            entity.ancestralWeapons,
            entity.cadetBranches,
            entity.swornMembers
        )
}