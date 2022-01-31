package com.example.domain.interactors.main

import com.example.domain.exception.Failure
import com.example.domain.interactors.BaseInteractor
import com.example.domain.models.ResponseFromApi
import com.example.domain.repositories.main.MainRepository
import com.example.domain.utils.Either
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MainInteractor(
    private val mainRepository: MainRepository
) : BaseInteractor() {

    suspend fun getData(section :String , period : String) : Either<Failure, ResponseFromApi> {
        return withContext(Dispatchers.Default) {
            when (val result = mainRepository.getData(section,period)) {
                is Either.Left -> Either.Left(result.a)
                is Either.Right -> Either.Right(result.b)
            }
        }
    }
}