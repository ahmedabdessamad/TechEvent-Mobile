/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.techevent.Services.ServiceClub;
import com.techevent.Services.ServiceEvent;
import com.techevent.entities.Event;
import java.util.ArrayList;

/**
 *
 * @author Ahmed Abdessamed
 */
public class Consulter {
    
     
    
      private Resources theme;
    ArrayList<Event> list = new ArrayList<>();
    
     ArrayList<Event> listc = new ArrayList<>();
    
     public void mesClubs(){
      
        theme = UIManager.initFirstTheme("/theme");
        ServiceEvent cs = new ServiceEvent();
        list = cs.getListEvent2();
        Form f = new Form("Events", BoxLayout.y());

        for (int i = 0; i < list.size(); i++) {
            
            Event ET = new Event ();
            ET = list.get(i);
              int id = list.get(i).getId();
            //String Titre = list.get(i).getTitre();
             //String desc = list.get(i).getDescription();
            //int prix = list.get(i).getPrix();
           
         
            
            Container buttons = new Container(BoxLayout.x());
            Container events = new Container(BoxLayout.x());
                Container all = new Container(BoxLayout.x());
            Container semiAll = new Container(BoxLayout.y());
            Container enr = new Container(BoxLayout.x());
           
              Label ide = new Label("    " + list.get(i).getId());
             Label titre = new Label("    " + list.get(i).getTitre());
             Label desc = new Label("    " + list.get(i).getDescription());
            //  Label localisation = new Label("    " + list.get(i).getLocalisation());
           // Label dateevent = new Label(" " + list.get(i).getDateevent()+ "   ");
           //  Label prix = new Label(" " + list.get(i).getPrix()+ "   ");
           //  Label nombreplace = new Label(" " + list.get(i).getNbrplaces()+ "   ");
             // Label hdebut = new Label(" " + list.get(i).getHdebut()+ "   ");
              // Label hfin = new Label(" " + list.get(i).getHfin()+ "   ");
              /// Label type = new Label(" " + list.get(i).getType()+ "   ");
             //  Label categorie = new Label(" " + list.get(i).getCategorie()+ "   ");
             
            Label espace = new Label("  ");
            events.add(ide); events.add(titre);events.add(desc);//events.add(localisation);
           // events.add(dateevent);
           // events.add(nombreplace);events.add(hdebut);events.add(hfin);events.add(type);events.add(categorie);
           
            

           
            semiAll.add(events);
             all.add(semiAll);
             f.add (all);
            
             
             
             
             
             
             
             
            
             
                f.show();  
             
         
        }
     
     }
}
