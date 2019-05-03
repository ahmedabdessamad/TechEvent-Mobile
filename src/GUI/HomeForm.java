/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.File;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.Calendar;
import com.codename1.ui.Component;
import com.codename1.ui.Dialog;
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
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;
import static com.codename1.ui.layouts.BorderLayout.NORTH;
import com.codename1.ui.table.DefaultTableModel;
import com.codename1.ui.table.Table;
import com.codename1.ui.table.TableModel;
import com.codename1.ui.util.ImageIO;
import com.codename1.util.Base64;

import com.techevent.Services.ServiceEvent;
import com.techevent.Services.ServiceInteresser;
import com.techevent.entities.Event;
import java.io.ByteArrayOutputStream;

/**
 *
 * @author bhk
 */
public class HomeForm {
Form  aj ;
    Form f;
    Form intersser;
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
     
    public HomeForm() {
        
        
    
        
        image.setPreferredSize(new Dimension(150, 150));
        f = new Form("HOME",new BorderLayout());
        
        
        
   
f.show();
           
//       TableModel model = new DefaultTableModel(new String[] {"Col 1", "Col 2", "Col 3"}, new Object[][] {
//    {"Row 1", "Row A", 1},
//    {"Row 2", "Row B", 4},
//    {"Row 3", "Row C", 7.5},
//    {"Row 4", "Row D", 2.24},
//    });
//Table table = new Table(model);
//table.setSortSupported(true);
// f.add( table);
//f.add(NORTH, new Button("Button"));
//f.show();
        
        
        //SpanLabel d = new SpanLabel("Welcome To TechEvent");
       // f.add(d);
         intersser = new Form("Liste interesser");
         
         
         
        tnom = new TextField("","titre");
        tetat = new TextField("","description");
        nbrpalce = new TextField("","nbrpalce",12,TextArea.NUMERIC);
        localisation = new TextField("","localisation");
        dateevent = new TextField("","dateevent");
        hdebut = new TextField("","hdebut");
        hfin = new TextField("","hfin");
        prix = new TextField("","prix",12,TextArea.NUMERIC);
        categories = new TextField("","categories");
        type = new TextField("","type");
        
        
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
        aj.add(image);
        aj.add(dateevent);
        aj.add(hdebut);
        aj.add(hfin);
        aj.add(prix);
        aj.add(categories);
        aj.add(type);
        aj.add(btnajout);
       aj.add(it);
        aj.add(suppr);
        btnajout.addActionListener((e) -> {
            ServiceEvent ser = new ServiceEvent();
            Event a = new Event(tnom.getText(),tetat.getText(),nbrpalce.getText(),localisation.getText(),dateevent.getText(),hdebut.getText(),hfin.getText(),Integer.parseInt(prix.getText()),categories.getText(),type.getText());
            ser.ajoutEvent(a);
            

        });
       
        
        
         
        
         
          Toolbar tb = f.getToolbar();
          Toolbar tb1 = aj.getToolbar();
           
          
          
           tb1.addCommandToRightBar("back", null ,(ActionListener) (ActionEvent evt)-> {
         
                 
          f.show();
         
            
        }
          );
          tb.addMaterialCommandToSideMenu("Ajouter Event", FontImage.MATERIAL_WEB ,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                
                
                 
          aj.show();
            }
        }
          );
          
         
          
          
          tb.addMaterialCommandToSideMenu("Mes Event", FontImage.MATERIAL_SETTINGS,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                
            MesEvent ser = new MesEvent();
       
        ser.mesClubs();
          
            }
        }
          );
          
          
          tb.addMaterialCommandToSideMenu("Tout les Event", FontImage.MATERIAL_COLOR_LENS,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                
              Events  a = new Events();
                        a.mesClubs();
         
            }
        }
          );
           tb.addMaterialCommandToSideMenu("Liste Intersser", FontImage.MATERIAL_COLOR_LENS,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                
              
         ListeInt a = new ListeInt();
         a.mesClubs();
       
            }
        }
          );
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    public TextField getTnom() {
        return tnom;
    }

    public void setTnom(TextField tnom) {
        this.tnom = tnom;
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
