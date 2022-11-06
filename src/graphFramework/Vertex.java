package graphFramework;
import java.util.LinkedList;

/*
 *  @authors Fay, Aisha, Woroud
 * B9A
 * CPCS-324
 * Project Code
 * 13th Nov. 2022
 */

public class Vertex {

	// Data Fields
	public int label; // Name of this Vertex
	Boolean isVisited;
	LinkedList<Edge> adjList; // The AdjList of this Vertex

	public Vertex() {
		adjList = new LinkedList<>();
	}

	/**
	 * 
	 * @param label of a vertex
	 */
	public Vertex(int label) {
		this.label = label;
		this.isVisited = false;
		adjList = new LinkedList<>();
	}

	// Methods
	public String displayInfo() {
		return null;
	}

} // End of Class
