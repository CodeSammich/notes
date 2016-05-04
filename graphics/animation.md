# Animation

Move ball from one side to other side

w/o animation: translate ball

Frame

0   move 400 0 0   0%
1   move 400 0 0   25%
2   move 400 0 0   50%
3   move 400 0 0   75%
4   move 400 0 0   100%

vary factor 0 4   0 1

vary factor <start/end frame> <start/end values>

### New MDL Commands
- frames <N>
 - Set the # of frames in the animation
- basename <S>
 - Set the prefix for all frame filenames
- vary <KNOB> <F0> <F1> <V0> <V1>
 - Describes how the knob changes over time

### Pass I
- Look for and verify the animation commands
    frames, basename, vary
- If there are any errors, print out error message and exit

- If it's okay:
- Set the number of frames (global frames number)
- Set the basename
  - If basename is not in mdl file, set a default one and alert the user

### Pass II
Generate and store the  knob values for each frame
Only cmd we care about in Pass II is *vary*
*Create an arary/list where each index presents a frame and stores a list of knob values for that frame*

*example*
	vary  k  10  0  0  1
	vary  x  3   6  1  0
	
vary <frames start/end inclusive> <values start/end inclusive>

frame 
0 -> k: 0   -> x: 1
1 -> k: .1  -> x: 1
2 -> k: .2  -> x: 1
3 -> k: .3  -> x: 1
  .         -> x: .66
  .              .
  .              .
9 -> k: .9       .
10 -> k: 1     x: 0

### Pass III
*Drawing phase*

If there's no animation code, you draw image normally
Set frame = 1

If there is animation code, for each frame:
  1. Set the symbol table values for each knob based on the array from Pass II
  2. Go through the drawing commands and apply the knobs as needed
  3. Save the image as basename + frame #
