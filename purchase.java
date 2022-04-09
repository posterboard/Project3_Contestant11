/* Purchase Class
 * Purpose-to consolidate different ints and doubles into a single object foro easy access during calculation.
 * Includes constructor and getter methods
 * */
public class Purchase {
	private int orch,mezz,balc;
	private double sales;
	public Purchase(int orch, int mezz, int balc,double sales) {
		this.orch = orch;
		this.mezz = mezz;
		this.balc = balc;
		this.sales = sales;
	}
	public int getOrchestraCount() {
		return orch;
	}
	public int getMezzanineCount() {
		return mezz;
	}
	public int getBalconyCount() {
		return balc;
	}
	public double getSales() {
		return sales;
	}
}
