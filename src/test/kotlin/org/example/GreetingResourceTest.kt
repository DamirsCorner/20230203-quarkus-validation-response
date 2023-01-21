package org.example

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.notNullValue
import org.junit.jupiter.api.Test

@QuarkusTest
class GreetingResourceTest {

    @Test
    fun testAutoEndpoint() {
        given()
            .contentType("application/json")
            .body("{}")
        .`when`()
            .post("/hello/auto")
        .then()
            .statusCode(400)
            .body("title", `is`("Constraint Violation"))
            .body("status", `is`(400))
            .body("violations.size()", `is`(2))
    }

    @Test
    fun testManualEndpoint() {
        given()
            .contentType("application/json")
            .body("{}")
        .`when`()
            .post("/hello/manual")
        .then()
            .statusCode(500)
            .body("details", notNullValue())
    }

}