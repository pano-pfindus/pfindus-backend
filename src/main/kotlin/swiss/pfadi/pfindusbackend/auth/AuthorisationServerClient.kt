package swiss.pfadi.pfindusbackend.auth

import TokenRequest
import TokenResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader

@FeignClient(name = "tokenClient", url = "\${oauth.autorisationServerHost}")
interface AuthorisationServerClient {
    @PostMapping("\${oauth.tokenPath}")
    fun exchangeCode(
        @RequestHeader accept: String,
        @RequestBody tokenRequest: TokenRequest
    ): TokenResponse

    @GetMapping("\${oauth.profilePath}")
    fun getProfile(
        @RequestHeader(name = "X-Scope") xScope: String,
        @RequestHeader authorization: String
    ): Profile
}
