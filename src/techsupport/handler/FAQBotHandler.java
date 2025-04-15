package techsupport.handler;

import techsupport.handler.AbstractSupportHandler;

public class FAQBotHandler extends AbstractSupportHandler {
    @Override
    public void handle(String issue) {
        if (issue.equals("password_reset")) {
            System.out.println("[FAQBot] Handled " + issue);
        } else {
            passToNext(issue);
        }
    }
}

