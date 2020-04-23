package no.bouvet.paas

import com.stripe.exception.SignatureVerificationException
import com.stripe.model.Event
import com.stripe.model.Invoice
import com.stripe.net.Webhook
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest

@RestController
class WebhookListener {

    val webhookSecret : String = System.getenv("webhook_secret")

    @PostMapping("/hendelser")
    fun handleEvent(@RequestBody json: String,
                    @RequestHeader("Stripe-Signature") signature: String,
                    request: HttpServletRequest) {
        try {
            val event = Webhook.constructEvent(json, signature, webhookSecret)

            if (event.type == "invoice.payment_succeeded") {
                val invoice = event.dataObjectDeserializer.`object`.get() as Invoice
                println("WEBHOOK EVENT: ${invoice.customerEmail} has paid ${invoice.amountPaid}!")
            }
        } catch (e: SignatureVerificationException) {
            //this event was not from Stripe!
        }
    }

}