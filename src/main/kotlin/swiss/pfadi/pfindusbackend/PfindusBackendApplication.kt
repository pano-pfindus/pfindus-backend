package swiss.pfadi.pfindusbackend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PfindusBackendApplication

fun main(args: Array<String>) {
    runApplication<PfindusBackendApplication>(*args)
}
