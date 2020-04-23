#How to get started: 

* Sign up for a Stripe account at stripe.com

* Set environment variables

        stripe_secret = (your Stripe secret key from developer settings in your Stripe account)
        webhook_secret = (webhook signing secret from stripe CLI listen, or just any string if not using webhooks)
    
* Create your products and price plans in Stripe

* Set private key and plan IDs from your Stripe account in resources/static/index.html

        //INSERT YOUR TEST KEY HERE
        const stripe = Stripe('pk_test_*********');
        
        ...
        !-- INSERT YOUR PLAN IDs HERE -->
        <button onclick=startPurchase('plan_********')>Kjøp månedsabonnement!</button>
        <button onclick=startPurchase('plan_********')>Kjøp årsabonnement!</button>
    
* Build with ./gradlew build

* Run with ./gradlew bootRun

* Go to http://localhost:8080

* Use card number 4242 4242 4242 for testing, any future date is valid, any three digits for CVC

* To test webhooks, you must install Stripe CLI

