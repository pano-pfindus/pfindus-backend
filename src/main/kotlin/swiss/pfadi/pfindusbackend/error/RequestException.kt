package swiss.pfadi.pfindusbackend.error

import org.springframework.http.HttpStatus

class RequestException(
    override val message: String?,
    val statusCode: HttpStatus,
) : RuntimeException() {}
