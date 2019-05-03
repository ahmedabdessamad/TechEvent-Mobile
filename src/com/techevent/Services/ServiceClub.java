/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.techevent.Services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionListener;
import com.techevent.entities.Event;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Ahmed Abdessamed
 */
public class ServiceClub {
    
    
    
     ArrayList<Event> listEvent = new ArrayList<>();
       ArrayList<Event> mesEvent = new ArrayList<>();
    
    
//     public ArrayList<Event> getListEventClub(int a){       
//         
//          
//        ConnectionRequest con = new ConnectionRequest();
//        con.setUrl("http://localhost/techeventmobile/web/app_dev.php/alleventclub/"+a+"");  
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
//                 float id = Float.parseFloat(obj.get("id").toString());
//                 //float prix = Float.parseFloat(obj.get("prix").toString());
//                   // float iduser = Float.parseFloat(obj.get("User_id").toString());
//                ev.setId((int) id);
//                //ev.setPrix((int) prix);
//                //ev.setUser_id((int) iduser);
//               
//               // ev.setId(Integer.parseInt(obj.get("id").toString().trim()));
//                ev.setTitre(obj.get("titre").toString());
//               ev.setDescription(obj.get("description").toString());
//              // ev.setNbrplaces(obj.get("nbrplaces").toString());
//              //  ev.setLocalisation(obj.get("localisation").toString());
//              //  ev.setDateevent(obj.get("dateevent").toString());
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
    public ArrayList<Event> getListEventClub(int a) {

        ArrayList<Event> listLivre = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
       con.setUrl("http://localhost/techeventmobile/web/app_dev.php/alleventclub/"+a+"");
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
                        l.setPrix((int)prix);
  l.setNbrplaces(obj.get("nbrplaces").toString());
                l.setLocalisation(obj.get("localisation").toString());
                   l.setDescription(obj.get("description").toString());
                l.setDateevent(obj.get("dateevent").toString());
                l.setHdebut(obj.get("hdebut").toString());
                l.setHfin(obj.get("hfin").toString());
                
                 l.setCategorie(obj.get("categorie").toString());
                   l.setAffiche(obj.get("affiche").toString());
                l.setType(obj.get("type").toString());

                        l.setId((int)id);
                        
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
  Form f;
     
      public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
}
