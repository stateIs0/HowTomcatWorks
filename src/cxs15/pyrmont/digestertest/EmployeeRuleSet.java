package src.cxs15.pyrmont.digestertest;

import org.apache.commons.digester.Digester;
import org.apache.commons.digester.RuleSetBase;

public class EmployeeRuleSet extends RuleSetBase  {
  public void addRuleInstances(Digester digester) {
    // add rules
    digester.addObjectCreate("employee", "Employee");
    digester.addSetProperties("employee");    
    digester.addObjectCreate("employee/office", "Office");
    digester.addSetProperties("employee/office");
    digester.addSetNext("employee/office", "addOffice");
    digester.addObjectCreate("employee/office/address", 
      "Address");
    digester.addSetProperties("employee/office/address");
    digester.addSetNext("employee/office/address", "setAddress"); 
  }
}
