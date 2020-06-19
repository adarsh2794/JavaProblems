package com.example.geektrust;


import com.example.geektrust.helpers.TrafficTimeHelper;
import com.example.geektrust.models.Vehicles;
import com.example.geektrust.models.Weather;
import com.example.geektrust.orbit.Orbit1;
import com.example.geektrust.orbit.Orbit2;
import com.example.geektrust.utils.ProcessInput;
import com.example.geektrust.utils.ReadFile;

public class GeekTrustApplication {

	public static void main(String[] args) throws Exception {

		ReadFile readFile = new ReadFile();
		String filename = "";
		if(args.length>0)
		{
			if (args[0] != null)
				filename = args[0];
		}
		String input1  = readFile.readFileAsString(filename);
		PossiblePath possiblePath = new PossiblePath(new Weather(), new ProcessInput(), new Orbit1(null),new Orbit2(null),new Vehicles(),new TrafficTimeHelper());
		System.out.println( possiblePath.getPossiblePath(input1));

	}

}
