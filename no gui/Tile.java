public class Tile {
    private Terrain e;
	private Animal a;
    private int x;
    private int y;

	public Tile(Animal a, int x, int y)
    {
        this.a = a;
        this.x = x;
        this.y = y;
		this.e = null;
    }
	
    public Tile(Terrain e, int x, int y)
    {
        this.e = e;
        this.x = x;
        this.y = y;
		this.a = null;
    }
	
	public Tile()
    {
        this.e = null;
		this.a = null;
    }
	
    public Entity getTerrain()
    {
        return e;
    }
	
	public Animal getAnimal()
    {
        return a;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }
	
	public String toString()
	{
		if (getTerrain() != null)
			return e.toString();
		else
			return a.toString();
	}
	
	public boolean isRiver(int x, int y){
		if (x == 1 || x == 2 || x == 4 || x == 5){
			if (y == 3 || y == 4 || y == 5)
				return true;
		}
		return false;
	}
	
	public int isTrap(int x, int y){
		if(x == 2 && y == 0 ||  x == 4 && y == 0 || x == 3 && y == 1)
			return 1;
		if(x == 2 && y == 8 ||  x == 4 && y == 8 || x == 3 && y == 7)
			return 2;
		
		return 0;
	}
}
