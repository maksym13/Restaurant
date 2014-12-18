/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objets;

/**
 *
 * @author cdi406
 */
public class Notification
{
    private String message;
    private String destinataire;
    
    public Notification(String message, String destinataire)
    {
        this.message = message;
        this.destinataire = destinataire;
}

    public String getDestinataire()
    {
        return destinataire;
    }

    public void setDestinataire(String destinataire)
    {
        this.destinataire = destinataire;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }
    
    
}
