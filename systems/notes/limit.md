####SOTD: Sell Out - Reel Big Fish

#Aim: Let's take this to delimit!

###strsep - `<string.h>`

- Used for parsing a string with a common delimeter
 - `strsep( <SOURCE>, <DELIMETER>)`
  - Locates the first occurence of the delimeter in a string and replaces that character with NULL

- returns the beginning of the original string sets the source string to the string starting at 1 index past the location of the new NULL

- Since the source variable's value is changed, it must be a pointer to a string.

 - `char line[100] = "wow-this-is-cool";`
 - `

