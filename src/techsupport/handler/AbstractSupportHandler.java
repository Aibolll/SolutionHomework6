package techsupport.handler;

public abstract class AbstractSupportHandler implements SupportHandler {
    protected SupportHandler next;

    @Override
    public SupportHandler setNext(SupportHandler handler) {
        this.next = handler;
        return handler;
    }

    protected void passToNext(String issue) {
        if (next != null) {
            next.handle(issue);
        } else {
            System.out.println("[Support] Cannot handle " + issue + " — escalate manually");
        }
    }
}

