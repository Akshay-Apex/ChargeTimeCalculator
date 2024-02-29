/**
 * Date: 27-02-2024 
 * 
 * @author: Akshay Karunakar Naik
 */

package ChargeTimeCalculator;
import java.util.Scanner;
 
public class ChargeTimeCalc {				
	public static void main(String[] args) {	
		Scanner scan = new Scanner(System.in);
		byte currentChargePer, charge15Min, chargePerReq, offset, negOffset;
		currentChargePer = charge15Min = chargePerReq = offset = negOffset = 0;		
		int hours, minutes, seconds;		
		hours = minutes = seconds = 0;
		float total = 0.0f, time = 0.0f;		
		String scanReq = "", calcMode = "";
				
		while (true) {								
			if (calcMode == "") {				
				System.out.print("Choose the \"Calculation\" mode, what do you want percentage or time [p, t]: ");
				calcMode = scan.nextLine();				
				if (calcMode.equals("p") || calcMode.equals("P")) {
					calcMode = "percentage";
				} else if (calcMode.equals("t") || calcMode.equals("T")) {
					calcMode = "time";
				}
			} 
											
			//Error handling for choosingCalcMode
			if (!calcMode.equals("percentage") == !calcMode.equals("time")) {
				System.out.println("\n+-------------WARNING!-------------+\n"
								   + "| Please enter the given keyword!  |\n"
								   + "+----------------------------------+\n");				
				calcMode = "";
				continue;
			}
			
			switch (scanReq) {
				case "currentChargePer":					
					System.out.print("Enter the remaining charge percentage: ");
					currentChargePer = scan.nextByte();				
					break;
				case "charge15Min":					
					System.out.print("Enter the percentage your device can charge upto in 15 min: ");
					charge15Min = scan.nextByte();				
					break;
				case "chargePerReq":					
					System.out.print("Enter the maximum charge percentage you require: ");
					chargePerReq = scan.nextByte();									
					break;
				case "offset":					
					System.out.print("Enter the offset percentage: ");
					offset = scan.nextByte();				
					break;
				case "negOffset":					
					System.out.print("Enter the negative offset percentage: ");
					negOffset = scan.nextByte();				
					break;
				case "hours":										
					System.out.print("Enter hours: ");
					hours = scan.nextInt();
					break;
				case "minutes":
					System.out.print("Enter minutes: ");
					minutes = scan.nextInt();
					break;
				case "seconds":
					System.out.print("Enter seconds: ");
					seconds = scan.nextInt();				
					break;
				default:
					System.out.print("Enter the remaining charge percentage: ");
					currentChargePer = scan.nextByte();
					System.out.print("Enter the percentage your device can charge upto in 15 min: ");
					charge15Min = scan.nextByte();
					
					if (calcMode.equals("time")) {
						System.out.print("Enter the maximum charge percentage you require: ");
						chargePerReq = scan.nextByte();		
						System.out.print("Enter the offset percentage: ");
						offset = scan.nextByte();	
					} else if (calcMode.equals("percentage")) {						
						System.out.println("Enter the maximum time you have to charge your device: ");
						System.out.print("Enter hours: ");
						hours = scan.nextInt();
						System.out.print("Enter minutes: ");
						minutes = scan.nextInt();
						System.out.print("Enter seconds: ");
						seconds = scan.nextInt();					
					}																	
			}			
			
			
			//Checks if the entered values are correct 
			if (currentChargePer < 0 || currentChargePer > 100) {
				
				if (currentChargePer > 100) {
					System.out.println("\n+--------------ERROR!--------------+\n"
									   + "| The remaining charge percentage  |\n"
									   + "| cant't be greater than 100       |\n"
									   + "| (hundred) !                      |\n"							 
									   + "+----------------------------------+\n");
					scanReq = "currentChargePer";
					continue;
				}
				
				System.out.println("\n+--------------ERROR!--------------+\n"
								   + "| The remaining charge percentage  |\n"
								   + "| cant't be less than 0 (zero)!    |\n"							 
								   + "+----------------------------------+\n");
				scanReq = "currentChargePer";
				continue;
			} else if (charge15Min < 1) {
				System.out.println("\n+--------------ERROR!--------------+\n"
								   + "| The percentage your device can   |\n"
								   + "| charge upto in 15 min must be    |\n"
								   + "| greater than 0 (zero)!           |\n"
								   + "+----------------------------------+\n");
				scanReq = "charge15Min";
				continue;
			} 
			
			
			if (calcMode.equals("time")) {
				//Checks if the entered values are correct 
				if (chargePerReq < currentChargePer || chargePerReq > 100) {	
					
					if(chargePerReq > 100) {
						System.out.println("\n+--------------ERROR!--------------+\n"
										   + "| The charge percentage required   |\n"
										   + "| can't be greater than 100        |\n"
										   + "| (hundred)!                       |\n"
										   + "+----------------------------------+\n");
						scanReq = "chargePerReq";
						continue;
					}
										
					//Fixes the end String depending on the currentChargePer digit count
					String endStrFix;
					if (currentChargePer < 10) {					
						endStrFix = "      |\n";
					} else if (currentChargePer < 100) {					
						endStrFix = "     |\n";
					} else {					
						endStrFix = "    |\n";
					}
					
					System.out.println("\n+---------------ERROR!---------------+\n"
									   + "| The charge percentage you require  |\n"
	  				  				   + "| can't be less than the remaining   |\n"
	  				  				   + "| charge percentage which was " + currentChargePer + endStrFix
									   + "+------------------------------------+\n");
					scanReq = "chargePerReq";
					continue;
				} else if (offset < 0) {
					System.out.println("\n+--------------ERROR!--------------+\n"
									   + "| The offset value can't be less   |\n"
									   + "| than 0 (zero)!                   |\n"
									   + "+----------------------------------+\n");
					scanReq = "offset";
					continue;
				}
				
			} else if (calcMode.equals("percentage")) {
				//Checks if the hours, minutes, and seconds are correct
				if (hours < 0) {
					System.out.println("\n+--------------ERROR!--------------+\n"
									   + "| The hours value can't be less    |\n"
									   + "| than 0 (zero)!                   |\n"							 
									   + "+----------------------------------+\n");
					scanReq = "hours";
					continue;
				} else if (minutes < 0) {
					
					System.out.println("\n+--------------ERROR!--------------+\n"
									   + "| The minutes value can't be less  |\n"
									   + "| than 0 (zero) !                  |\n"									   							
									   + "+----------------------------------+\n");
					scanReq = "minutes";
					continue;
				} else if (seconds < 0) {
					System.out.println("\n+--------------ERROR!--------------+\n"
									   + "| The seconds value can't be less  |\n"
									   + "| than 0 (zero) !                  |\n"									   							
									   + "+----------------------------------+\n");
					scanReq = "seconds";
					continue;
				} 
			}								
			
			//This code calculates the time or percentage depending on the calcMode
			if (calcMode.equals("time")) {
				//Calculating the Total Time in Minutes 
				total = (( (float) (chargePerReq + offset) - currentChargePer) / charge15Min) * 15;								
				total = Float.parseFloat(String.format("%.2f", total));			
				
				//Converting the total time into hours, minutes, and seconds 
				hours = (int) total / 60;			
				minutes = (int) total - (hours * 60);			
				seconds = (int) ((total - (hours * 60) - minutes) * 60);								
				System.out.println("The Approximate time required to charge the device is: " 
						    	   + hours + ":" + minutes + "'" + seconds + "\"");							
			} else if (calcMode.equals("percentage")) {																
				//Converts time in minutes to percentage 
				time = (hours * 60) + minutes + (seconds / 60.0f);						
				time = ((time / 15.0f) * charge15Min) + currentChargePer;	
				time = Float.parseFloat(String.format("%.2f", time));
				System.out.println("The Approximate percentage your device will be charged upto is: " + time + "%");
				System.out.print("If you want to add negative offset, then add it in percentage: ");					
				negOffset = (byte) Math.abs(scan.nextByte());				
				time -= negOffset;				
				System.out.println("The Approximate percentage your device will be charged upto, after negative offset is: " + time + "%");				
			}
			
			
			//Checks if you want to continue the program
			System.out.println("------------------------------------");
			while (true) {
				System.out.print("Do you wish to continue [y or n]: ");							
				char repeat = scan.next().charAt(0);			
				if (repeat == 'y' || repeat == 'Y') {	
					System.out.print("\n");					
					calcMode = "";
					scanReq = "";		
					scan.nextLine();
					break;
				} else if (repeat == 'n' || repeat == 'N') {
					System.out.println("The program has been terminated!");
					scan.close();
					System.exit(0);
				} else {
					System.out.println("\n+-------------WARNING!-------------+\n"
									   + "| Please enter the given keyword!  |\n"
									   + "+----------------------------------+\n");
				}
			}
		}
	}
}