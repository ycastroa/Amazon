package amazon;
import java.util.Queue;
import java.util.LinkedList;
public class testTrans {
	private final static int DESTINATION = 9;
	private final static int BLOCKED =0;
	public static void main(String[] args) {
		
		
		int[][] area =	{{1,1,0},
			       		{1,0,1},
			       		{1,0,9}};
		System.out.println(shortestPath(area));
		
	}
	public static int shortestPath(int[][] area) {
		// by default the values are false
		boolean[][] visited = new boolean[area[0].length][area.length];
		//1.- find destinations's coordinate
		int xy[] = findDestCoordinate(area);
		int xC = xy[0];
		int yC = xy[1];
		//2.- Create a class Note
		Queue<aNode> locations= new LinkedList<aNode>();
		// use bfs algo
		if(area.length >0) { //if the 
			locations.add(new aNode(0,0,0));
			
			while(!locations.isEmpty()) {
				aNode pop = locations.remove();
				if(area[pop.x][pop.y]== area[xC][yC]){
					return pop.distance;
				}
				/*/
				 * when the move through the matrix you have for options
				 * move up, down, right or left
				 */
				//move up
				if(canMove(pop.x-1,pop.y,area,visited)) {
					//mark as visited
					locations.add(new aNode(pop.x-1,pop.y,pop.distance +1));
					visited[pop.x-1][pop.y]= true;
				}
				//move down
				if(canMove(pop.x+1,pop.y,area,visited)) {
					//mark as visited
					locations.add(new aNode(pop.x+1,pop.y,pop.distance +1));
					visited[pop.x+1][pop.y]= true;
					
				}
				//move right
				if(canMove(pop.x,pop.y+1,area,visited)) {
					//mark as visited
					locations.add(new aNode(pop.x,pop.y+1,pop.distance +1));
					visited[pop.x][pop.y+1]= true;
				}
				//move left
				if(canMove(pop.x,pop.y-1,area,visited)) {
					//mark as visited
					locations.add(new aNode(pop.x,pop.y-1,pop.distance +1));
					visited[pop.x][pop.y-1]= true;
				}
			}
		}
		return -1;
	}
	//check if can move to location
	public static boolean canMove(int x, int y,int[][] area, boolean[][] visited) {
		// check if visited , x and y more or equal than 0 and if y and x are less than the row and column lenght
		if(y >= 0 && y < area[0].length && x>=0 && x < area.length ) {
			if(visited[x][y] == false && area[x][y]!= BLOCKED) // put this in here to avoid out of bound error
				return true;
		}
		else {
			return false;
		}
		return false;

	}
	//find destinations's coordinate
	public static int[] findDestCoordinate(int[][] area) {
		int xy[] = new int[2];
		int x =0;
		while(x < area[x].length) {
			int y =0;
			while(y < area.length) {
				if(area[x][y] == DESTINATION) {
					xy[0] = x;
					xy[1] = y;
					return xy;
				}
				y++;
			}
			x++;
		}
		return xy;
	}
}

class aNode{
	int x;
	int y;
	int distance;
	public aNode(int x, int y ,int distance) {
		this.x =x;
		this.y =y;
		this.distance = distance;
	}
}
