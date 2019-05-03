/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.ButtonGroup;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.RadioButton;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.RoundBorder;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.techevent.Services.ServiceEvent;
import com.techevent.Services.ServiceInteresser;
import com.techevent.entities.Event;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Ahmed Abdessamed
 */
public class Events {

    private Resources theme;
    ArrayList<Event> list = new ArrayList<>();

    ArrayList<Event> listc = new ArrayList<>();
    ImageViewer imgv = null;
    Image img;

    public void mesClubs() {

        theme = UIManager.initFirstTheme("/theme");
        ServiceEvent cs = new ServiceEvent();
        list = cs.getListEvent2();
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
              
              
            }
        });
       
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        Container trie = new Container(BoxLayout.x());
        Font largeBoldMonospaceFont = Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_MEDIUM);
        Label idee = new Label("Trie Par Prix:");
        idee.getUnselectedStyle().setFont(largeBoldMonospaceFont);
        Button brech2 = new Button("croissante");
        Button brech1 = new Button("Decroissante");
       
        trie.add(idee);
        trie.add(brech2);
        trie.add(brech1);
        f.add(trie);

        brech2.addActionListener(
                new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt
            ) {
                Events cs = new Events();
                cs.mesClubsdeasc();
            }
        }
        );
        brech1.addActionListener(
                new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt
            ) {
                Events cs = new Events();
                cs.mesClubsdesc();
            }
        }
        );

        Label ay = new Label("Recherche Par:");
        ay.getUnselectedStyle().setFont(largeBoldMonospaceFont);
        RadioButton rb1 = new RadioButton("titre");
        RadioButton rb2 = new RadioButton("localisation");
        RadioButton rb3 = new RadioButton("type");
        new ButtonGroup(rb1, rb2, rb3);

        f.add(ay).add(rb1).add(rb2).add(rb3);

        Container recherche = new Container(BoxLayout.x());
        Container brecherche = new Container(BoxLayout.x());
        TextField rech = new TextField("", "recherche");
        Style loginStylea = rech.getAllStyles();
        loginStylea.setBorder(RoundBorder.create().
                rectangle(true).
                color(0xF7749D).
                strokeColor(0).
                strokeOpacity(120)
        );
  Button inte = new Button("Liste Interesser");
        Button brech = new Button("recherche");
        recherche.add(rech);
        brecherche.add(brech);
        brecherche.add(inte);
        f.add(recherche);
        f.add(brecherche);

        
         inte.addActionListener(
                new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt
            ) {
               ListeInt a = new ListeInt();
         a.mesClubs();
            }
        }
        );
        
        
        brech.addActionListener(
                new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt
            ) {
                if (rb1.isSelected()) {
                    Events cs = new Events();
                    cs.rechereche(rech.getText(), 0);
                }
                if (rb2.isSelected()) {
                    Events cs = new Events();
                    cs.rechereche(rech.getText(), 1);
                } else {
                    Events cs = new Events();
                    cs.rechereche(rech.getText(), 2);
                }
            }
        }
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
            Label localisation = new Label("  " + list.get(i).getLocalisation());
            localisation.getUnselectedStyle().setFont(mediumPlainSystemFont);
            Label dateevent = new Label("  " + list.get(i).getDateevent() + "   ");
            dateevent.getUnselectedStyle().setFont(mediumPlainSystemFont);
            Label prix = new Label("  " + list.get(i).getPrix() + "   ");
            prix.getUnselectedStyle().setFont(mediumPlainSystemFont);
            Label nombreplace = new Label("  " + list.get(i).getNbrplaces() + "   ");
            nombreplace.getUnselectedStyle().setFont(mediumPlainSystemFont);
            Label hdebut = new Label("  " + list.get(i).getHdebut() + "   ");
            hdebut.getUnselectedStyle().setFont(mediumPlainSystemFont);
            Label hfin = new Label("  " + list.get(i).getHfin() + "   ");
            hfin.getUnselectedStyle().setFont(mediumPlainSystemFont);
            Label type = new Label("  " + list.get(i).getType() + "   ");
            type.getUnselectedStyle().setFont(mediumPlainSystemFont);
            Label categorie = new Label(" " + list.get(i).getCategorie() + "   ");
            Label Affiche = new Label(list.get(i).getAffiche());
            categorie.getUnselectedStyle().setFont(mediumPlainSystemFont);
                  //  f.getToolbar().addCommandToRightBar("Back", theme.getImage("back-command.png"), e -> f.showBack());

            Label espace = new Label(" ");

            // events.add(ide); 
            events.add(titre);
            events1.add(desc);//events.add(localisation);
            // events.add(dateevent);
            // events.add(nombreplace);events.add(hdebut);events.add(hfin);events.add(type);events.add(categorie);

            semiAll.add(events);
            semiAll.add(events1);
            all.add(semiAll);
            f.add(all);

            Toolbar tb1 = f.getToolbar();

            tb1.addCommandToRightBar("back", null, (ActionListener) (ActionEvent evet) -> {

                //signIn.addActionListener(e -> new ProfileForm(res).show());
            });

            Button interesser = new Button("S'interesser");
            String noma = list.get(i).getTitre();
            interesser.addActionListener(
                    new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent evt
                ) {
                    ServiceInteresser a = new ServiceInteresser();
                    a.ajoutInt(id);
                    Dialog.show("Confirmation", "L'event " + noma + " est Ajoutée a votre Liste ", "OK", null);
                }
            }
            );

            Button Consulter = new Button("Consulter");

            Consulter.addActionListener(
                    new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent evt
                ) {

                    Form fModifier = new Form("", BoxLayout.y());
                    Font largePlainMonospaceFont = Font.createSystemFont(Font.FACE_MONOSPACE, Font.STYLE_PLAIN, Font.SIZE_LARGE);

                    Label nomEvent = new Label(titre.getText());
                    nomEvent.getUnselectedStyle().setFont(largePlainMonospaceFont);
                    Label description = new Label(desc.getText());
                    description.getUnselectedStyle().setFont(largePlainMonospaceFont);
                    Label localisationa = new Label("Localisation" + localisation.getText());
                    localisationa.getUnselectedStyle().setFont(largePlainMonospaceFont);
                    Label dateeventa = new Label("date :" + dateevent.getText());
                    dateeventa.getUnselectedStyle().setFont(largePlainMonospaceFont);
                    Label prixa = new Label("prix" + prix.getText());
                    prixa.getUnselectedStyle().setFont(largePlainMonospaceFont);
                    Label nombreplacea = new Label("Nombre Place " + nombreplace.getText());
                    nombreplacea.getUnselectedStyle().setFont(largePlainMonospaceFont);
                    Label hdebuta = new Label("Heure de debut " + hdebut.getText());
                    hdebuta.getUnselectedStyle().setFont(largePlainMonospaceFont);
                    Label hfina = new Label("Heure de fin" + hfin.getText());
                    hfina.getUnselectedStyle().setFont(largePlainMonospaceFont);
                    Label typea = new Label("Tpe" + type.getText());
                    typea.getUnselectedStyle().setFont(largePlainMonospaceFont);
                    Label categoriea = new Label("Categorie :" + categorie.getText());
                    categoriea.getUnselectedStyle().setFont(largePlainMonospaceFont);
                    //Label nomEvent = new Label(affiche.getText());

                    ImageViewer cadrePhotoEvent = new ImageViewer();
                    Image img = null;
                    try {
                        img = Image.createImage("file:/c:/wamp64/www/techeventmobile/web/img/event/" + Affiche.getText());
                        cadrePhotoEvent = new ImageViewer(img.scaled(800, 400));
                    } catch (IOException ex) {
                    }

                    Button enregistrer = new Button("Reserver");
                    Button back = new Button("Back");
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
                    //  fModifier.add(image);

                    fModifier.getToolbar().addCommandToRightBar("Back", theme.getImage("back-command.png"), e -> f.showBack());

                    back.addActionListener(
                            new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent evt
                        ) {
                            Events a = new Events();
                            a.mesClubs();
                        }
                    });
                    enr.add(enregistrer);
                    enr.add(back);
                    fModifier.add(enr);
                    fModifier.show();
                }
            }
            );

            buttons.add(interesser);
            buttons.add(Consulter);

            f.add(buttons);

        }

        f.show();

    }

    public void mesClubsdesc() {

        
        
        
        
        
        
        theme = UIManager.initFirstTheme("/theme");
        ServiceEvent cs = new ServiceEvent();
        list = cs.getlistedesc();
        Form f = new Form("Events", BoxLayout.y());
        Container trie = new Container(BoxLayout.x());
        Font largeBoldMonospaceFont = Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_MEDIUM);
        Label idee = new Label("Trie Par Prix:");
        idee.getUnselectedStyle().setFont(largeBoldMonospaceFont);
        Button brech2 = new Button("Croissante");
        Button brech1 = new Button("Decroissante");
        trie.add(idee);
        trie.add(brech2);
        trie.add(brech1);
        f.add(trie);

        
        
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
              
              
            }
        });
        
        
        
        brech2.addActionListener(
                new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt
            ) {
                Events cs = new Events();
                cs.mesClubsdeasc();
            }
        }
        );
        brech1.addActionListener(
                new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt
            ) {
                Events cs = new Events();
                cs.mesClubsdesc();
            }
        }
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
            Label localisation = new Label("  " + list.get(i).getLocalisation());
            localisation.getUnselectedStyle().setFont(mediumPlainSystemFont);
            Label dateevent = new Label("  " + list.get(i).getDateevent() + "   ");
            dateevent.getUnselectedStyle().setFont(mediumPlainSystemFont);
            Label prix = new Label("  " + list.get(i).getPrix() + "   ");
            prix.getUnselectedStyle().setFont(mediumPlainSystemFont);
            Label nombreplace = new Label("  " + list.get(i).getNbrplaces() + "   ");
            nombreplace.getUnselectedStyle().setFont(mediumPlainSystemFont);
            Label hdebut = new Label("  " + list.get(i).getHdebut() + "   ");
            hdebut.getUnselectedStyle().setFont(mediumPlainSystemFont);
            Label hfin = new Label("  " + list.get(i).getHfin() + "   ");
            hfin.getUnselectedStyle().setFont(mediumPlainSystemFont);
            Label type = new Label("  " + list.get(i).getType() + "   ");
            type.getUnselectedStyle().setFont(mediumPlainSystemFont);
            Label categorie = new Label(" " + list.get(i).getCategorie() + "   ");
            Label Affiche = new Label(list.get(i).getAffiche());
            
            Label espace = new Label("  ");
           // events.add(ide);
            events.add(titre);
            events1.add(desc);//events.add(localisation);
            // events.add(dateevent);
            // events.add(nombreplace);events.add(hdebut);events.add(hfin);events.add(type);events.add(categorie);

            semiAll.add(events);
            semiAll.add(events1);
            all.add(semiAll);
            f.add(all);

            Toolbar tb1 = f.getToolbar();

            tb1.addCommandToRightBar("back", null, (ActionListener) (ActionEvent evet) -> {

                //signIn.addActionListener(e -> new ProfileForm(res).show());
            });

            String noma = list.get(i).getTitre();

            Button interesser = new Button("S'interesser");

            interesser.addActionListener(
                    new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent evt
                ) {

                    ServiceInteresser a = new ServiceInteresser();
                    a.ajoutInt(id);
                    Dialog.show("Confirmation", "L'event " + noma + "était Ajoutée a votre Liste ", "OK", null);

                }
            }
            );

            Button Consulter = new Button("Consulter");

            Consulter.addActionListener(
                    new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent evt
                ) {

                    Form fModifier = new Form("Modifie le club", BoxLayout.y());
 Font largePlainMonospaceFont = Font.createSystemFont(Font.FACE_MONOSPACE, Font.STYLE_PLAIN, Font.SIZE_LARGE);

                    Label nomEvent = new Label(titre.getText());
                    nomEvent.getUnselectedStyle().setFont(largePlainMonospaceFont);
                    Label description = new Label(desc.getText());
                    description.getUnselectedStyle().setFont(largePlainMonospaceFont);
                    Label localisationa = new Label("Localisation" + localisation.getText());
                    localisationa.getUnselectedStyle().setFont(largePlainMonospaceFont);
                    Label dateeventa = new Label("date :" + dateevent.getText());
                    dateeventa.getUnselectedStyle().setFont(largePlainMonospaceFont);
                    Label prixa = new Label("prix" + prix.getText());
                    prixa.getUnselectedStyle().setFont(largePlainMonospaceFont);
                    Label nombreplacea = new Label("Nombre Place " + nombreplace.getText());
                    nombreplacea.getUnselectedStyle().setFont(largePlainMonospaceFont);
                    Label hdebuta = new Label("Heure de debut " + hdebut.getText());
                    hdebuta.getUnselectedStyle().setFont(largePlainMonospaceFont);
                    Label hfina = new Label("Heure de fin" + hfin.getText());
                    hfina.getUnselectedStyle().setFont(largePlainMonospaceFont);
                    Label typea = new Label("Tpe" + type.getText());
                    typea.getUnselectedStyle().setFont(largePlainMonospaceFont);
                    Label categoriea = new Label("Categorie :" + categorie.getText());
                    categoriea.getUnselectedStyle().setFont(largePlainMonospaceFont);
                     ImageViewer cadrePhotoEvent = new ImageViewer();
                    Image img = null;
                    try {
                        img = Image.createImage("file:/c:/wamp64/www/techeventmobile/web/img/event/" + Affiche.getText());
                        cadrePhotoEvent = new ImageViewer(img.scaled(800, 400));
                    } catch (IOException ex) {
                    }
                    //Label nomEvent = new Label(affiche.getText());;
                    Button enregistrer = new Button("back");
                    
                    
                      enregistrer.addActionListener(
                new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt
            ) {
                Events cs = new Events();
                cs.mesClubs();
            }
        }
        );
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
                    //  fModifier.add(image);

                    enr.add(enregistrer);
                    fModifier.add(enr);
                    fModifier.show();
                }
            }
            );

            buttons.add(interesser);
            buttons.add(Consulter);
            f.add(buttons);

        }

        f.show();

    }

    public void mesClubsdeasc() {

        theme = UIManager.initFirstTheme("/theme");
        ServiceEvent cs = new ServiceEvent();
        list = cs.getlistasc();
        Form f = new Form("Events", BoxLayout.y());
        Container trie = new Container(BoxLayout.x());
          Font largeBoldMonospaceFont = Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_MEDIUM);
        Label idee = new Label("Trie Par Prix:");
        idee.getUnselectedStyle().setFont(largeBoldMonospaceFont);

        Button brech2 = new Button("Croissante");
        Button brech1 = new Button("DeCroissante");
        trie.add(idee);
        trie.add(brech2);
        trie.add(brech1);
        f.add(trie);

        
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
              
              
            }
        });
        
        
        
        
        
        brech2.addActionListener(
                new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt
            ) {
                Events cs = new Events();
                cs.mesClubsdeasc();
            }
        }
        );
        brech1.addActionListener(
                new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt
            ) {
                Events cs = new Events();
                cs.mesClubsdesc();
            }
        }
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
            Label localisation = new Label("  " + list.get(i).getLocalisation());
            localisation.getUnselectedStyle().setFont(mediumPlainSystemFont);
            Label dateevent = new Label("  " + list.get(i).getDateevent() + "   ");
            dateevent.getUnselectedStyle().setFont(mediumPlainSystemFont);
            Label prix = new Label("  " + list.get(i).getPrix() + "   ");
            prix.getUnselectedStyle().setFont(mediumPlainSystemFont);
            Label nombreplace = new Label("  " + list.get(i).getNbrplaces() + "   ");
            nombreplace.getUnselectedStyle().setFont(mediumPlainSystemFont);
            Label hdebut = new Label("  " + list.get(i).getHdebut() + "   ");
            hdebut.getUnselectedStyle().setFont(mediumPlainSystemFont);
            Label hfin = new Label("  " + list.get(i).getHfin() + "   ");
            hfin.getUnselectedStyle().setFont(mediumPlainSystemFont);
            Label type = new Label("  " + list.get(i).getType() + "   ");
            type.getUnselectedStyle().setFont(mediumPlainSystemFont);
            Label categorie = new Label(" " + list.get(i).getCategorie() + "   ");
            Label Affiche = new Label(list.get(i).getAffiche());

            Label espace = new Label("  ");
            //events.add(ide);
            events.add(titre);
            events1.add(desc);//events.add(localisation);
            // events.add(dateevent);
            // events.add(nombreplace);events.add(hdebut);events.add(hfin);events.add(type);events.add(categorie);
semiAll.add(events);
            semiAll.add(events1);
            all.add(semiAll);
            f.add(all);

            Toolbar tb1 = f.getToolbar();

            tb1.addCommandToRightBar("back", null, (ActionListener) (ActionEvent evet) -> {

                //signIn.addActionListener(e -> new ProfileForm(res).show());
            });

            String noma = list.get(i).getTitre();

            Button interesser = new Button("S'interesser");

            interesser.addActionListener(
                    new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent evt
                ) {
                    ServiceInteresser a = new ServiceInteresser();
                    a.ajoutInt(id);
                    Dialog.show("Confirmation", "L'event " + noma + "était Ajoutée a votre Liste ", "OK", null);

                }
            }
            );

            Button Consulter = new Button("Consulter");

            Consulter.addActionListener(
                    new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent evt
                ) {

                    Form fModifier = new Form("Modifie le club", BoxLayout.y());
 Font largePlainMonospaceFont = Font.createSystemFont(Font.FACE_MONOSPACE, Font.STYLE_PLAIN, Font.SIZE_LARGE);

                    Label nomEvent = new Label(titre.getText());
                    nomEvent.getUnselectedStyle().setFont(largePlainMonospaceFont);
                    Label description = new Label(desc.getText());
                    description.getUnselectedStyle().setFont(largePlainMonospaceFont);
                    Label localisationa = new Label("Localisation" + localisation.getText());
                    localisationa.getUnselectedStyle().setFont(largePlainMonospaceFont);
                    Label dateeventa = new Label("date :" + dateevent.getText());
                    dateeventa.getUnselectedStyle().setFont(largePlainMonospaceFont);
                    Label prixa = new Label("prix" + prix.getText());
                    prixa.getUnselectedStyle().setFont(largePlainMonospaceFont);
                    Label nombreplacea = new Label("Nombre Place " + nombreplace.getText());
                    nombreplacea.getUnselectedStyle().setFont(largePlainMonospaceFont);
                    Label hdebuta = new Label("Heure de debut " + hdebut.getText());
                    hdebuta.getUnselectedStyle().setFont(largePlainMonospaceFont);
                    Label hfina = new Label("Heure de fin" + hfin.getText());
                    hfina.getUnselectedStyle().setFont(largePlainMonospaceFont);
                    Label typea = new Label("Tpe" + type.getText());
                    typea.getUnselectedStyle().setFont(largePlainMonospaceFont);
                    Label categoriea = new Label("Categorie :" + categorie.getText());
                    categoriea.getUnselectedStyle().setFont(largePlainMonospaceFont);
                    
                     ImageViewer cadrePhotoEvent = new ImageViewer();
                    Image img = null;
                    try {
                        img = Image.createImage("file:/c:/wamp64/www/techeventmobile/web/img/event/" + Affiche.getText());
                        cadrePhotoEvent = new ImageViewer(img.scaled(800, 400));
                    } catch (IOException ex) {
                    }
                    //Label nomEvent = new Label(affiche.getText());
                    Button enregistrer = new Button("back");
                    
                     enregistrer.addActionListener(
                new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt
            ) {
                Events cs = new Events();
                cs.mesClubs();
            }
        }
        );
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
                    //  fModifier.add(image);

                    enr.add(enregistrer);
                    fModifier.add(enr);
                    fModifier.show();
                }
            }
            );

            buttons.add(interesser);
            buttons.add(Consulter);
            f.add(buttons);

        }

        f.show();

    }

    public void rechereche(String op, int c) {
        theme = UIManager.initFirstTheme("/theme");
        Container recherche = new Container(BoxLayout.x());
        Container brecherche = new Container(BoxLayout.x());
        TextField recheee = new TextField("", "recherche");
        Style loginStylea = recheee.getAllStyles();
        loginStylea.setBorder(RoundBorder.create().
                rectangle(true).
                color(0xF7749D).
                strokeColor(0).
                strokeOpacity(120)
        );

        ServiceEvent cs = new ServiceEvent();
        String o = recheee.getText();
        list = cs.rechercher(op, c);
        System.out.println(recheee.getText());
        Form f = new Form("Events", BoxLayout.y());
        Container trie = new Container(BoxLayout.x());
          Font largeBoldMonospaceFont = Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_MEDIUM);
        Label idee = new Label("Trie Par Prix:");
        idee.getUnselectedStyle().setFont(largeBoldMonospaceFont);
        Button brech2 = new Button("Croissante");
        Button brech1 = new Button("DeCroissante");
        trie.add(idee);
        trie.add(brech2);
        trie.add(brech1);
        f.add(trie);

        
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
              
              
            }
        });
        
        
        
        
        
        brech2.addActionListener(
                new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt
            ) {
                Events cs = new Events();
                cs.mesClubsdeasc();
            }
        }
        );
        brech1.addActionListener(
                new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt
            ) {
                Events cs = new Events();
                cs.mesClubsdesc();
            }
        }
        );

        Button brech = new Button("recherche");
        recherche.add(recheee);
        brecherche.add(brech);
        f.add(recherche);
        f.add(brecherche);

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
            Label localisation = new Label("  " + list.get(i).getLocalisation());
            localisation.getUnselectedStyle().setFont(mediumPlainSystemFont);
            Label dateevent = new Label("  " + list.get(i).getDateevent() + "   ");
            dateevent.getUnselectedStyle().setFont(mediumPlainSystemFont);
            Label prix = new Label("  " + list.get(i).getPrix() + "   ");
            prix.getUnselectedStyle().setFont(mediumPlainSystemFont);
            Label nombreplace = new Label("  " + list.get(i).getNbrplaces() + "   ");
            nombreplace.getUnselectedStyle().setFont(mediumPlainSystemFont);
            Label hdebut = new Label("  " + list.get(i).getHdebut() + "   ");
            hdebut.getUnselectedStyle().setFont(mediumPlainSystemFont);
            Label hfin = new Label("  " + list.get(i).getHfin() + "   ");
            hfin.getUnselectedStyle().setFont(mediumPlainSystemFont);
            Label type = new Label("  " + list.get(i).getType() + "   ");
            type.getUnselectedStyle().setFont(mediumPlainSystemFont);
            Label categorie = new Label(" " + list.get(i).getCategorie() + "   ");
            Label Affiche = new Label(list.get(i).getAffiche());;

            Label espace = new Label("  ");
            //events.add(ide);
            events.add(titre);
            events1.add(desc);//events.add(localisation);
            // events.add(dateevent);
            // events.add(nombreplace);events.add(hdebut);events.add(hfin);events.add(type);events.add(categorie);
 semiAll.add(events);
            semiAll.add(events1);
            all.add(semiAll);
            f.add(all);

            Toolbar tb1 = f.getToolbar();

            tb1.addCommandToRightBar("back", null, (ActionListener) (ActionEvent evet) -> {

                //signIn.addActionListener(e -> new ProfileForm(res).show());
            });

            Button interesser = new Button("S'interesser");

            interesser.addActionListener(
                    new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent evt
                ) {
                    ServiceInteresser a = new ServiceInteresser();
                    a.ajoutInt(id);
                }
            }
            );

            Button Consulter = new Button("Consulter");

            Consulter.addActionListener(
                    new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent evt
                ) {

                    Form fModifier = new Form("Modifie le club", BoxLayout.y());

                     Font largePlainMonospaceFont = Font.createSystemFont(Font.FACE_MONOSPACE, Font.STYLE_PLAIN, Font.SIZE_LARGE);

                    Label nomEvent = new Label(titre.getText());
                    nomEvent.getUnselectedStyle().setFont(largePlainMonospaceFont);
                    Label description = new Label(desc.getText());
                    description.getUnselectedStyle().setFont(largePlainMonospaceFont);
                    Label localisationa = new Label("Localisation" + localisation.getText());
                    localisationa.getUnselectedStyle().setFont(largePlainMonospaceFont);
                    Label dateeventa = new Label("date :" + dateevent.getText());
                    dateeventa.getUnselectedStyle().setFont(largePlainMonospaceFont);
                    Label prixa = new Label("prix" + prix.getText());
                    prixa.getUnselectedStyle().setFont(largePlainMonospaceFont);
                    Label nombreplacea = new Label("Nombre Place " + nombreplace.getText());
                    nombreplacea.getUnselectedStyle().setFont(largePlainMonospaceFont);
                    Label hdebuta = new Label("Heure de debut " + hdebut.getText());
                    hdebuta.getUnselectedStyle().setFont(largePlainMonospaceFont);
                    Label hfina = new Label("Heure de fin" + hfin.getText());
                    hfina.getUnselectedStyle().setFont(largePlainMonospaceFont);
                    Label typea = new Label("Tpe" + type.getText());
                    typea.getUnselectedStyle().setFont(largePlainMonospaceFont);
                    Label categoriea = new Label("Categorie :" + categorie.getText());
                    categoriea.getUnselectedStyle().setFont(largePlainMonospaceFont);
                    //Label nomEvent = new Label(affiche.getText());
                    
                     ImageViewer cadrePhotoEvent = new ImageViewer();
                    Image img = null;
                    try {
                        img = Image.createImage("file:/c:/wamp64/www/techeventmobile/web/img/event/" + Affiche.getText());
                        cadrePhotoEvent = new ImageViewer(img.scaled(800, 400));
                    } catch (IOException ex) {
                    }
                    Button enregistrer = new Button("back");
 enregistrer.addActionListener(
                            new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent evt
                        ) {
                            Events a = new Events();
                            a.mesClubs();
                        }
                    });
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
                    //  fModifier.add(image);

                    enr.add(enregistrer);
                    fModifier.add(enr);
                    fModifier.show();
                }
            }
            );

            buttons.add(interesser);
            buttons.add(Consulter);
            f.add(buttons);

        }

        f.show();

    }
}
