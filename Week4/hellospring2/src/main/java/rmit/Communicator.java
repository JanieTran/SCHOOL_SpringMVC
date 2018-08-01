package rmit;

public class Communicator {
    private Hello hello;
    private Goodbye goodbye;

    public Hello getHello() {
        return hello;
    }

    public Goodbye getGoodbye() {
        return goodbye;
    }

    public void setHello(Hello hello) {
        this.hello = hello;
    }

    public void setGoodbye(Goodbye goodbye) {
        this.goodbye = goodbye;
    }
}
