package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pair;
import model.Product;
import persistence.DBManager;

public class Statistics extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("statistics.jsp");
//		mi ottengo l'array per ogni categoria
		ArrayList<Pair>ap1 = DBManager.getInstance().purchaseForCategory(1); 
		ArrayList<Pair>ap2 = DBManager.getInstance().purchaseForCategory(2); 
		ArrayList<Pair>ap3 = DBManager.getInstance().purchaseForCategory(3); 
		ArrayList<Pair>ap4 = DBManager.getInstance().purchaseForCategory(4); 
		
//		a questo punto devo per ogni array prendere l'id del prodotto che il numero di acquisti maggiore utilizzando quella speciale funzione sottocreata:
		int id1 = calcolateNumber(ap1); 
		int id2 = calcolateNumber(ap2);
		int id3 = calcolateNumber(ap3);
		int id4 = calcolateNumber(ap4);
		
//		a questo punto mi devo ottenere i vari oggetti in base a questi id in modo che io possa insomma poi fare dei set degli attributi di ognuno dei 4 oggetti 
		Product p1 = DBManager.getInstance().getProduct(id1);
		Product p2 = DBManager.getInstance().getProduct(id2);
		Product p3 = DBManager.getInstance().getProduct(id3);
		Product p4 = DBManager.getInstance().getProduct(id4);
		
// 		a questo punto setto i vari prodotti in modo da poterli riutilizzare nella jsp
		if(p1 != null) {  req.getSession().setAttribute("p1", p1); }
		if(p2 != null) {  req.getSession().setAttribute("p2", p2); }
		if(p3 != null) {  req.getSession().setAttribute("p3", p3); }
		if(p4 != null) {  req.getSession().setAttribute("p4", p4); }
		
//PARTE 2:--------------------------------------------------------------------------------------------------------------------------------
//		mi calcolo il numero di elementi acquistati per ogni categoria facendo le somme del secondo elemento per ogni array
		int numberOfSmartphone = calcolateSum(ap1);
		int numberOfLaptop = calcolateSum(ap2);
		int numberOfHardware = calcolateSum(ap3);
		int numberOfAccessories = calcolateSum(ap4);
		
//		ora li setto
		req.getSession().setAttribute("numberOfSmartphone", numberOfSmartphone);
		req.getSession().setAttribute("numberOfLaptop", numberOfLaptop);
		req.getSession().setAttribute("numberOfHardware", numberOfHardware);
		req.getSession().setAttribute("numberOfAccessories", numberOfAccessories);

//		per ogni categoria mi ottengo il numero
		req.getSession().setAttribute("priceSmartphone", calcolateTotalPrice(ap1));
		req.getSession().setAttribute("priceLaptop", calcolateTotalPrice(ap2));
		req.getSession().setAttribute("priceHardware", calcolateTotalPrice(ap3));
		req.getSession().setAttribute("priceAccessories", calcolateTotalPrice(ap4));
		
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
	
	private int calcolateNumber(ArrayList<Pair>p) //questa funzione mi restituisce l'id del prodotto che nell'array passato come parametro ha piu acquisti
	{
		int idMax = 0;
		int sumMax = 0;
		
		for(int i = 0; i<p.size(); i++)
		{
			if(p.get(i).getSumNumber()>sumMax)
			{
				idMax = p.get(i).getIdProduct();
				sumMax = p.get(i).getSumNumber();
			}
		}
		
		return idMax;
	}
	
	private int calcolateSum(ArrayList<Pair>p)
	{
		int sum = 0;
		for(int i = 0; i<p.size(); i++)
		{
			sum+=p.get(i).getSumNumber();
		}
		
		return sum;
	}
	
	private int calcolateTotalPrice(ArrayList<Pair>p) {
		int sum = 0;
		for(int i = 0; i<p.size(); i++)
		{
			Product temp = DBManager.getInstance().getProduct(p.get(i).getIdProduct()); //mi ottengo il prodotto
			sum+=temp.getPrice();
		}
		return sum;
	}
}
