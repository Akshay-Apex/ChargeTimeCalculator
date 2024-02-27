# -*- coding: utf-8 -*-
"""
Created on Tue Feb  7 11:59:10 2023

@author: Akshay
"""
def charge_time_calc():
    loop_back = 1
    while True:
        if loop_back == 1:
            charge = int(input("Enter the Current Percentage of charge: "))  
            charge_15 = int(input("Enter the percentage the device can charge up to in 15 min: "))   
            charge_limit = int(input("Enter the maximum charge percentage you require: ")) 
            offset = int(input("Enter the OFFSET in percentage: "))
            loop_back = 0
        if charge < 0:   
            print("--------------------------------")
            print("   +                        +   ")
            print("   |         ERROR          |   ")
            print("   | The Charge Percentage  |   ")
            print("   | can't be less than 0!  |   ")
            print("   +                        +   ")
            print("--------------------------------")
            charge = int(input("Enter the Current Percentage of charge: "))  
            continue
        if charge_15 < 1:
            print("--------------------------------")
            print("   +                        +   ")
            print("   |         ERROR          |   ")
            print("   | The Percentage charged |   ")
            print("   | in 15 minutes must be  |   ")
            print("   | greater than 0!        |   ")
            print("   +                        +   ")
            print("--------------------------------")
            charge_15 = int(input("Enter the percentage the device can charge up to in 15 min: "))  
            continue
        if charge_limit < charge:
            print("--------------------------------")
            print("   +                        +   ")
            print("   |         ERROR          |   ")
            print("   | The maximum charge     |   ")
            print("   | Percentage you require |   ")
            print("   | must be greater than or|   ")
            print("   | equal to the current   |   ")
            print("   | charge Percentage!     |   ")
            print("   +                        +   ")
            print("--------------------------------")
            charge_limit = int(input("Enter the maximum charge percentage you require: "))  
            continue
        if offset < 0:
            print("--------------------------------")
            print("   +                        +   ")
            print("   |         ERROR          |   ")
            print("   | The OFFSET value can't |   ")
            print("   | be less than zero!     |   ")        
            print("   +                        +   ")
            print("--------------------------------")
            offset = int(input("Enter the OFFSET in percentage: "))
            continue
        else:  
            count = 0            
            charge_limit += offset            
                        
            while charge <= charge_limit:
                charge += charge_15
                count += 1
                 
            difference = 15 / charge_15 * (charge - charge_limit)
            max_time = (15 * count) - difference
            
            hours = int(max_time / 60)
            minutes = int(max_time - (hours * 60))
            seconds = int((max_time - (hours * 60 + minutes)) * 60)
                                                      
            if hours > 0:              
                print("The Average time required to charge the device is: {0}:{1}'{2}\"".format(hours, minutes, seconds)) 
            else:
                print("The Average time required to charge the device is: {0}'{1}\"".format(minutes, seconds))  
            
            while True:
                continuation = input("Do you wish to continue [y or n]: ") 
                if continuation == "Y" or continuation == "y":
                    loop_back = 1
                    print("--------------------------------")
                    break
                elif continuation == "N" or continuation == "n":
                    print("The program has ended!")
                    return 0                    
                else:
                    print("--------------------------------")
                    print("   +                        +   ")
                    print("   |        WARNING         |   ")
                    print("   | Please enter the given |   ")
                    print("   | keyword!               |   ")
                    print("   +                        +   ")
                    print("--------------------------------")   
            
charge_time_calc()                    