package example.android.com.adancewithdagger.domain

import example.android.com.adancewithdagger.data.model.HouseDto
import example.android.com.adancewithdagger.data.repository.GetHousesFromRepo
import java.util.function.Function
import javax.inject.Inject

class GetHousesForTermUseCase
    @Inject constructor(private val getHousesFromRepo: GetHousesFromRepo)
    : Function<String, List<HouseDto>?> {

    override fun apply(term: String): List<HouseDto>? = getHousesFromRepo.apply(term)
}