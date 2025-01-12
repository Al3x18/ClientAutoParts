/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/SessionRemote.java to edit this template
 */
package ejb;

import jakarta.ejb.Remote;
import java.util.List;

/**
 *
 * @author Alex
 */
@Remote
public interface AutoPartsEJBRemote {
    public List<AutoParts> findAll(); // Trova tutti i pezzi

    public List<AutoParts> findByCategory(Category category); // Trova pezzi per categoria

    public AutoParts findById(int id); // Trova pezzo per ID

    public AutoParts createPart(AutoParts part); // Crea un nuovo pezzo

    public AutoParts updatePart(AutoParts part); // Aggiorna un pezzo esistente
    
    public List<AutoParts> needOrder();

    public void deletePart(AutoParts part); // Elimina un pezzo
}
