package sample;

public class Test2 {
    public static void main(String[] args) {
       // System.out.println(UserContainer.getCustomerUsersList());
        User user = new CustomerUser("", "",1,"","ahmet") ;
        System.out.println(user.getUsername());
    }
}
