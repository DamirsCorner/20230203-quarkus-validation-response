package org.example

import javax.validation.constraints.NotBlank

class Person {
    @NotBlank
    var firstName: String? = null

    @NotBlank
    var lastName: String? = null

    var middleName: String? = null
}