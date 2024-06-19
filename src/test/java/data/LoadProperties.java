package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {

	public static Properties envData=
			loadProperities(System.getProperty("user.dir")+"\\src\\test\\java\\propertities\\enviroment.properties");


	private static Properties loadProperities(String path) {
		Properties pro=new Properties();
		try 
		{
			FileInputStream stream=new FileInputStream(path);
			try 
			{
				pro.load(stream);
			} catch (IOException e) 
			{
				System.out.println("error occured:   "+e.getMessage());
			}
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("error occured:   "+e.getMessage());
			
		}
		
		
		return pro;}
}
