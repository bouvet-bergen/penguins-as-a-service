#How to get started: 

* Sign up for a Stripe account at stripe.com

* Set environment variables

        stripe_secret = (your Stripe secret key from developer settings in your Stripe account)
        webhook_secret = (webhook signing secret from stripe CLI listen )
    
* Create your products and price plans in Stripe

* Set private key and plan IDs from your Stripe account in resources/static/index.html
    
* Build with ./gradlew build
* Run with ./gradlew bootRun

* http://localhost:8080

