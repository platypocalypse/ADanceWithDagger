package example.android.com.adancewithdagger.data.repository

import example.android.com.adancewithdagger.data.model.HouseDto
import example.android.com.adancewithdagger.data.model.HouseDtoEntity
import example.android.com.adancewithdagger.data.transformer.HouseDtoEntityTransformer
import io.realm.Realm
import timber.log.Timber
import java.lang.Exception
import java.util.function.Function
import javax.inject.Inject

class GetHousesFromRepo
    @Inject constructor(private val houseDtoEntityTransformer: HouseDtoEntityTransformer)
    : Function<String, List<HouseDto>?> {

    override fun apply(term: String): List<HouseDto>? {
        val realm = Realm.getDefaultInstance()
        var houseDtos: List<HouseDto>? = null
        try {
            val entities: List<HouseDtoEntity> =
                realm.where(HouseDtoEntity::class.java)
                    .contains("name", term)
                    .findAll()

            houseDtos = entities.map{ houseDtoEntityTransformer.apply(it) }
        }
        catch (e: Exception) {
            Timber.e(e)
        }

        return houseDtos
    }
}