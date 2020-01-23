<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <script src="https://www.paypal.com/sdk/js?client-id=AUuQsZ6W_kSfRMWY_JWNer6Ho-eU3XDcVAgce3CZYj8LhYJO4ZiL9AME6LMbWHPxGkbTVp3zHpoQudsR"></script>
    <script>
        paypal.Buttons({
            createOrder: function(data, actions) {
                return actions.order.create({
                    purchase_units: [{
                        amount: {
                            value: '0.01'
                        }
                    }]
                });
            },
            onApprove: function(data, actions) {
                return actions.order.capture().then(function(details) {
                    alert('Transaction completed by ' + details.payer.name.given_name);
                    console.log(window.location.hostname);
                    // Call your server to save the transaction
                    return fetch('completedpayment', {
                        method: 'post',
                        headers: {
                            'content-type': 'application/json'
                        },
                        body: JSON.stringify({
                            orderID: data.orderID,
                            userID: 1
                        })
                    });
                });
            }
        }).render('#paypal-button-container');
    </script>
</head>
<body>
    <div id="paypal-button-container"></div>
</body>
</html>
