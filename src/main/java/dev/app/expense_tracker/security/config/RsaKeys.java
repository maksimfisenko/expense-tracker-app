package dev.app.expense_tracker.security.config;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

public record RsaKeys(
        RSAPublicKey rsaPublicKey,
        RSAPrivateKey rsaPrivateKey
) {
}
