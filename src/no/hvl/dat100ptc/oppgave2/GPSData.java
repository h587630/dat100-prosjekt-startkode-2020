package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSData {

	private GPSPoint[] gpspoints;
	protected int antall = 0;

	public GPSData(int n) {
		this.gpspoints=new GPSPoint[n];
		
	}

	public GPSPoint[] getGPSPoints() {
		return this.gpspoints;
	}
	
	
	protected boolean insertGPS(GPSPoint gpspoint) {

		boolean inserted = false;

		if(antall<this.gpspoints.length) {
			inserted=true;
			gpspoints[antall]=gpspoint;
		antall++;
		
		}
		return inserted;
			
	}

	public boolean insert(String time, String latitude, String longitude, String elevation) {

		GPSPoint gpspoint= GPSDataConverter.convert(time,latitude,longitude, elevation);
			boolean insert=insertGPS(gpspoint);
		return insert;
			
	}

	public void print() {

		System.out.println("====== Konvertert GPS Data - START ======");
		for(GPSPoint g: gpspoints)
			System.out.println(g.toString());
		 System.out.println("====== Konvertert GPS Data - SLUTT ======");

	}
}
