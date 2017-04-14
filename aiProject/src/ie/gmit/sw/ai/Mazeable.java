package ie.gmit.sw.ai;

// Interface Mazeable used to keep the program loosely coupled
// Provides the methods that all mazes will need to have
public interface Mazeable 
{

	void init();

	void addFeature(char feature, char replace, int number);

	void buildMaze();

	char get(int row, int col);

	void set(int row, int col, char c);

	int size();

}// End interface Mazeable