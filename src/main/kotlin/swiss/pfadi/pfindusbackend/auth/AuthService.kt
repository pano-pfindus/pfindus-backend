package swiss.pfadi.pfindusbackend.auth

import TokenRequest
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.util.*


@Service
class AuthService(
    private val authorisationServerClient: AuthorisationServerClient,
    private val authUserHolder: AuthUserHolder
) {

    @Value("\${oauth.clientId}")
    private var clientId: String = "";

    @Value("\${oauth.clientSecret}")
    private var clientSecret: String = "";

    @Value("\${oauth.redirectUri}")
    private var redirectUri: String = "";


    fun login(code: String) {
        val dto = TokenRequest(
            "authorization_code",
            clientId,
            clientSecret,
            redirectUri,
            code
        )
        val response = authorisationServerClient.exchangeCode("application/json", dto);
        val profile = authorisationServerClient.getProfile("name", "Bearer ${response.accessToken}")
        authUserHolder.user = profile;
    }
}
