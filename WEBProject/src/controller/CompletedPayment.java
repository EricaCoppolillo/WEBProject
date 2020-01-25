package controller;
import com.google.gson.Gson;
import model.PayPalOrder;
import persistence.DBManager;
import technicalServices.GetOrder;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Date;

public class CompletedPayment extends HttpServlet {

    Gson gson = new Gson();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response){

        StringBuffer input = new StringBuffer();
        boolean completed = false;

        try {
            BufferedReader bufferedReader = request.getReader();
            String line = bufferedReader.readLine();
            while (line != null){
                input.append(line);
                line = bufferedReader.readLine();
            }

            PayPalOrder payPalOrder = gson.fromJson(input.toString(), PayPalOrder.class);
            GetOrder getOrder = new GetOrder();
            String paymentId = getOrder.getOrder(payPalOrder.getOrderID());
            if(!paymentId.equals("-1")){
                if(DBManager.getInstance().insertPayment(payPalOrder.getAmount(), paymentId)){
                    int paymentCode = DBManager.getInstance().getPaymentId(paymentId);
                    if(DBManager.getInstance().insertPurchase(payPalOrder.getUserID(), paymentCode,
                            payPalOrder.getAddress())){
                        int purchaseId = DBManager.getInstance().getPurchaseId(paymentCode);
                        int[] quantities = payPalOrder.getProductsQuantity();
                        int[] products = payPalOrder.getProducts();
                        for (int i = 0; i < products.length; i++) {
                            DBManager.getInstance().insertPurchaseProductAssociation(quantities[i], products[i], purchaseId);
                        }

                        DBManager.getInstance().deleteAllCartProducts(payPalOrder.getUserID());
                        completed = true;
                    }
                }
            }

            if(completed)
                response.getOutputStream().print(1);
            else
                response.getOutputStream().print(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
