package com.example.data.repositories.main

import com.example.data.api.Api
import com.example.data.utils.errorResponse
import com.example.data.utils.successResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.example.domain.exception.Failure
import com.example.domain.interactors.main.MainInteractor
import com.example.domain.models.*
import com.example.domain.repositories.main.MainRepository
import com.example.domain.utils.Either

class MainRepositoryImpl(
    private val api: Api
) : MainRepository {

    /**
     * Perform API call to getData
     *
     * @param section - by default is all-sections
     * @param period - by default its 7
     * @return - ResponseFromApi
     */
    override suspend fun getData(
        section: String,
        period: String
    ): Either<Failure, ResponseFromApi> {
        return withContext(Dispatchers.IO) {
            try {
                val response = api.getData(section,period).execute()

                when(response.isSuccessful){
                    false -> Either.Left(response.errorResponse())
                    true -> Either.Right(response.successResponse())
                }

            } catch (e: Exception) {
                Either.Left(Failure.UnknownError)
            }
        }
    }
}