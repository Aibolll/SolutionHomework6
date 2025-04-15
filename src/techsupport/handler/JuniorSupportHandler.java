package techsupport.handler;

import techsupport.handler.AbstractSupportHandler;

public class JuniorSupportHandler extends AbstractSupportHandler {
    @Override
    public void handle(String issue) {
        if (issue.equals("refund_request") || issue.equals("billing_issue")) {
            System.out.println("[JuniorSupport] Handled " + issue);
        } else {
            passToNext(issue);
        }
    }
}


