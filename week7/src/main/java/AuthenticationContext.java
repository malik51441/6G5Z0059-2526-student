class AuthenticationContext implements Context {

    private  State currentState;

    public AuthenticationContext () {
        this.currentState = new LoggedOutState();
    }

    public void login() {
        currentState.login(this);
    }
    public void tick() {
        currentState.tick(this);
    }

    public void logout() {
        currentState.logout(this);
    }

    @Override
    public void setState(State state) {
        this.currentState = state;
    }

    public String getStatus() {
       return  currentState.toString();
    }
}