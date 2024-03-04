package swiss.pfadi.pfindusbackend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class PfindusBackendApplication

fun main(args: Array<String>) {
    runApplication<PfindusBackendApplication>(*args)
}
