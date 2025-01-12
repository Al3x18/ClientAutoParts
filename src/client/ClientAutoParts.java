/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package client;

import ejb.AutoParts;
import ejb.AutoPartsEJBRemote;
import ejb.Category;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Alex
 */
public class ClientAutoParts {

    private static AutoPartsEJBRemote autoPartsEJB;

    public static void main(String[] args) {
        try {
            // Creazione del contesto iniziale per il lookup JNDI
            Context ctx = new InitialContext();

            // Lookup dell'EJB remoto
            autoPartsEJB = (AutoPartsEJBRemote) ctx.lookup("java:global/AutoParts/AutoPartsEJB!ejb.AutoPartsEJBRemote");
            
            System.out.println("\nElenco di tutti i pezzi di ricambio");
            List<AutoParts> listaParti = autoPartsEJB.findAll();
            for (AutoParts p : listaParti) {
                System.out.println(p.getName());
            }
            
            System.out.println("\nPart found by Id");
            AutoParts partById = autoPartsEJB.findById(2);
            System.out.println(partById.getName());
            
            System.out.println("\nParts found by Category");
            List<AutoParts> fByCat = autoPartsEJB.findByCategory(Category.Freni);
            for (AutoParts elem : fByCat) {
                System.out.println(elem.getName());
            }
            
            System.out.println("\nParts that need to be ordered");
            List<AutoParts> needToOrder = autoPartsEJB.needOrder();
            for (AutoParts elem : needToOrder) {
                System.out.println(elem.getName() + " " + elem.getAvailability());
            }
            
            
            //Codice per il test del counter needOrder() chiamata per la seconda volta
            System.out.println("\nParts that need to be ordered, Test counter");
            List<AutoParts> needToOrderTestC = autoPartsEJB.needOrder();
            for (AutoParts elem : needToOrderTestC) {
                System.out.println(elem.getName() + " " + elem.getAvailability());
            }

        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

}
