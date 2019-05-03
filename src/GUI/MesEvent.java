/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
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
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.Layout;
import com.codename1.ui.plaf.RoundBorder;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.techevent.Services.ServiceClub;
import com.techevent.Services.ServiceEvent;
import com.techevent.entities.Event;
import java.io.IOException;
import java.util.ArrayList;


/**
 *
 * @author Ahmed Abdessamed
 */
public class MesEvent {
     private Resources theme;
    ArrayList<Event> list = new ArrayList<>();
    ImageViewer imgv = null;
    Image img;
    
     ImageViewer image = new ImageViewer();
     
    /*
    public void consulter (int id){
        
        theme = UIManager.initFirstTheme("/theme");
        ServiceEvent cs = new ServiceEvent();
        list = cs.getconsulter(id);
        Form f = new Form("Mes Event", BoxLayout.y());

        for (int i = 0; i < list.size(); i++) {
    Label desc = new Label("    " + list.get(i).getDescription());
         Container events = new Container(BoxLayout.x());
         events.add(desc);
         f.add(events);
           f.show();
            System.out.println(list);
    }
    
    }*/
    

    
    
    public Component createLineSeparator() {
        Label separator = new Label("", "WhiteSeparator");
        separator.setShowEvenIfBlank(true);
        return separator;
    }
    
    public Component createLineSeparator(int color) {
        Label separator = new Label("", "WhiteSeparator");
        separator.getUnselectedStyle().setBgColor(color);
        separator.getUnselectedStyle().setBgTransparency(255);
        separator.setShowEvenIfBlank(true);
        return separator;
    }

    protected void addSideMenu(Resources res) {
        Form f = new Form();
        Toolbar tb = f.getToolbar();

        tb.addMaterialCommandToSideMenu("Clubs", FontImage.MATERIAL_UPDATE, e -> new NewsfeedForm(res).show());
        tb.addMaterialCommandToSideMenu("Profile", FontImage.MATERIAL_SETTINGS, e -> new Signin(res).show());
        tb.addMaterialCommandToSideMenu("Logout", FontImage.MATERIAL_EXIT_TO_APP, e -> new Signin(res).show());


    }






     public void mesClubs(){
      
        theme = UIManager.initFirstTheme("/theme");
        ServiceClub cs = new ServiceClub();
        list = cs.getListEventClub(17);
        Form f = new Form("Mes Event", BoxLayout.y());

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
        
        
        
        
        
        
        
        
        
        
        
        
        for (int i = 0; i < list.size(); i++) {
            
            
              int id = list.get(i).getId();
            //String Titre = list.get(i).getTitre();
             //String desc = list.get(i).getDescription();
            //int prix = list.get(i).getPrix();
           
         
             Toolbar tb1 = f.getToolbar();
             
             tb1.addCommandToRightBar("back", null ,(ActionListener) (ActionEvent evet)-> {
          
                            
                                       
       
          
         
            
        });
             image.setPreferredSize(new Dimension(500, 500));
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
                Label affiche = new Label(list.get(i).getAffiche());
               Label categorie = new Label(" " + list.get(i).getCategorie()+ "   ");
             
            Label espace = new Label("  ");
           // events.add(ide); 
            events.add(titre);
            events1.add(desc);//events.add(localisation);
           // events.add(dateevent);
          //  events.add(nombreplace);events.add(hdebut);events.add(hfin);events.add(type);events.add(categorie);
           
          //   setImage("file://C:/Users/AHMEDA~1/AppData/Local/Temp/temp2330690525852754185..jpg", image);

           
            semiAll.add(events);
             semiAll.add(events1);
             all.add(semiAll);
             f.add (all);
            
             
             
             
              Button modifier = new Button(" Modifier ");
            modifier.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent evt) {
                    Form fModifier = new Form("Modifie le club", BoxLayout.y());
                       
                  
                    
                  TextField  nomEvent = new TextField(titre.getText());
        Style loginStyle = nomEvent.getAllStyles();
        loginStyle.setBorder(RoundBorder.create().
        rectangle(true).
        color(0xF7749D).
        strokeColor(0).
        strokeOpacity(120)
        );
                     TextField  description = new TextField(desc.getText());
        Style loginStyled = description.getAllStyles();
        loginStyled.setBorder(RoundBorder.create().
        rectangle(true).
        color(0xF7749D).
        strokeColor(0).
        strokeOpacity(120)
        );
                     TextField  localisationa = new TextField(localisation.getText());
        Style loginStylze = localisationa.getAllStyles();
        loginStylze.setBorder(RoundBorder.create().
        rectangle(true).
        color(0xF7749D).
        strokeColor(0).
        strokeOpacity(120)
        );
         TextField  dateeventa = new TextField(dateevent.getText());
        Style loginStylee = dateeventa.getAllStyles();
        loginStylee.setBorder(RoundBorder.create().
        rectangle(true).
        color(0xF7749D).
        strokeColor(0).
        strokeOpacity(120)
        );
         TextField  prixa = new TextField(prix.getText());
        Style loginStyele = prixa.getAllStyles();
        loginStyele.setBorder(RoundBorder.create().
        rectangle(true).
        color(0xF7749D).
        strokeColor(0).
        strokeOpacity(120)
        );
         TextField  nombreplacea = new TextField(nombreplace.getText());
        Style loginSrtyle = nombreplacea.getAllStyles();
        loginSrtyle.setBorder(RoundBorder.create().
        rectangle(true).
        color(0xF7749D).
        strokeColor(0).
        strokeOpacity(120)
        );
         TextField  hdebuta = new TextField(hdebut.getText());
        Style loginStyler = hdebuta.getAllStyles();
        loginStyler.setBorder(RoundBorder.create().
        rectangle(true).
        color(0xF7749D).
        strokeColor(0).
        strokeOpacity(120)
        );
                    
                    TextField  hfina = new TextField(hfin.getText());
        Style loginSttyler = hfina.getAllStyles();
        loginSttyler.setBorder(RoundBorder.create().
        rectangle(true).
        color(0xF7749D).
        strokeColor(0).
        strokeOpacity(120)
        );
                    
                 TextField  typea = new TextField(type.getText());
        Style loginStylter = typea.getAllStyles();
        loginStylter.setBorder(RoundBorder.create().
        rectangle(true).
        color(0xF7749D).
        strokeColor(0).
        strokeOpacity(120)
        );   
                    
                 TextField  categoriea = new TextField(categorie.getText());
        Style loginStylyer = categoriea.getAllStyles();
        loginStylyer.setBorder(RoundBorder.create().
        rectangle(true).
        color(0xF7749D).
        strokeColor(0).
        strokeOpacity(120)
        );     
                   
                   
                    
                     
                       
                    
                         
                    Button enregistrer = new Button("Enregistrer");

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
                       
                    
                   enr.add(enregistrer);
                    fModifier.add(enr);
                    enregistrer.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            if (nomEvent.getText().equals("") || description.getText().equals("")
                                    || nombreplace.getText().equals("")) {
                                Dialog.show(" ", "ERREUR \n Champs vide(s) !", "OK", null);

                           
                            }else {
                                Event a = new Event(id, nomEvent.getText(), description.getText(),nombreplacea.getText(), localisationa.getText(),
                                dateeventa.getText(),hdebuta.getText(),hfina.getText(), Integer.parseInt( prixa.getText()),categoriea.getText(),typea.getText());

                                ServiceEvent c = new ServiceEvent();
                                c.modifierEvent(a);
                                 MesEvent ser = new MesEvent();
       
        ser.mesClubs();
                            }
                            }
                        }

                        );
                        Toolbar tb1 = fModifier.getToolbar();
           
          
          
                          tb1.addCommandToRightBar("back", null ,(ActionListener) (ActionEvent evet)-> {
         
                                MesEvent ser = new MesEvent();
       
        ser.mesClubs();
          
         
            
        });
                        

                        
                        fModifier.show ();
                    }
                }
                );
             
       
                                       
       
          
         
            
       
            
            
            
            
            
             
             
              Button supprimer = new Button("Supprimer");

                supprimer.addActionListener (new ActionListener() {

                @Override
                    public void actionPerformed
                    (ActionEvent evt
                    
                        ) {
                   
                       ServiceEvent a = new ServiceEvent();
                      
                       if (Dialog.show("Confirmation", "Voulez Vous Supprimer L'event", "OK", "Cancel")) {
    a.supprimerEvent(id); 
    MesEvent ser = new MesEvent();
       
        ser.mesClubs();
}
                             
                               
                    }
                }
                );
           
                
                
                
                
                
                 Button consulter = new Button(" consulter ");
            consulter.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent evt) {
                    Form fModifier = new Form("Modifie le club", BoxLayout.y());
                                             Font largePlainMonospaceFont = Font.createSystemFont(Font.FACE_MONOSPACE, Font.STYLE_PLAIN, Font.SIZE_LARGE);
   
                    Label nomEvent = new Label(titre.getText());
                   nomEvent.getUnselectedStyle().setFont(largePlainMonospaceFont);
                     Label description = new Label(desc.getText());
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
                MesEvent pp = new MesEvent();
                pp.mesClubs();
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
                
                
           
                
                
                
                buttons.add (consulter);
              buttons.add (modifier);
              buttons.add (supprimer);
             f.add (buttons);
             
            
}
    
      f.show();

     
     }

 private void setImage(String filePath, ImageViewer img) {
        try {
            Image i1 = Image.createImage(filePath);
            img.setImage(i1);
           /* if (i1 != null) {
                //FileSystemStorage     
                ImageIO imgIO = ImageIO.getImageIO();
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                imgIO.save(i1, out, File.separator, 1);
                byte[] ba = out.toByteArray();
                String Imagecode = Base64.encode(ba);
                ConnectionRequest request = new ConnectionRequest();
                request.addResponseListener((NetworkEvent evt) -> {
                    byte[] data = (byte[]) evt.getMetaData();
                    String s = new String(data);
                    extension = s;

                });
                request.setPost(true);
                request.setHttpMethod("POST");
                request.addArgument("Image", Imagecode);
               // request.setUrl("http://localhost:8080/MobilePHP/Upload.php");
                NetworkManager.getInstance().addToQueueAndWait(request);
            } else {
                System.out.println("Unable to upload");
            }*/
            img.getParent().revalidate();

        } catch (Exception ex) {
            // Log.e(ex);

        }

}
}
