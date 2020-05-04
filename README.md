Assumptions and remarks:

In the case of absence of any words (only white space, tabs, etc.) I return "[] of length 0".
My code is able to handle multiple tabs and spaces.
My code treats every contiguous sequence of characters excluding "." , "," , "!", "?" as a word.
A sentence of the sort "My favorite number is 8" will therefore result in a shortest word: "8" with a length of 1.
Due to the removePunctuation() function we are able to correctly evaluate the sentence: "This tests punctuation, huh?".
Notice that if we don't take into consideration punctuation then huh? would be a word of length 4 and punctuation, would be of length 12,
resulting in a wrong answer.
In case of ties, my code takes the first shortest/longest word in the sentence.

Instructions:
I have tried to keep this as simple as possible (no external dependencies), hence the use of my own assertEquals function.

All one has to do is:
javac Solution.java /
java Solution

Time spent: around 35 minutes.
