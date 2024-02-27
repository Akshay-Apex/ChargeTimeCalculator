# -*- coding: utf-8 -*-
"""
Created on Tue Feb  7 11:59:10 2023

@author: Akshay
"""

charge = int(input("Enter the Current Percentage of charge: "))  
charge_15 = int(input("Enter the percentage the device can charge up to in 15 min: "))   
charge_limit = int(input("Enter the maximum charge percentage you require: ")) 
offset = int(input("Enter the OFFSET in percentage: "))
loop_back = 0  

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
        charge = int(input("Enter the remaining charge percentage: ")) 
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
        print("   | must be greater or     |   ")
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
        print("   | be less than zero      |   ")        
        print("   +                        +   ")
        print("--------------------------------")
        offset = int(input("Enter the OFFSET in percentage: "))
        continue
    else:  
        count = 0
        max_time = 0 
        charge_limit += offset
        charge_copy = charge 
        
        #This will calculate the number of times 15 occurs and counts it
        while charge <= charge_limit:
            charge += charge_15
            count += 1
  
        difference = charge - charge_limit
        max_time = (15 * count) - ((15 * count) / (charge - charge_copy)) * difference  #This will calculate the maximum time required to charge the device in minutes
        seconds = ((max_time % 1 * 100) / 100 * 60) // 1   #This calculates the seconds from max_time
        minutes = max_time % 60   #This calculates the minutes from max_time
        
        if max_time >= 60:   #This will convert the time into hours
            hours = max_time // 60
            print("The Average time required to charge the device is: {0}:{1}'{2}\"".format(int(hours), int(minutes), int(seconds))) 
        else:
            print("The Average time required to charge the device is: {0}'{1}\"".format(int(minutes), int(seconds)))  
        
        while True:
            continuation = input("Do you wish to continue [y or n]: ")   #This will ask weather to continue the program or not 
            if continuation == "Y" or continuation == "y":
                flag = True
                break
            elif continuation == "N" or continuation =="n":
                flag = False
                break
            else:
                print("Please Enter the given keyword")

        if flag == True:
            loop_back = 1
        elif flag == False:
            print("The program has ended!")
            break                      