
package com.example.domain.exception

/**
 * Base Class for handling errors/failures/exceptions.
 * Every feature specific failure should extend [FeatureFailure] class.
 */
sealed class Failure {

    object NetworkError : Failure()
    object ServerError : Failure()
    object UnknownError : Failure()

    /** * Extend this class for feature specific failures.*/
    abstract class FeatureFailure : Failure()

    // General error with message
    class GeneralError(val message: String) : FeatureFailure()
}