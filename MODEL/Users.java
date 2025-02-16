package MODEL;

public class Users {
    private String Acccount;
    private String Password;
    private String Name;
    private String Codebank;
    private String Email;
    private int Id;
    private double Balance;

    Users(){}

    public Users(String Acccount ,  String Password , String Name , String Codebank , String Email ){
        this.Acccount = Acccount;
        this.Codebank = Codebank;
        this.Email = Email;
        this.Name = Name;
        this.Password = Password;
    }

    public String getAcccount() {
        return Acccount;
    }
    public double getBalance() {
        return Balance;
    }
    public String getCodebank() {
        return Codebank;
    }
    public String getEmail() {
        return Email;
    }
    public int getId() {
        return Id;
    }
    public String getName() {
        return Name;
    }
    public String getPassword() {
        return Password;
    }
    
    // set

    public void setAcccount(String acccount) {
        Acccount = acccount;
    }
    public void setBalance(double balance) {
        Balance = balance;
    }
    public void setCodebank(String codebank) {
        Codebank = codebank;
    }
    public void setEmail(String email) {
        Email = email;
    }
    public void setId(int id) {
        Id = id;
    }
    public void setName(String name) {
        Name = name;
    }
    public void setPassword(String password) {
        Password = password;
    }
    
}
