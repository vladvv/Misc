


#include <stdio.h>
#include <string.h>

void reverse(char *str)
{
	char *end = str;
	
	while(*end)
	{
		end++;
	}
	end--;
	
	while(end > str)
	{
		char temp = *str;
		*str = *end;
		*end = temp;
		printf("Swapping %c with %c \n---\n", *str, *end);
		end--;
		str++;
		
	}
}


main()
{
	char test[] = "abd";
	reverse(test);
	printf("%s", test);
}
