package no.bouvet.paas

import com.stripe.Stripe
import org.springframework.context.annotation.Configuration

@Configuration
class ApplicationConfig {

    init {
        Stripe.apiKey = System.getenv("stripe_secret")
    }

}