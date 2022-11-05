
package LSRoutingApp;

import graphFramework.Vertex;

/*
 *  @authors Fay, Aisha, Woroud
 * B9A
 * CPCS-324
 * Project Code
 * 13th Nov. 2022
 */

public class Router extends Vertex {

	// Data Fields
	private String routerName;

	public Router(int label) {
		super(label);
		this.routerName = String.valueOf((char) (label + 65));
	}

	// Methods
	@Override
	public String displayInfo() {

		return "Rt." + routerName;

	} // End of method

} // End of class
