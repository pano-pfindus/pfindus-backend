package swiss.pfadi.pfindusbackend.error

import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.resource.NoResourceFoundException

@ControllerAdvice
class GlobalExceptionHandler {

    private val log = LoggerFactory.getLogger(this.javaClass);

    @ExceptionHandler(RequestException::class)
    fun handleException(e: RequestException): ResponseEntity<String> {
        log.error("${e.message} \n{}", e.stackTrace)
        return ResponseEntity.status(e.statusCode)
            .body(e.message)
    }

    @ExceptionHandler(HttpMessageNotReadableException::class)
    fun handleException(ex: HttpMessageNotReadableException): ResponseEntity<String> {
        log.error("${ex.message} \n\n{}", ex.stackTrace)
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body("Could not deserialize")
    }

    @ExceptionHandler(NoResourceFoundException::class)
    fun handleException(ex: NoResourceFoundException): ResponseEntity<String> {
        log.error("${ex.message} \n\n{}", ex.stackTrace)
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body("Path not found")
    }

    @ExceptionHandler(Exception::class)
    fun handleException(ex: Exception): ResponseEntity<String> {
        log.error("${ex.javaClass}: ${ex.message} \n\n{}", ex.stackTrace)
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body("Something went wrong.")
    }
}
