/*
    Project: Charge_Time_Calculator
    Date: 25-02-2023
    @author: Akshay
*/

#include <stdio.h>

int main() {
    int loop_back = 1;
    while (loop_back == 1) {
        int charge, charge_15, charge_limit, offset, inner_loop_back, prompt_number;
        inner_loop_back = 1;
        prompt_number = 0;

        printf("Enter the current charge percentage: ");
        scanf("%d", &charge);

        printf("Enter the maximum percentage the device can charge up to in 15 min: ");
        scanf("%d", &charge_15);

        printf("The maximum charge you require: ");
        scanf("%d", &charge_limit);

        printf("Enter the OFFSET in percentage: ");
        scanf("%d", &offset);

        while (inner_loop_back == 1) {
            switch (prompt_number) {
                case 1:
                    printf("Enter the current charge percentage: ");
                    scanf("%d", &charge);
                    break;

                case 2:
                    printf("Enter the maximum percentage the device can charge up to in 15 min: ");
                    scanf("%d", &charge_15);
                    break;

                case 3:
                    printf("The maximum charge you require: ");
                    scanf("%d", &charge_limit);
                    break;

                case 4:
                    printf("Enter the OFFSET in percentage: ");
                    scanf("%d", &offset);
                    break;
            }

            if (charge < 0) {
                printf("--------------ERROR--------------\n");
                printf("The Charge Percentage can't be \nless than zero!\n");
                printf("---------------------------------\n");
                prompt_number = 1;
                continue;
            } else if (charge_15 <= 0) {
                printf("--------------ERROR--------------\n");
                printf("Maximum Percentage the device can \ncharge up to in 15 min can't be \nless than or equal to zero!\n");
                printf("---------------------------------\n");
                prompt_number = 2;
                continue;
            } else if (charge_limit < charge) {
                printf("--------------ERROR--------------\n");
                printf("The Maximum charge you require \ncan't be less than the current \npercentage!\n");
                printf("---------------------------------\n");
                prompt_number = 3;
                continue;
            } else if (offset < 0) {
                printf("--------------ERROR--------------\n");
                printf("The OFFSET value can't be less \nthan zero!\n");
                printf("---------------------------------\n");
                prompt_number = 4;
                continue;
            }

            inner_loop_back = 0;
        }

        //OFFSET is used to counter the increase in the battery's internal resistance as the voltage increases
        charge_limit += offset;

        int count = 0;
        while (charge < charge_limit) {
            charge += charge_15;
            count ++;
        }

        float difference, max_time;
        //This will store the difference of time in minutes
        difference = (float) 15 / charge_15 * (charge - charge_limit);

        //This will store the time in minutes
        max_time = (float) (15 * count) - difference;

        int hours, minutes, seconds;
        hours = max_time / 60;
        minutes = max_time - (hours * 60);
        seconds = (max_time - (hours * 60 + minutes)) * 60;

        if (hours > 0) {
            printf("The Average time required to charge the device is: %d:%d'%d\"\n", hours, minutes, seconds);
        } else {
            printf("The Average time required to charge the device is: %d'%d\"\n", minutes, seconds);
        }

        char flag;
        while (1) {
            printf("Do you wish to continue the program [y, n]: ");
            scanf(" %c", &flag);
            if (flag == 'Y' || flag == 'y') {
                loop_back = 1;
                printf("---------------------------------\n");
                break;
            } else if (flag == 'N' || flag == 'n') {
                loop_back = 0;
                printf("The Program has ended!");
                break;
            } else {
                printf("-------------WARNING-------------\n");
                printf("Please enter the given keyword!\n");
                printf("---------------------------------\n");
            }
        }
    }
    return 0;
}
