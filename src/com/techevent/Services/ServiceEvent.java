/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.techevent.Services;

import com.codename1.components.SpanLabel;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.table.DefaultTableModel;
import com.codename1.ui.table.Table;
import com.codename1.ui.table.TableModel;
import com.techevent.entities.Event;
import GUI.HomeForm;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import java.io.IOException;

import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Ahmed Abdessamed
 */
public class ServiceEvent {

    Form a;
    ArrayList<Event> listEvent = new ArrayList<>();
    ArrayList<Event> listEventa = new ArrayList<>();
    ArrayList<Event> mesEvent = new ArrayList<>();

    public void ajoutEvent(Event a) {
        ConnectionRequest con = new ConnectionRequest();// créat&ne nouvelle demande de connexion
        String Url = "http://localhost/techeventmobile/web/app_dev.php/Ajouterevent?titre=" + a.getTitre() + "&description=" + a.getDescription() + "&nbrpalce=" + a.getNbrplaces() + "&localisation=" + a.getLocalisation() + "&dateevent=" + a.getDateevent() + "&hdebut=" + a.getHdebut() + "&hfin=" + a.getHfin()
                + "&prix=" + a.getPrix() + "&categories=" + a.getCategorie() + "&type=" + a.getType() + "";// création de l'URL
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }

    /*
      public ArrayList<Event> getListEvent2(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/techeventmobile/web/app_dev.php/alleventmobile");  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceEvent ser = new ServiceEvent();
                listEvent =ser.getListEvent(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listEvent;
    }*/
    public ArrayList<Event> getListEvent2() {

        ArrayList<Event> listLivre = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/techeventmobile/web/app_dev.php/alleventmobile");

        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();

                try {
                    Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    System.out.println(tasks);
                    //System.out.println(tasks);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
                    for (Map<String, Object> obj : list) {
                        Event l = new Event();
                        float id = Float.parseFloat(obj.get("id").toString());
                        float prix = Float.parseFloat(obj.get("prix").toString());
                        l.setPrix((int) prix);
                        l.setDescription(obj.get("description").toString());
                        l.setNbrplaces(obj.get("nbrplaces").toString());
                        l.setLocalisation(obj.get("localisation").toString());
                        l.setDateevent(obj.get("dateevent").toString());
                        l.setHdebut(obj.get("hdebut").toString());
                        l.setHfin(obj.get("hfin").toString());
                        l.setAffiche(obj.get("affiche").toString());

                        l.setCategorie(obj.get("categorie").toString());
                        l.setType(obj.get("type").toString());

                        l.setId((int) id);

                        //l.setImage(obj.get("image").toString());
                        l.setTitre(obj.get("titre").toString());
                        // l.setAuteur(obj.get("auteur").toString());

                        listLivre.add(l);

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listLivre;
    }

    /*
      public ArrayList<Event> rechercher(String recha , int c){       
        ConnectionRequest con = new ConnectionRequest();
        
        if( c == 0 ){
        con.setUrl("http://localhost/techeventmobile/web/app_dev.php/rechercheAvance?colone=titre&rech="+recha+"");  
        }
        if (c == 1){
                con.setUrl("http://localhost/techeventmobile/web/app_dev.php/rechercheAvance?colone=localisation&rech="+recha+"");  
                    
        }else {
                        con.setUrl("http://localhost/techeventmobile/web/app_dev.php/rechercheAvance?colone=type&rech="+recha+"");  

        }
        
        
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceEvent ser = new ServiceEvent();
                listEvent =ser.getListEvent(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listEvent;
    }*/
    public ArrayList<Event> rechercher(String recha, int c) {

        ArrayList<Event> listLivre = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        if (c == 0) {
            con.setUrl("http://localhost/techeventmobile/web/app_dev.php/rechercheAvance?colone=titre&rech=" + recha + "");
        }
        if (c == 1) {
            con.setUrl("http://localhost/techeventmobile/web/app_dev.php/rechercheAvance?colone=localisation&rech=" + recha + "");

        } else {
            con.setUrl("http://localhost/techeventmobile/web/app_dev.php/rechercheAvance?colone=type&rech=" + recha + "");

        }

        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();

                try {
                    Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    System.out.println(tasks);
                    //System.out.println(tasks);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
                    for (Map<String, Object> obj : list) {
                        Event l = new Event();
                        float id = Float.parseFloat(obj.get("id").toString());
                        float prix = Float.parseFloat(obj.get("prix").toString());
                        l.setPrix((int) prix);
                        l.setNbrplaces(obj.get("nbrplaces").toString());
                        l.setLocalisation(obj.get("localisation").toString());
                        l.setDateevent(obj.get("dateevent").toString());
                        l.setHdebut(obj.get("hdebut").toString());
                        l.setHfin(obj.get("hfin").toString());
l.setAffiche(obj.get("affiche").toString());
l.setDescription(obj.get("description").toString());
                        l.setCategorie(obj.get("categorie").toString());
                        l.setType(obj.get("type").toString());

                        l.setId((int) id);

                        //l.setImage(obj.get("image").toString());
                        l.setTitre(obj.get("titre").toString());
                        // l.setAuteur(obj.get("auteur").toString());

                        listLivre.add(l);

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listLivre;
    }

    /*
        public ArrayList<Event> getlistedesc(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/techeventmobile/web/app_dev.php/Alleventbyprixdesc");  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceEvent ser = new ServiceEvent();
                listEvent =ser.getListEvent(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listEvent;
    }
     */
    public ArrayList<Event> getlistedesc() {

        ArrayList<Event> listLivre = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/techeventmobile/web/app_dev.php/Alleventbyprixdesc");

        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();

                try {
                    Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    System.out.println(tasks);
                    //System.out.println(tasks);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
                    for (Map<String, Object> obj : list) {
                        Event l = new Event();
                        float id = Float.parseFloat(obj.get("id").toString());
                        float prix = Float.parseFloat(obj.get("prix").toString());
                        l.setPrix((int) prix);
                        l.setNbrplaces(obj.get("nbrplaces").toString());
                        l.setLocalisation(obj.get("localisation").toString());
                        l.setDateevent(obj.get("dateevent").toString());
                        l.setHdebut(obj.get("hdebut").toString());
                        l.setHfin(obj.get("hfin").toString());
l.setDescription(obj.get("description").toString());
                        l.setCategorie(obj.get("categorie").toString());
                        l.setType(obj.get("type").toString());

                        l.setId((int) id);
                        l.setAffiche(obj.get("affiche").toString());

                        //l.setImage(obj.get("image").toString());
                        l.setTitre(obj.get("titre").toString());
                        // l.setAuteur(obj.get("auteur").toString());

                        listLivre.add(l);

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listLivre;
    }
//    public ArrayList<Event> getlistasc(){       
//        ConnectionRequest con = new ConnectionRequest();
//        con.setUrl("http://localhost/techeventmobile/web/app_dev.php/Alleventbyprixasec");  
//        con.addResponseListener(new ActionListener<NetworkEvent>() {
//            @Override
//            public void actionPerformed(NetworkEvent evt) {
//                ServiceEvent ser = new ServiceEvent();
//                listEvent =ser.getListEvent(new String(con.getResponseData()));
//            }
//        });
//        NetworkManager.getInstance().addToQueueAndWait(con);
//        return listEvent;
//    }
//    
//    
//    /*
//    public ArrayList<Event> getconsulter(int a){       
//        ConnectionRequest con = new ConnectionRequest();
//        con.setUrl("http://localhost/techeventmobile/web/app_dev.php/allevent/"+a+"");  
//        con.addResponseListener(new ActionListener<NetworkEvent>() {
//            @Override
//            public void actionPerformed(NetworkEvent evt) {
//                ServiceEvent ser = new ServiceEvent();
//                listEventa =ser.getListEvent(new String(con.getResponseData()));
//            }
//        });
//        NetworkManager.getInstance().addToQueueAndWait(con);
//        return listEventa;
//    }
//    
//    */
//    
//    
//    
//    
//     public ArrayList<Event> getListEvent(String json) {
//
//        ArrayList<Event> listDemandes = new ArrayList<>();
//
//        try {
//            System.out.println(json);
//            JSONParser j = new JSONParser();
//
//            Map<String, Object> lesDemandes = j.parseJSON(new CharArrayReader(json.toCharArray()));
//            
//           
//            List<Map<String, Object>> list = (List<Map<String, Object>>) lesDemandes.get("root");
//
//            for (Map<String, Object> obj : list) {
//                Event ev = new Event();
//
//                // System.out.println(obj.get("id"));
//              
//              
//                
//                
//                
//                
//                
//                 float id = Float.parseFloat(obj.get("id").toString());
//                int prix = Integer.parseInt(obj.get("prix").toString());
//                   // float iduser = Float.parseFloat(obj.get("User_id").toString());
//                ev.setId((int) id);
//              ev.setPrix((int) prix);
//                //ev.setUser_id((int) iduser);
//             
//               // ev.setId(Integer.parseInt(obj.get("id").toString().trim()));
//               ev.setTitre(obj.get("titre").toString());
//               // ev.setPrix(obj.get("prix").toString());
//               ev.setDescription(obj.get("description").toString());
//              //
//              //ev.setNbrplaces(obj.get("nbrplaces").toString());
//              //  ev.setLocalisation(obj.get("localisation").toString());
//               // ev.setDateevent(obj.get("dateevent").toString());
//              //  ev.setHdebut(obj.get("hdebut").toString());
//              //  ev.setHfin(obj.get("hfin").toString());
//                
//               //  ev.setCategorie(obj.get("categorie").toString());
//               // ev.setType(obj.get("type").toString());
//               
//
//                
//                
//                listDemandes.add(ev);
//
//            }
//
//        } catch (IOException ex) {
//        }
//       
//        return listDemandes;
//
//     }
//     

    public ArrayList<Event> getlistasc() {

        ArrayList<Event> listLivre = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/techeventmobile/web/app_dev.php/Alleventbyprixasec");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();

                try {
                    Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    System.out.println(tasks);
                    //System.out.println(tasks);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
                    for (Map<String, Object> obj : list) {
                        Event l = new Event();
                        float id = Float.parseFloat(obj.get("id").toString());
                        float prix = Float.parseFloat(obj.get("prix").toString());
                        l.setPrix((int) prix);
                        l.setNbrplaces(obj.get("nbrplaces").toString());
                        l.setLocalisation(obj.get("localisation").toString());
                        l.setDateevent(obj.get("dateevent").toString());
                        l.setHdebut(obj.get("hdebut").toString());
                        l.setHfin(obj.get("hfin").toString());
 l.setDescription(obj.get("description").toString());
                        l.setCategorie(obj.get("categorie").toString());
                         l.setAffiche(obj.get("affiche").toString());
                        l.setType(obj.get("type").toString());

                        l.setId((int) id);

                        //l.setImage(obj.get("image").toString());
                        l.setTitre(obj.get("titre").toString());
                        // l.setAuteur(obj.get("auteur").toString());

                        listLivre.add(l);

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listLivre;
    }

    public void modifierEvent(Event a) {
        ConnectionRequest con = new ConnectionRequest();

        String Url = "http://localhost/techeventmobile/web/app_dev.php/modifierevent/" + a.getId() + "?titre=" + a.getTitre() + "&description=" + a.getDescription() + "&nbrpalce=" + a.getNbrplaces() + "&localisation=" + a.getLocalisation() + "&dateevent=" + a.getDateevent() + "&hdebut=" + a.getHdebut() + "&hfin=" + a.getHfin()
                + "&prix=" + a.getPrix() + "&categories=" + a.getCategorie() + "&type=" + a.getType() + "";// création de l'URL
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());

        });
        NetworkManager.getInstance().addToQueueAndWait(con);

    }

    Form f;
    SpanLabel lb;

    public void supprimerEvent(int a) {
        ConnectionRequest con = new ConnectionRequest();

        con.setUrl("http://localhost/techeventmobile/web/app_dev.php/deleteevent/" + a + "");

        NetworkManager.getInstance().addToQueueAndWait(con);

        f = new Form();
        lb = new SpanLabel("");
        f.add(lb);
        ServiceEvent serviceTask = new ServiceEvent();
        lb.setText(serviceTask.getListEvent2().toString());

        f.getToolbar().addCommandToRightBar("back", null, (ev) -> {
            HomeForm h = new HomeForm();
            h.getF().show();
        });
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
}
