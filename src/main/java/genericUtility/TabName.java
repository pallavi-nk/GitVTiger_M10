package genericUtility;
/**
 * this enum stores all the tab names of vtiger application
 * @author sncsr
 */
public enum TabName {
	ORGANIZATION("Accounts"), CONTACTS("contacts"), LEADS("Leads");
	private String tabname;
	
	private TabName(String tabname) {
		this.tabname = tabname;
	}
	public String getTabName() {
		return tabname;
	}
	

}
