# Assignment1
FIRST README
The original package was called Binary Tree, i changed this to DAG and it uploaded as a 
new file, rather than updating my existing one. 

I want to build on my first assignment, but to help me distinguish between them I will be
using strings as keys rather than integers.

I will need a way to keep track of the parents, if i need to keep adding parents an
arraylist is the best way to do this. 
I will do a very simple version of LCA taking help from other students in my course, 
and will add new tests and new code when i see areas where errors could occur.
Obvious areas would include 
1)null nodes
2)non existing nodes
3)the node not being acyclic, could end up in an infinite loop trying to find a node.

SECONDREADME
I had planned on starting with findLCA, then finding where errors could occur and 
creating new methods to fix this. It seems in order to implement find LCA in the first
place i will need to create a methid that stores all ancestors of a particular node.
Then, i can look throught this arraylist, finding where the first time the two nodes have
the same ancestor.
