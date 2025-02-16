package MODEL;

    public class Usersesion {
        static int Id = -1;
        public static void new_session(int ID){
            Id = ID;
        }
        public static int idsession(){
            return Id;
        }

        public static String getname()
        {
            return Uerservice.getname(Id);
        }
 }

    
