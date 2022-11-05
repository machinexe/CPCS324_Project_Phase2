
package LSRoutingApp;

import graphFramework.Edge;
import graphFramework.Graph;
import graphFramework.Vertex;

/*
 *  @authors Fay, Aisha, Woroud
 * B9A
 * CPCS-324
 * Project Code
 * 13th Nov. 2022
 */

public class Map extends Graph {

	public Map() {
		// TODO Auto-generated constructor stub
	}

	// Create Vertex
	@Override
	public Vertex createVertex(int label) {
		return new Router(label);
	}

	// Create Edge
	@Override
	public Edge createEdge(Vertex source, Vertex target, int weight) {
		return new Path(source, target, weight);
	}

}