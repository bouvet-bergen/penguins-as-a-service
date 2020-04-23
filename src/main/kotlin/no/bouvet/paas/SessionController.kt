package no.bouvet.paas

import com.stripe.model.checkout.Session
import com.stripe.param.checkout.SessionCreateParams
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import com.stripe.param.checkout.SessionCreateParams.SubscriptionData.Item.builder as SubscriptionItemBuilder
import com.stripe.param.checkout.SessionCreateParams.SubscriptionData.builder as SubscriptionDataBuilder
import com.stripe.param.checkout.SessionCreateParams.builder as SessionParamsBuilder

@RestController
class SessionController {

    @PostMapping(path = ["/createSession/{selectedPlan}"])
    fun createSession(@PathVariable(name = "selectedPlan") selectedPlan: String): String {

        val subscriptionData = SubscriptionDataBuilder()
                .addItem(SubscriptionItemBuilder()
                        .setPlan(selectedPlan)
                        .build())
                .build()

        val sessionFromStripe = Session.create(SessionParamsBuilder()
                .setSubscriptionData(subscriptionData)
                .addPaymentMethodType(SessionCreateParams.PaymentMethodType.CARD)
                .setSuccessUrl("http://localhost:8080/success.html")
                .setCancelUrl("http://localhost:8080/index.html")
                .setLocale(SessionCreateParams.Locale.NB)
                .build())

        return sessionFromStripe.id
    }
}