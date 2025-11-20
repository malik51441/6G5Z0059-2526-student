class LoggedOutState implements State {
    @Override
    public void login(Context context) {
        context.setState(new LoggedInState());
    }

    @Override
    public void logout(Context context) {
        //already logged out
    }

    @Override
    public String toString() {
        return "Logged Out";
    }
}