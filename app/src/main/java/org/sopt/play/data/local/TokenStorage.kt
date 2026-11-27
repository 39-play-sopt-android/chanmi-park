package org.sopt.play.data.local

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TokenStorage @Inject constructor() {
    var authorizationCode: String? = null
}
