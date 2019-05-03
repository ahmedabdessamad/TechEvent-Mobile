/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Form;
import com.techevent.Services.ServiceClub;
import com.techevent.Services.ServiceEvent;
import com.techevent.Services.ServiceInteresser;

/**
 *
 * @author Ahmed Abdessamed
 */
public class AffichageMesEvent {
    
     Form f;
    SpanLabel lb;
  
    public AffichageMesEvent() {
         
        f = new Form();
        lb = new SpanLabel("");
        f.add(lb);
        ServiceClub serviceTask =new ServiceClub();
        lb.setText(serviceTask.getListEventClub(17).toString());
        
          f.getToolbar().addCommandToRightBar("back", null, (ev)->{HomeForm h=new HomeForm();
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
