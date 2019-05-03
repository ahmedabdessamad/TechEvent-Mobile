/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.codename1.ui.Button;
import static com.codename1.ui.CN.CENTER;
import static com.codename1.ui.CN.SOUTH;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.PickerComponent;
import com.codename1.ui.TextComponent;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.TextModeLayout;
import com.codename1.ui.util.Resources;
import com.codename1.ui.validation.GroupConstraint;
import com.codename1.ui.validation.LengthConstraint;
import com.codename1.ui.validation.RegexConstraint;
import com.codename1.ui.validation.Validator;
import com.codename1.components.FloatingHint;
import com.codename1.components.ImageViewer;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.URLImage;
 


/**
 *
 * @author thepoet
 */
public class Signin extends BaseForm {

    public Signin(Resources res) {
        super(new BorderLayout(BorderLayout.CENTER_BEHAVIOR_CENTER_ABSOLUTE));
       
        setUIID("SignIn");
        EncodedImage palceHolder = EncodedImage.createFromImage(res.getImage("Logo.png").scaled(850, 250), false);
        URLImage urlImage = URLImage.createToStorage(palceHolder, "Logo", "http://localhost/TechEvents/web/assets/images/log.png");
        Label lab = new Label(urlImage, "LogoLabel");
        
       //add(BorderLayout.NORTH, new Label(res.getImage("Logo.png"), "LogoLabel"));
       
       //TextComponent username = new TextComponent().label("Username");
       TextField username = new TextField("", "Username", 40, TextField.ANY);
        TextField password = new TextField("", "Password", 40, TextField.PASSWORD);
        username.setSingleLineTextArea(false);
        password.setSingleLineTextArea(false);
        Button signIn = new Button("Sign In");
        Button signUp = new Button("Sign Up");
        signUp.addActionListener(e -> new SignUpForm(res).show());
        signUp.setUIID("Link");
        Label doneHaveAnAccount = new Label("Don't have an account?");
        
        Label loginIcon = new Label("", "TextField");
        Label passwordIcon = new Label("", "TextField");
        
        FontImage.setMaterialIcon(loginIcon, FontImage.MATERIAL_PERSON_OUTLINE, 3);
        FontImage.setMaterialIcon(passwordIcon, FontImage.MATERIAL_LOCK_OUTLINE, 3);
        
        Container content = BoxLayout.encloseY(
                lab,
                createLineSeparator(),
                BorderLayout.center(new FloatingHint (username)).add(BorderLayout.WEST, loginIcon),
                createLineSeparator(),
                BorderLayout.center(new FloatingHint(password)).add(BorderLayout.WEST, passwordIcon),
                createLineSeparator(),
                signIn,
                FlowLayout.encloseCenter(doneHaveAnAccount, signUp)
        );
        
        add(BorderLayout.CENTER, content);
        signIn.requestFocus();
        
      // if  (loginIcon.getText().equals("ahmed") && passwordIcon.getText().equals("ahmed")) {
        signIn.addActionListener(
                // if  (loginIcon.getText().equals("ahmed") && passwordIcon.getText().equals("ahmed")) {
                e -> new ProfileForm(res).show()
        
        );
    //  else {
      //  Dialog.show(" ", "mot de passe ou usename 8alét", "OK", null);
     // }
    
    }
   
    
    
    //}
      
         
   // }
    
     
}
