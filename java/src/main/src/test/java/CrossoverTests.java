import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Gebruiker on 12/9/2017.
 */
public class CrossoverTests {

    public static void main(String args []) {
        int[] elements = new int[7];
        int[] sorted = new int[elements.length];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i< elements.length; i++) {
            String binaryString = Integer.toBinaryString(elements[i]);
            int count = binaryString.length() - binaryString.replace("1", "").length();
            System.out.println(count);
            sorted[i] = count;
            map.put(elements[i], count);
        }

        Object[] a = map.entrySet().toArray();
        Arrays.sort(a, (o1, o2) -> ((Map.Entry<String, Integer>) o2).getValue()
                .compareTo(((Map.Entry<String, Integer>) o1).getValue()));

        int s = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            sorted[s] = entry.getKey();
        }

    }

    /**
     * Complete the function below.
     * DO NOT MODIFY anything outside this method.
     */
    static void balancedOrNot(String[] expressions, int[] maxReplacements)
    {


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
