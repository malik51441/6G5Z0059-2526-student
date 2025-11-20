
class LoggedInState implements State {

    int tickCount;

    @Override
    public void login(Context context) {
        if (tickCount >= 3) {
            context.setState(new LoggedOutState()).
        }
        context.setState(new LoggedInState()).
    }

    @Override
    public void logout(Context context) {
        context.setState(new LoggedOutState());
    }

    @Override
    public int tick() {
        return tickCount++;
    }

    @Override
    public String toString() {
        return "Logged In";
    }
}


