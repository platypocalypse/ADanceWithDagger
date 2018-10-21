package example.android.com.adancewithdagger.data.repository

import example.android.com.adancewithdagger.data.model.HouseDto
import example.android.com.adancewithdagger.data.model.HouseDtoEntity
import example.android.com.adancewithdagger.data.transformer.HouseDtoTransformer
import io.realm.Realm
import timber.log.Timber
import java.lang.Exception
import java.util.function.Consumer
import javax.inject.Inject

class StoreHousesInRepo
    @Inject constructor(private val houseDtoTransformer: HouseDtoTransformer)
    : Consumer<List<HouseDto>> {

    override fun accept(dtos: List<HouseDto>) {
        val realm = Realm.getDefaultInstance()
        try {
            val entities: List<HouseDtoEntity> = dtos.map { houseDtoTransformer.apply(it) }
            realm.executeTransaction {
                it.copyToRealmOrUpdate(entities)
            }
        }
        catch (e: Exception) {
            Timber.e(e)
        }
    }
}