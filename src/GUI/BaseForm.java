/*
 * Copyright (c) 2016, Codename One
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated 
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation 
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, 
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions 
 * of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, 
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A 
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT 
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF 
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE 
 * OR THE USE OR OTHER DEALINGS IN THE SOFTWARE. 
 */

package GUI;

import com.codename1.components.ImageViewer;
import com.codename1.components.ScaleImageLabel;
import com.codename1.notifications.LocalNotification;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.layouts.Layout;
import com.codename1.ui.plaf.RoundBorder;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.sun.prism.Material;
import com.techevent.Services.ServiceEvent;
import com.techevent.entities.Event;

/**
 * Base class for the forms with common functionality
 *
 * @author Shai Almog
 */
public class BaseForm extends Form {
  
    Form aj ;
     TextField tnom;
    TextField nbrpalce;
    TextField localisation;
    TextField dateevent;
    TextField hdebut;
    TextField hfin;
    TextField prix;
    TextField categories;
    TextField type;
     ImageViewer image = new ImageViewer();
        String extension;
          

    TextField tetat;
    Button btnajout,btnaff,suppr, it;
     Button choisirImg;
    
    public BaseForm() {
    }

    public BaseForm(Layout contentPaneLayout) {
        super(contentPaneLayout);
    }

    public BaseForm(String title, Layout contentPaneLayout) {
        super(title, contentPaneLayout);
    }
    
    
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
      
        Toolbar tb = getToolbar();
        Image img = res.getImage("profile-background.jpg");
        if(img.getHeight() > Display.getInstance().getDisplayHeight() / 3) {
            img = img.scaledHeight(Display.getInstance().getDisplayHeight() / 3);
        }
        ScaleImageLabel sl = new ScaleImageLabel(img);
        sl.setUIID("BottomPad");
        sl.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
        
        tb.addComponentToSideMenu(LayeredLayout.encloseIn(
                sl,
                FlowLayout.encloseCenterBottom(
                        new Label(res.getImage("profile-pic.jpg"), "PictureWhiteBackgrond"))
        ));
        
        
        
        
        
        
        
        
        
        aj = new Form("HOME",BoxLayout.y());
        
       
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        Toolbar.setGlobalToolbar(true);

          aj.getToolbar().addMaterialCommandToSideMenu("Liste interesser", FontImage.MATERIAL_BOOK, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
               ListeInt a =new ListeInt();
               a.mesClubs();
            }
        });

        aj.getToolbar().addMaterialCommandToSideMenu("Tout les Events", FontImage.MATERIAL_BOOK, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
               Events a = new Events();
                 a.mesClubs();
            }
        });

        aj.getToolbar().addMaterialCommandToSideMenu("Mes Events", FontImage.MATERIAL_BOOK, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
               MesEvent  o = new MesEvent();
               o.mesClubs();
            }
        });
        aj.getToolbar().addMaterialCommandToSideMenu("Ajouter", FontImage.MATERIAL_BOOK, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
              
              
            }});
        
        
        
        
        
        
        
        
        
        
        
        
         tetat = new TextField("","descrtiption",18,TextArea.ANY);
        Style loginStyle = tetat.getAllStyles();
        loginStyle.setBorder(RoundBorder.create().
        rectangle(true).
        color(0xF7749D).
        strokeColor(0).
        strokeOpacity(120)
        );
        tnom = new TextField("","titre",18,TextArea.ANY);
        Style loginSzztyle = tnom.getAllStyles();
        loginSzztyle.setBorder(RoundBorder.create().
        rectangle(true).
        color(0xF7749D).
        strokeColor(0).
        strokeOpacity(120)
        );
        nbrpalce = new TextField("","nombre de place",18,TextArea.ANY);
        Style loginStylea = nbrpalce.getAllStyles();
        loginStylea.setBorder(RoundBorder.create().
        rectangle(true).
        color(0xF7749D).
        strokeColor(0).
        strokeOpacity(120)
        );
        prix = new TextField("","prix",18,TextArea.ANY);
        Style loginStyleaa = prix.getAllStyles();
        loginStyleaa.setBorder(RoundBorder.create().
        rectangle(true).
        color(0xF7749D).
        strokeColor(0).
        strokeOpacity(120)
        );
        localisation = new TextField("","localisation",18,TextArea.ANY);
        Style loginStyler = localisation.getAllStyles();
        loginStyler.setBorder(RoundBorder.create().
        rectangle(true).
        color(0xF7749D).
        strokeColor(0).
        strokeOpacity(120)
        );
        dateevent = new TextField("","date event",18,TextArea.ANY);
        Style loginStyles = dateevent.getAllStyles();
        loginStyles.setBorder(RoundBorder.create().
        rectangle(true).
        color(0xF7749D).
        strokeColor(0).
        strokeOpacity(120)
        );
        hdebut = new TextField("","heure de debut",18,TextArea.ANY);
        Style loginStyleq = hdebut.getAllStyles();
        loginStyleq.setBorder(RoundBorder.create().
        rectangle(true).
        color(0xF7749D).
        strokeColor(0).
        strokeOpacity(120)
        );
        hfin = new TextField("","heure de fin ",18,TextArea.ANY);
        Style loginStylfe = hfin.getAllStyles();
        loginStylfe.setBorder(RoundBorder.create().
        rectangle(true).
        color(0xF7749D).
        strokeColor(0).
        strokeOpacity(120)
        );
        categories = new TextField("","categories",18,TextArea.ANY);
        Style lsoginStyle = categories.getAllStyles();
        lsoginStyle.setBorder(RoundBorder.create().
        rectangle(true).
        color(0xF7749D).
        strokeColor(0).
        strokeOpacity(120)
        );
        type = new TextField("","type",18,TextArea.ANY);
        Style loginStyyle = type.getAllStyles();
        loginStyyle.setBorder(RoundBorder.create().
        rectangle(true).
        color(0xF7749D).
        strokeColor(0).
        strokeOpacity(120)
        );
        
        
        
        
        
       choisirImg = new Button("Choisir image");
        choisirImg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
               
                   Display.getInstance().openGallery((e) -> {
                       
                       if (e == null || e.getSource() == null) {

                    } else {
                        String filePath = (String) e.getSource();

                           setImage(filePath, image);


                    }
                   }, Display.GALLERY_IMAGE);
                   
                   
           
                
                                    
            }});
        
        it = new Button ("it");
        btnajout = new Button("ajouter");
        btnaff=new Button("Affichage");
        suppr = new Button ("sup");
        aj = new Form("ajouter Event");
        aj.add(tnom);
        aj.add(tetat);
        aj.add(nbrpalce);
        aj.add(localisation);
        aj.add(choisirImg);
      
        aj.add(dateevent);
        aj.add(hdebut);
        aj.add(hfin);
        aj.add(prix);
        aj.add(categories);
        aj.add(type);
         // aj.add(image);
        aj.add(btnajout);
         btnajout.addActionListener((e) -> {
            ServiceEvent ser = new ServiceEvent();
            Event a = new Event(tnom.getText(),tetat.getText(),nbrpalce.getText(),localisation.getText(),dateevent.getText(),hdebut.getText(),hfin.getText(),Integer.parseInt(prix.getText()),categories.getText(),type.getText());
            ser.ajoutEvent(a);
              MesEvent sere = new MesEvent();
       
        sere.mesClubs();

        });
        
        
        
        
       
        tb.addMaterialCommandToSideMenu("Profile", FontImage.MATERIAL_SETTINGS, e -> new Signin(res).show());
        tb.addMaterialCommandToSideMenu("Logout", FontImage.MATERIAL_EXIT_TO_APP, e -> new Signin(res).show());
        tb.addMaterialCommandToSideMenu("mesEvent",FontImage.MATERIAL_EVENT_NOTE,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                
            MesEvent ser = new MesEvent();
       
        ser.mesClubs();
          
            }
        }
          );
          tb.addMaterialCommandToSideMenu("All Event",FontImage.MATERIAL_EVENT_NOTE,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                
              
              Events  a = new Events();
                        a.mesClubs();
          
            }
        }
          );
            tb.addMaterialCommandToSideMenu("Ajouter",FontImage.MATERIAL_EVENT_AVAILABLE,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                
            aj.show();
          
            }
        }
          );
              tb.addMaterialCommandToSideMenu("Liste Interesser",FontImage.MATERIAL_FAVORITE,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                
             ListeInt a = new ListeInt();
         a.mesClubs();
          
            }
        }
          );
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



