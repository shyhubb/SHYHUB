
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.IOException;
import MODEL.*;
public class Controller  {
    
    @FXML
     TextField ACCOUNT;
    @FXML
     PasswordField PASSWORD;
    @FXML
    Label statuslogin;

    @FXML
    TextField accounttext;
    @FXML
    TextField passwordtext;
    @FXML
    TextField nametext;
    @FXML
    TextField emailtext;
    @FXML
    TextField codebanktext;
    @FXML
    Label accstatus;
    @FXML
    Button regis;

    @FXML
    Label balance;
    @FXML
    Label namelable;

    @FXML
    Label ruttext;
    @FXML
    Label naptext;
    @FXML
    TextField napip;
    @FXML
    TextField rutip;
    

    public void Login(ActionEvent event) {
      String Acc = ACCOUNT.getText();
      String Pass = PASSWORD.getText();
      Stage now = (Stage) ACCOUNT.getScene().getWindow();

      if (Uerservice.login(Acc, Pass)) {
        Usersesion.new_session( Uerservice.get_id(Acc, Pass));
          try {
              Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
              Scene scene = new Scene(root);
              now.setScene(scene);
              
              
          } catch (Exception e) {
              e.printStackTrace();
          }
      } else {
          statuslogin.setText("ERROR: ĐĂNG NHẬP THẤT BẠI");
      }
  }
   
     // go register Scence
    public void Register(ActionEvent event){
        Stage window = (Stage) ACCOUNT.getScene().getWindow();
        Scene scene;
        try {
            Parent root = FXMLLoader.load(getClass().getResource("register.fxml"));
            scene = new Scene(root);
            window.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // back login Scence
    public void return_login(ActionEvent event){
      Stage window = (Stage) regis.getScene().getWindow();
      Scene scene;
      try {
          Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
          scene = new Scene(root);
          window.setScene(scene);
      } catch (IOException e) {
          e.printStackTrace();
      }
     }

     public void create_account(ActionEvent event){
      String account = accounttext.getText();
      String pass = passwordtext.getText();
      String name = nametext.getText();
      String email = emailtext.getText();
      String codebank = codebanktext.getText();

      Users user = new Users(account , pass, name, codebank , email);
      boolean checkip = (account.isEmpty() || pass.isEmpty() || name.isEmpty() || email.isEmpty() || codebank.isEmpty());
      if(checkip){
        accstatus.setStyle("-fx-text-fill: red;");
        accstatus.setText("VUI LÒNG NHẬP ĐỦ THÔNG TIN VÀ THỦ LẠI :]");
      }else{
        if( Uerservice.new_acount(user)){
          accstatus.setText("TẠO TÀI KHOẢN THÀNH CÔNG <3 ENJOY NOW");
       }else{
         accstatus.setText("TAỌ TÀI KHOẢN THẤT BẠI :]");
       }
      }
     }
     
     public void loadbalance(ActionEvent event){
          double money = (double)Uerservice.get_balance(Usersesion.idsession());
          balance.setText(money +" $");
          namelable.setText(Uerservice.getname(Usersesion.idsession()));
     }

     public void nap(ActionEvent event) {
      // Hiển thị yêu cầu nhập số tiền
      naptext.setText("NHAP SO TIEN CAN NAP");
  
      try {
          // Kiểm tra và chuyển đổi giá trị nhập vào thành số double
          double money = Double.parseDouble(napip.getText());
  
          // Kiểm tra số tiền có hợp lệ hay không (ví dụ: không âm)
          if (money <= 0) {
              nametext.setText("Số tiền phải lớn hơn 0.");
          } else {
              // Gọi phương thức để nạp tiền vào tài khoản của người dùng
              Uerservice.get_money(Usersesion.idsession(), money);
              nametext.setText("NAP THANH CONG " + money + " $");
          }
      } catch (NumberFormatException e) {
          // Xử lý nếu người dùng nhập không phải là một số hợp lệ
          nametext.setText("Vui lòng nhập một số hợp lệ.");
      }
  }
  

     public void rut(ActionEvent event){

     }
}