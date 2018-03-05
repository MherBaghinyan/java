import java.net.Socket;
import java.util.*;
import java.util.function.ObjDoubleConsumer;

/**
 * Created by Gebruiker on 12/9/2017.
 */
public class CrossoverTests {

    public static void main(String args []) {

//        sortTest();

        String[] expressions = {"<>>>", "<>>>>"};

        int[] maxReplacements = {2, 2};

        balancedOrNot(expressions, maxReplacements);
    }

    /*
    Consider an array of n decimal integers named elements. We want to rearrange elements according to the following rules:

Sort the integers in ascending order by the number of 1's in their binary representations. For example, (7)10 → (111)2 and (8)10 → (1000)2, so 8 (which has one 1 in binary) would be ordered before 7 (which has three 1's in binary).

Two or more integers having the same number of 1's in their binary representations are ordered by increasing decimal value. For example, (5)10 → (101)2 and (6)10 → (110)2 both contain two 1's in their binary representation, so 5 would be ordered before 6 because it has the smaller decimal value.

Complete the rearrange function in the editor below. It has one parameter: an array of n integers, elements. The function must sort the elements array according to the rules above and return the sorted array.

Input Format

The internal test cases read the following input from stdin and passes it to the function:

The first line contains an integer, n, denoting the number of integers in elements.

Each line i of the n subsequent lines (where 0 ≤ i < n) contains an integer describing elementsi.

Constraints

1 ≤ n ≤ 10^5

1 ≤ elementsi ≤ 10^9

Output Format

Return an array of n integers denoting the sorted elements.

Sample Input 0

3
1
2
3


Sample Output 0

1
2
3


Explanation 0

Given elements = [1, 2, 3]:

(1)10 → (1)2

(2)10 → (10)2

(3)10 → (11)2

The decimal integers 1 and 2 both have one 1 in their binary representation, so we order them by increasing decimal value (i.e., 1 < 2). The decimal integer 3 has two 1's in its binary representation, so we order it after 1 and 2. We then return elements = [1, 2, 3] as our sorted array.

Sample Input 1

5
5
3
7
10
14


Sample Output 1

3
5
10
7
14


Explanation 1

Given elements = [1, 2, 3]:

(5)10 → (101)2

(3)10 → (11)2

(7)10 → (111)2

(10)10 → (1010)2

(14)10 → (1110)2

The decimal integers 5, 3, and 10 have two 1's in their binary representations, so we order them by increasing decimal value (i.e., 3 < 5 < 10). The decimal integers 7 and 14 have three 1's in their binary representations, so we place them after 3, 5, and 10 in increasing decimal order (i.e., 7 < 14). We then return elements = [3, 5, 10, 7, 14] as our sorted array.
For example:

Input	Result
3
1
2
3
1
2
3

     */
    private static void sortTest() {

        int[] elements = {3,
                1,
                2,
                3};

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i< elements.length; i++) {
            String binaryString = Integer.toBinaryString(elements[i]);
            int count = binaryString.length() - binaryString.replace("1",
                    "").length();
            map.put(elements[i], count);
        }

        class ValueComparator implements Comparator<Integer>{

            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

            public ValueComparator(HashMap<Integer, Integer> map){
                this.map.putAll(map);
            }

            @Override
            public int compare(Integer s1, Integer s2) {
                if(map.get(s1) >= map.get(s2)){
                    return 1;
                }else{
                    return -1;
                }
            }
        }

        Comparator<Integer> comparator = new ValueComparator(map);

        TreeMap<Integer, Integer> result = new TreeMap<Integer, Integer> (comparator);
        result.putAll(map);

        int s = 0;
        int[] sorted = new int[result.entrySet().size()];

        for (Map.Entry<Integer, Integer> entry : result.entrySet())
        {
            sorted[s++] = entry.getKey();
        }

        System.out.println(sorted);
    }


    /**
     * Complete the function below.
     * DO NOT MODIFY anything outside this method.
     */
    private static void balancedOrNot(String[] expressions, int[] maxReplacements)
    {
        int[] balancedArray = new int[maxReplacements.length];

        for (int i = 0; i < expressions.length; i++) {

            String expression = expressions[i];

            while (expression.contains("<>")) {
                expression = expression.replace("<>", "");
            }

            if (expression.length() > maxReplacements[i]) {
                balancedArray[i] = 0;
            } else {
                balancedArray[i] = 1;
            }
        }

        System.out.println(Arrays.toString(balancedArray));

    }


    /*
    Consider a string, expression consisting of the characters < and > only. We consider the string to be balanced if each < always appears before (i.e., to the left of) a corresponding > character (they do not need to be adjacent). Moreover, each < and > act as a unique pair of symbols and neither symbol can be considered as part of any other pair of symbols. For example, the strings <<>>, <>, and <><> are all balanced, but the strings >>, <<>, and ><>< are unbalanced.

To balance a string, we can replace any > character with <> at most maxReplacement times. Given an expression and the value of maxReplacement, can you turn an unbalanced string into a balanced one?

Complete the balancedOrNot function in the editor below. It has the following parameters:

An array of n strings, expressions, denoting the list of expressions to check.
An array of n integers, maxReplacements, where maxReplacementsi denotes the maximum number of replacements allowed when attempting to balance expressionsi.
The function must return an array of integers where each index i (0 ≤ i < n) contains a 1 if expressionsi is balanced or a 0 if it is not.

Input Format

A set of internal unit tests will be on the code with input in the following format.

The first line contains an integer, n, denoting the size of expressions.

Each line i of the n subsequent lines (where 0 ≤ i < n) contains a string describing expressionsi.

The next line contains an integer, m, denoting the size of maxReplacements.

Each line i of the n subsequent lines (where 0 ≤ i < n) contains a string describing maxReplacementsi.

Constraints

1 ≤ n ≤ 10^2
1 ≤ length of expressionsi ≤ 10^5
0 ≤ maxReplacementsi ≤ 10^5
Output Format

The function must return an array of integers where each index i (0 ≤ i < n) contains a 1 if expressionsi is balanced or a 0 if it is not.

Observations

Check that your code runs before submitting it!
Sample Input 0

2
<>>>
<>>>>
2
2
2
Sample Output 0

1
0
Explanation 0

We process expressions = ["<>>>", "<>>>>"] and maxReplacements = [2, 2] like so:

For string <>>> with maxReplacements0 = 2, it becomes balanced after two replacements: <>>> → <><>> → <><><>. Because the string was converted in ≤ maxReplacements0 replacements, we store a 1 in index 0 of our return array.
For string <>>>> with maxReplacements1 = 2, becomes balanced after three replacements: <>>>> → <><>>> → <><><>> → <><><><>. Because the string was converted in > maxReplacements1replacements, we store a 0 in index 1 of our return array.
We then return the array [1, 0] as our answer.

Sample Input 1

2
<>
<>><
2
1
0
Sample Output 1

1
0
Explanation 1

We process expressions = ["<>", "<>><"] and maxReplacements = [1, 0] like so:

For string <> with maxReplacements0 = 1, it is already balanced and needs no replacements. Because the string is balanced in ≤ maxReplacements0 replacements, we store a 1 in index 0 of our return array.
For string <>>< with maxReplacements1 = 0, the string is not balanced. It's impossible to balance the string because it ends in < (and we're also restricted to performing 0 replacements), so we store a 0 in index 1 of our return array.
We then return the array [1, 0] as our answer.

For example:

Input	Result
2
<>>>
<>>>>
2
2
2
1
0
     */

}
