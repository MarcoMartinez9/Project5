import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class HammingDistance {

	private String station1;
	
	private String station2;
	
	private int distance;
	
	private ArrayList <String> stationNames = new ArrayList <String>();
	
	public HammingDistance(String station1, String station2) throws IOException
	{
		this.station1 = station1;
			
		this.station2 = station2;
		
		readFile();
	}
	
	public void readFile() throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader("Mesonet.txt"));
		
		String strg = br.readLine();
		
		while(strg != null)
		{
			stationNames.add(strg);
			strg = br.readLine();
		}
		br.close();
	
	}
	
	public int HammingDist() 
	{
		int distance = 0; 
		
		for(int index = 0; index < this.station1.length(); ++index)
		{
			if(this.station1.charAt(index) != this.station2.charAt(index))
			{
				++distance;
			}
		}
		return distance;
	}
}
