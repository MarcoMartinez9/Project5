/*
 * This class is the public class that is used to find the caluclated
 * average of the given station name. It has a method named calAverage 
 * that can be called when creating a MesoAscii object.
 * This method also extends to MesoAsciiAbstract.
 * 
 * @author Marco Martinez
 * @version 2019-03-30
 */
public class MesoAscii extends MesoAsciiAbstract {

	private String StID;
	
	public MesoAscii(MesoStation mesoStation) 
	{
		this.StID = mesoStation.getStID();
	}

	@Override
	public int calAverage() 
	{
		double sum = 0;
		
		for(int i = 0; i < StID.length(); ++i)
		{
		sum = sum + StID.charAt(i);
		}
		
		sum = sum/StID.length();
		int average = (int)Math.round(sum);
		return average;
	}
	
}