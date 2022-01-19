package jp.ne.icchannel.backend

import jp.ne.icchannel.backend.config.SecurityConfig
import jp.ne.icchannel.backend.config.SessionConfig
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer

class SecurityInitializer :
    AbstractSecurityWebApplicationInitializer(SecurityConfig::class.java, SessionConfig::class.java) {
}