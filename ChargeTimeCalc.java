/**
 * Author: Akshay Karunakar Naik 
 * Date: 27-02-2024
 */

package ChargeTimeCalculator;
import java.util.Scanner;

public class ChargeTimeCalc {			
	public static void main(String[] args) {						
		Scanner scan = new Scanner(System.in);
		byte currentChargePer, charge15Min, chargePerReq, offset;
		currentChargePer = charge15Min = chargePerReq = offset = 0;
		int hours, minutes, seconds;		
		hours = minutes = seconds = 0;
		float total = 0.0f;
		String scanReq = "";
				
		while (true) {
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
				default:
					System.out.print("Enter the remaining charge percentage: ");
					currentChargePer = scan.nextByte();
					System.out.print("Enter the percentage your device can charge upto in 15 min: ");
					charge15Min = scan.nextByte();
					System.out.print("Enter the maximum charge percentage you require: ");
					chargePerReq = scan.nextByte();	
					System.out.print("Enter the offset percentage: ");
					offset = scan.nextByte();										
			}
								
			//Checks if the entered values are correct 
			if (currentChargePer < 1) {
				System.out.println("+--------------ERROR!--------------+");
				System.out.println("| The remaining charge percentage  |\n"
								 + "| cant't be less than 1 (one)!     |");								 
				System.out.println("+----------------------------------+");
				scanReq = "currentChargePer";
				continue;
			} else if (charge15Min < 1) {
				System.out.println("+--------------ERROR!--------------+");
				System.out.println("| The percentage your device can   |\n"
								 + "| charge upto in 15 min must be    |\n"
								 + "| greater than 0 (zero)!           |");
				System.out.println("+----------------------------------+");
				scanReq = "charge15Min";
				continue;
			} else if (chargePerReq < currentChargePer) {
				System.out.println("+---------------ERROR!---------------+");								
				
				//Fixes the end String depending on the currentChargePer digit count
				String endStrFix;
				if (currentChargePer < 10) {					
					endStrFix = "      |";
				} else if (currentChargePer < 100) {					
					endStrFix = "     |";
				} else {					
					endStrFix = "    |";
				}
				
				System.out.println("| The charge percentage you require  |\n"
  				  				   + "| can't be less than the remaining   |\n"
  				  				   + "| charge percentage which was " + currentChargePer + endStrFix);
				System.out.println("+------------------------------------+");
				scanReq = "chargePerReq";
				continue;
			} else if (offset < 0) {
				System.out.println("+--------------ERROR!--------------+");
				System.out.println("| The offset value can't be less   |\n"
								 + "| than 0 (zero)!                   |");
				System.out.println("+----------------------------------+");
				scanReq = "offset";
				continue;
			}
			
			//Calculating the Total Time in Minutes 
			total = (( (float) (chargePerReq + offset) - currentChargePer) / charge15Min) * 15;								
			total = Float.parseFloat(String.format("%.2f", total));			
			
			//Converting the total time into hours, minutes, and seconds 
			hours = (int) total / 60;			
			minutes = (int) total - (hours * 60);			
			seconds = (int) ((total - (hours * 60) - minutes) * 60);								
			System.out.println("The Approximate time required to charge the device is: " 
								+ hours + ":" + minutes + "'" + seconds + "''");
						
			//Checks if you want to continue the program
			System.out.println("----------------------------------");
			System.out.print("Do you wish to continue [y or n]: ");							
			char repeat = scan.next().charAt(0);			
			if (repeat == 'y' || repeat == 'Y') {	
				scanReq = "";					
				continue;
			} else if (repeat == 'n' || repeat == 'N') {
				System.out.println("The program has been terminated!");
				scan.close();
				break;
			} 
		}
	}
}