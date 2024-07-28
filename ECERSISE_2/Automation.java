import java.util.ArrayList;
import java.util.List;

public class Automation {
    private List<AutomationRule> rules;

    public Automation() {
        rules = new ArrayList<>();
    }

    public void addRule(AutomationRule rule) {
        rules.add(rule);
    }

    public void evaluateRules() {
        for (AutomationRule rule : rules) {
            rule.execute();
        }
    }
}
