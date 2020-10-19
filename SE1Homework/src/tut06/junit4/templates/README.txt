Test case driver templates:
==============================================

- Template 1 is the most basic design (similar to the one shown in the lecture) 
- Templates 2 & 4 are similar except for where the actual initialisations of the test cases
and expected results are performed
- Template 3 is a bit more complex, useful if the test cases and results are to be reused
among several test methods.

- All four templates use a new tag named @testcases to annotate the design specification 
for the test cases. 

The location of this tag, however, differs between the templates, depending on where
the initialisation is performed.