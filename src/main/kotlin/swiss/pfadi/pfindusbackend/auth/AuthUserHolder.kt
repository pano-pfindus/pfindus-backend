package swiss.pfadi.pfindusbackend.auth

import org.springframework.stereotype.Component
import org.springframework.web.context.annotation.SessionScope

@Component
@SessionScope
class AuthUserHolder(var user: Profile? = null) {
}
