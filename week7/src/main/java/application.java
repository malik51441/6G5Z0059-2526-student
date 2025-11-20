public class application {
    public static void main(String[] args) {
        AuthenticationContext context = new AuthenticationContext();
        System.out.format("User is %s%n", context.getStatus());

        System.out.format("Login%n");
        context.login();
        System.out.format("User is %s%n", context.getStatus());

        System.out.format("Login when already logged in%n");
        context.login();
        System.out.format("User is %s%n", context.getStatus());

        System.out.format("Logout%n");
        context.logout();
        System.out.format("User is %s%n", context.getStatus());

        System.out.format("Logout when already logged out%n");
        context.logout();
        System.out.format("User is %s%n", context.getStatus());

        System.out.println();    }
}