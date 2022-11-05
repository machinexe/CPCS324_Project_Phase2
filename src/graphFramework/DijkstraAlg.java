package graphFramework;

import java.util.Iterator;

/*
 *  @authors Fay, Aisha, Woroud
 * B9A
 * CPCS-324
 * Project Code
 * 13th Nov. 2022
 */

public class DijkstraAlg {

	// Data Fields
	int[] distance;
	String[] path;
	Graph graph;
	int infinity = Integer.MAX_VALUE; // Hold max value

	public DijkstraAlg(Graph graph) {
		this.graph = graph;
	}

	public void computeDijkstraAlg(Graph graph) {

		// Get distance array to calculate cost & Get path array to collect path passed
		distance = new int[graph.vertices.length]; // Hold the shortest distance from source to each vertex
		path = new String[graph.vertices.length]; // Hold the vertices path from the source to the vertex

		// Update all the vertices distance as infinity -- to set it later to minimum
		// distance as needed
		for (int i = 0; i < graph.vertices.length; i++) {
			distance[i] = infinity;
		}

		/**
		 * Vertex[0] requirements: distance of 0 path of the 1st vertex name
		 */
		distance[0] = 0;// Distance of source vertex from itself is always 0
		Vertex src = graph.vertices[0].adjList.get(0).source; // Get the source Vertex
		path[0] = src.displayInfo(); // Hold 1st source as override output of the path

		// Loop Through the array
		for (int i = 0; i < graph.vertices.length - 1; i++) {
			int u = minDistance(distance); // Pick the minimum distance vertex from the set of not visited vertices
			graph.vertices[u].isVisited = true;// Mark the picked vertex as visited

			Iterator<Edge> iterate = graph.vertices[u].adjList.iterator(); // Iterate through all neighbors

			while (iterate.hasNext()) {
				Edge edge = iterate.next();

				/**
				 * Continue only if: 1. Vertex not visited 2. its weight is set by the
				 * (minDistance) method 3. its weight not zero (because 0 is only for 1st
				 * Vertex)
				 */
				if (graph.vertices[edge.target.label].isVisited != true && edge.weight != infinity
						&& edge.weight != 0) {
					/**
					 * Continue only if: current distance (current minimum distance) + current
					 * iterated edge is -> smaller than the target distance if the target location
					 * in array distance is set, meaning it applicable of the condition if not then
					 * its still (maybe) max value or just bigger
					 */
					if (distance[u] + edge.weight < distance[edge.target.label]) {
						// Update both distance array and path array

						distance[edge.target.label] = distance[u] + edge.weight; // Update the target location to the
																					// new one minimum distance
						path[edge.target.label] = path[u] + " – " + edge.target.displayInfo(); // Add the target
																								// location info to the
																								// array path

					} // End of inner if-statement
				} // End of outer if-statement
			} // End of the Iterator loop
		} // End of for loop
	} // End of method

	/**
	 * 
	 * @param smallestDistance
	 * @return
	 */
	public int minDistance(int[] smallestDistance) {
		int u = 0;
		int minDistance = Integer.MAX_VALUE;

		// Loop through all vertices
		for (int i = 0; i < graph.vertices.length; i++) {
			// The vertex must be not visited and its less than the minimum distance
			if (graph.vertices[i].isVisited != true && smallestDistance[i] < minDistance) {
				minDistance = smallestDistance[i]; // The new minimum distance
				u = i; // Minimum vertex index
			}
		}
		return u;
	}

	// Print output as required
	public void printResult() {
		String routerName = String.valueOf((char) (graph.vertices[0].label + 65));
		System.out.println("The source router is " + routerName);
		System.out.println("\nThe paths from router " + routerName + " to the rest of the routers are:");

		// Start loop from 1 to ignore 1st Vertex
		for (int i = 1; i < graph.verticesNO; i++) {
			System.out.println("\n" + path[i] + " route length: " + distance[i]); // Print linked path and final cost
																					// sequentially
		} // End of for loop
	} // End of method

} // End of Class
