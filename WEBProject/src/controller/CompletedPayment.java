package controller;
import com.google.gson.Gson;
import model.PayPalOrder;
import technicalServices.GetOrder;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

public class CompletedPayment extends HttpServlet {

    Gson gson = new Gson();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response){

        StringBuffer input = new StringBuffer();

        try {
            BufferedReader bufferedReader = request.getReader();
            String line = bufferedReader.readLine();
            while (line != null){
                input.append(line);
                line = bufferedReader.readLine();
            }

            PayPalOrder payPalOrder = gson.fromJson(input.toString(), PayPalOrder.class);
            GetOrder getOrder = new GetOrder();

            if(getOrder.getOrder(payPalOrder.getOrderID()))
                System.out.println("L'utente " + payPalOrder.getUserID() + " ha completato l'acquisto");
            else
                System.out.println("L'utente " + payPalOrder.getUserID() + " non ha completato l'acquisto");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
