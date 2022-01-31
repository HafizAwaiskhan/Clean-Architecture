package com.example.domain.repositories.main

import com.example.domain.exception.Failure
import com.example.domain.models.*
import com.example.domain.utils.Either


interface MainRepository {

    suspend fun getData(section: String,
                        period: String
    ): Either<Failure, ResponseFromApi>

}