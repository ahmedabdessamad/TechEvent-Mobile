/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.codename1.codescan.ScanResult;
import com.codename1.components.ImageViewer;
import com.codename1.messaging.Message;
import com.codename1.notifications.LocalNotification;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.RoundBorder;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.techevent.Services.ServiceClub;
import com.techevent.Services.ServiceInteresser;
import com.techevent.entities.Event;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Ahmed Abdessamed
 */
public class ListeInt {
    
    
    
       private Resources theme;
    ArrayList<Event> list = new ArrayList<>();
    
    
    
     public void mesClubs(){
      
         
         
         
         
        theme = UIManager.initFirstTheme("/theme");
        ServiceInteresser cs = new ServiceInteresser();
        list = cs.getListEventInt();
        Form f = new Form("Events", BoxLayout.y());
Toolbar.setGlobalToolbar(true);

          f.getToolbar().addMaterialCommandToSideMenu("Liste interesser", FontImage.MATERIAL_FAVORITE, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
               ListeInt a =new ListeInt();
               a.mesClubs();
            }
        });

        f.getToolbar().addMaterialCommandToSideMenu("Tout les Events", FontImage.MATERIAL_EVENT_NOTE, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
               Events a = new Events();
                 a.mesClubs();
            }
        });

        f.getToolbar().addMaterialCommandToSideMenu("Mes Events", FontImage.MATERIAL_EVENT_NOTE, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
               MesEvent  o = new MesEvent();
               o.mesClubs();
            }
        });
        f.getToolbar().addMaterialCommandToSideMenu("Ajouter", FontImage.MATERIAL_BOOK, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
              
              
            }});
        
         LocalNotification n = new LocalNotification();
        n.setId("demo-notification");
        n.setAlertBody("It's time to take a break and look at me");
        n.setAlertTitle("Break Time!");
        n.setAlertSound("/notification_sound_bells.mp3"); 
//         Display.getInstance().scheduleLocalNotification(n, 10, LocalNotification.REPEAT_NONE);
//file name must begin with notification_sound


        Display.getInstance().scheduleLocalNotification(
                n,
                System.currentTimeMillis() + 10 * 1000, // fire date/time
                LocalNotification.REPEAT_MINUTE  // Whether to repeat and what frequency
        );
        
        
        for (int i = 0; i < list.size(); i++) {
            
            
              int id = list.get(i).getId();
            //String Titre = list.get(i).getTitre();
             //String desc = list.get(i).getDescription();
            //int prix = list.get(i).getPrix();
           
         
            
            Container buttons = new Container(BoxLayout.x());
            Container events = new Container(BoxLayout.x());
            Container events1 = new Container(BoxLayout.x());
                Container all = new Container(BoxLayout.x());
            Container semiAll = new Container(BoxLayout.y());
            Container enr = new Container(BoxLayout.x());
           
              Font mediumPlainSystemFont = Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_LARGE);
              Label ide = new Label("    " + list.get(i).getId());
            ide.getUnselectedStyle().setFont(mediumPlainSystemFont);
             Label titre = new Label(" Titre : " + list.get(i).getTitre());
             titre.getUnselectedStyle().setFont(mediumPlainSystemFont);
             Label desc = new Label(" Desc : " + list.get(i).getDescription());
             desc.getUnselectedStyle().setFont(mediumPlainSystemFont);
              Label localisation = new Label("    " + list.get(i).getLocalisation());
             Label dateevent = new Label(" " + list.get(i).getDateevent()+ "   ");
             Label prix = new Label(" " + list.get(i).getPrix()+ "   ");
             Label nombreplace = new Label(" " + list.get(i).getNbrplaces()+ "   ");
              Label hdebut = new Label(" " + list.get(i).getHdebut()+ "   ");
               Label hfin = new Label(" " + list.get(i).getHfin()+ "   ");
               Label type = new Label(" " + list.get(i).getType()+ "   ");
               Label categorie = new Label(" " + list.get(i).getCategorie()+ "   ");
             Label affiche = new Label(list.get(i).getAffiche());
           // Label espace = new Label("  ");
            //events.add(ide); 
            events.add(titre);events1.add(desc);
            //events.add(localisation);
           // events.add(dateevent);
           // events.add(nombreplace);events.add(hdebut);events.add(hfin);events.add(type);events.add(categorie);
           
            

             semiAll.add(events);
            semiAll.add(events1);
             all.add(semiAll);
             f.add (all);
            
             
              Toolbar tb1 = f.getToolbar();
             
             tb1.addCommandToRightBar("back", null ,(ActionListener) (ActionEvent evet)-> {
         
                              HomeForm a = new HomeForm ();
                                       
       
          
         
            
        });
              String maail = list.get(i).getTitre();
              String date = list.get(i).getDateevent();
               Button mail = new Button("Envoyer à");
        mail.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent evt) {
                    
               Form fModifier = new Form("Modifie le club", BoxLayout.y());
               
               Container events = new Container(BoxLayout.x());
            Container events1 = new Container(BoxLayout.x());
         TextField      localisation = new TextField("","mail",18,TextArea.ANY);
        Style loginStyler = localisation.getAllStyles();
        loginStyler.setBorder(RoundBorder.create().
        rectangle(true).
        color(0xF7749D).
        strokeColor(0).
        strokeOpacity(120)
        );
        Button envo = new Button("Envoyer");
        
        events.add(localisation);
        events1.add(envo);
        fModifier.add(events);
                fModifier.add(events1);

       envo.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent evt) {
                
                 Message m = new Message(
                             " je Vous invite pour assister l'event "+maail+" qui se deroule le "+date+" \n Soyez le Bienvenue"
                             );
                    Display.getInstance().sendMessage(new String[]{localisation.getText()}, "Invitation", m);
                  if ( Dialog.show("Invitation","L'invitation est envoyer avec succée","ok",null)){
                      
                      ListeInt pp = new ListeInt();
                      pp.mesClubs();
                }
                }});
                   
                    
                    fModifier.show();
                    
                    
                    
                    
                    
                    
                    
                }});
     
             
             
             
             
             
             
             
             
              Button interesser = new Button("Supprimer");

              
              
              
              
                interesser.addActionListener (new ActionListener() {

                @Override
                    public void actionPerformed
                    (ActionEvent evt
                    
                        ) {
                   ServiceInteresser a  = new ServiceInteresser ();
                   if((Dialog.show("Confirmation", "Voulez Vous Supprimer L'event", "OK", "Cancel"))){
     a.supprimerEventInt(id);}
     
     ListeInt b = new ListeInt();
     b.mesClubs();
     
     
     
                    }
                }
                );
                 
            
             
              Button consulter = new Button(" consulter ");
               buttons.add (interesser);
               
               buttons.add (consulter);
                buttons.add (mail);
             f.add (buttons);
            consulter.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent evt) {
                    Form fModifier = new Form("Modifie le club", BoxLayout.y());
                                             Font largePlainMonospaceFont = Font.createSystemFont(Font.FACE_MONOSPACE, Font.STYLE_PLAIN, Font.SIZE_LARGE);
   
                    Label nomEvent = new Label("Titre: "+titre.getText());
                   nomEvent.getUnselectedStyle().setFont(largePlainMonospaceFont);
                     Label description = new Label("desc:"+desc.getText());
                       description.getUnselectedStyle().setFont(largePlainMonospaceFont);
                       Label localisationa = new Label("Localisation"+localisation.getText());
                         localisationa.getUnselectedStyle().setFont(largePlainMonospaceFont);
                    Label dateeventa = new Label("date :"+dateevent.getText());
                      dateeventa.getUnselectedStyle().setFont(largePlainMonospaceFont);
                    Label prixa = new Label("prix"+prix.getText());
                    prixa.getUnselectedStyle().setFont(largePlainMonospaceFont);
                     Label nombreplacea = new Label("Nombre Place "+nombreplace.getText());
                       nombreplacea.getUnselectedStyle().setFont(largePlainMonospaceFont);
                      Label hdebuta = new Label("Heure de debut "+hdebut.getText());
                        hdebuta.getUnselectedStyle().setFont(largePlainMonospaceFont);
                       Label hfina = new Label("Heure de fin"+hfin.getText());
                         hfina.getUnselectedStyle().setFont(largePlainMonospaceFont);
                        Label typea  = new Label("Tpe"+type.getText());
                          typea.getUnselectedStyle().setFont(largePlainMonospaceFont);
                           Label categoriea = new Label("Categorie :"+categorie.getText());
                             categoriea.getUnselectedStyle().setFont(largePlainMonospaceFont);
                             
                              ImageViewer cadrePhotoEvent = new ImageViewer();
                    Image img = null;
                    try {
                                           img = Image.createImage("file:/c:/wamp64/www/techeventmobile/web/img/event/"+affiche.getText());

                        cadrePhotoEvent = new ImageViewer(img.scaled(800, 400));
                    } catch (IOException ex) {
                    }
                    Button enregistrer = new Button("Back");
          
            enregistrer.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent evt) {
               ListeInt a = new ListeInt();
         a.mesClubs();
                }});
             fModifier.add(cadrePhotoEvent);
                    fModifier.add(nomEvent);
                    fModifier.add(description);
                    fModifier.add(localisationa);
                    fModifier.add(dateeventa);
                    fModifier.add(prixa);
                    fModifier.add(nombreplacea);
                    fModifier.add(hdebuta);
                    fModifier.add(hfina);
                    fModifier.add(typea);
                    fModifier.add(categoriea);
                //  fModifier.add(enregistrer);
                    
                   enr.add(enregistrer);
                    fModifier.add(enr);
                 fModifier.show ();
                 
                 
                 
                 
                 }
                }
                );
            
}
    
      f.show();

      
      
      
      
     
     }
    
   
     
     
    
}
