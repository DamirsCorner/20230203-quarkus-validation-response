package org.example

import javax.validation.ConstraintViolationException
import javax.ws.rs.core.Response
import javax.ws.rs.ext.ExceptionMapper
import javax.ws.rs.ext.Provider

@Provider
class ConstraintViolationMapper: ExceptionMapper<ConstraintViolationException> {
    override fun toResponse(e: ConstraintViolationException): Response {
        val errorDetails = ValidationErrorDetails(
            "validation.failed",
            e.constraintViolations.map {
                PropertyValidationError(
                    it.propertyPath.toString(),
                    it.messageTemplate,
                    it.message
                )
            }
        )
        return Response.status(400).entity(errorDetails).build()
    }
}