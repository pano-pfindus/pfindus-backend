package swiss.pfadi.pfindusbackend.auth

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import swiss.pfadi.pfindusbackend.model.LoginDto
import kotlin.math.log

@Controller
@CrossOrigin(origins = ["*"])
class AuthController(val authService: AuthService) {

    @PostMapping("/login")
    fun login(@RequestBody loginDto: LoginDto): ResponseEntity<Void> {
        authService.login(loginDto.code);
        return ResponseEntity.ok().build();
    }


}
