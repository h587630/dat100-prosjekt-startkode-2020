package no.hvl.dat100ptc.oppgave3;

import static java.lang.Math.*;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSUtils {

	public static double findMax(double[] da) {

		double max; 
		
		max = da[0];
		
		for (double d : da) {
			if (d > max) {
				max = d;
			}
		}
		
		return max;
	}

	public static double findMin(double[] da) {

		double min;

		min = da[0];
		
		for (double d : da) {
			if (d < min) {
				min= d;
			}
		}
		
		return min;

	}
	//Implementer metoden,som tar en tabell med GPS punkter som parameter
	//og returnerer en tabell av desimaltall inneholdende breddegradene for GPS-punktene.
	public static double[] getLatitudes(GPSPoint[] gpspoints) {
		
		double[]nygpspoint= new double[gpspoints.length];
		for(int i=0; i<gpspoints.length; i++) {
		nygpspoint[i]= gpspoints[i].getLatitude();
		
		}
		
		return nygpspoint;
	}

	public static double[] getLongitudes(GPSPoint[] gpspoints) {
		double[]nygpspoint= new double[gpspoints.length];
		for(int i=0; i<gpspoints.length; i++) {
		nygpspoint[i]= gpspoints[i].getLongitude();
		
		}
		
		return nygpspoint;
		
	}

	private static int R = 6371000; // jordens radius

	public static double distance(GPSPoint gpspoint1, GPSPoint gpspoint2) {

	
		double latitude1, longitude1, latitude2, longitude2;
		latitude1=Math.toRadians(gpspoint1.getLatitude());
		latitude2=Math.toRadians(gpspoint2.getLatitude());
		longitude1=Math.toRadians(gpspoint1.getLongitude());
		longitude2=Math.toRadians(gpspoint2.getLongitude());
		double deltalatitude=latitude2-latitude1;
		double deltalongitude=longitude2-longitude1;
		double a=pow(sin(deltalatitude/2),2)+cos(latitude1)*cos(latitude2)*pow(sin(deltalongitude/2),2);
		double c=2*atan2(sqrt(a), sqrt(1-a));
		double distance= R *c;
		
		return distance;
		
	}

	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {

//		// speed = distance/tid
//		//distance = distance(gpspoint2,gpspoint1)
//		speed=distance(gpspoint1,gpspoint2)/time
		int secs;
		int time1 = gpspoint1.getTime();
		int time2 = gpspoint2.getTime();
		secs = (time2 - time1);
		double d = GPSUtils.distance(gpspoint1, gpspoint2);

		double speed = ((d/secs) * 3600)/1000;
		//hvorfor dele på 1000.
     return speed;

	}

	public static String formatTime(int secs) {

		String timestr;
		String TIMESEP = ":";
		int hr=secs/3600;
		int hrrest=secs % 3600;
		int min=hrrest/60;
		int minrest=hrrest % 60;
		int sec= minrest;
		
		String hr1=""+hr;
		String min1=""+min;
		String sec1=""+sec;
		
		if(hr<10) hr1="0"+hr;
		
		if(min<10) min1="0"+min;	
		if(sec<10) sec1="0"+sec;
		
		timestr= hr1+TIMESEP+min1+TIMESEP+sec1;
		String s="";
		for(int i=0;i<=10-timestr.length();i++ ) {
			s+=" ";		
		}
		return s+timestr;	
		

        
		
			

	}
	private static int TEXTWIDTH = 10;

	public static String formatDouble(double d) {
//		double round=Math.round(d*100)/100;
//		String str=""+ round ;
//		String s="";
//	for(int i=0;i<=TEXTWIDTH-str.length();i++ ) {
//			
//			s +=" ";		
//		}
//		return s+str;
		String str = String.format("%10.2f", d);
		return str;
	}
}
