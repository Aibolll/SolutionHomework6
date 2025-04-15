package techsupport.handler;

public interface SupportHandler {
    SupportHandler setNext(SupportHandler handler);
    void handle(String issue);
}
