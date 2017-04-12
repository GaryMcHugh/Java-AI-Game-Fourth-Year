package ie.gmit.sw.ai.maze;

public interface MazeGenerator 
{
	
	void init();
	void addFeature(char feature, char replace, int number);
	void buildMaze();
	int size();
	char get(int i, int j);
	void set(int currentRow, int currentCol, char c);

}// End interface MazeGenerator
