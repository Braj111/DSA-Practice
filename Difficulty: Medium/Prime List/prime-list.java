//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class Node {
    Node next;
    int val;

    public Node(int data) {
        val = data;
        next = null;
    }
}

class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t;
        t = Integer.parseInt(in.readLine());
        while (t-- > 0) {

            Node head, tail;
            String s[] = in.readLine().trim().split(" ");
            int num = Integer.parseInt(s[0]);
            head = new Node(num);
            tail = head;
            for (int i = 1; i < s.length; i++) {
                num = Integer.parseInt(s[i]);
                tail.next = new Node(num);
                tail = tail.next;
            }
            Solution ob = new Solution();
            Node temp = ob.primeList(head);
            while (temp != null) {
                out.print(temp.val + " ");
                temp = temp.next;
            }
            out.println();
            out.println("~");
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java
/*
class Node{
    Node next;
    int val;
    public Node(int data){
        val=data;
        next=null;
    }
}
*/

class Solution {
    static List<Integer> findPrimes(int n) {
        List<Integer> primes = new ArrayList<>
        (Collections.nCopies(n + 1, 1));
        primes.set(0, 0);
        primes.set(1, 0);
        for (int i = 2; i * i <= n; i++) {
            if (primes.get(i) == 1) {
                for (int j = i * i; j <= n; j += i) {
                    primes.set(j, 0);
                }
            }
        }
        return primes;
    }

    static Node primeList(Node head) {
        int maxNum = 0;
        Node temp = head;
        while (temp != null) {
            maxNum = Math.max(maxNum, temp.val);
            temp = temp.next;
        }

        List<Integer> primes = findPrimes(2 * maxNum);
        
        temp = head;
        while (temp != null) {
            int num = temp.val;
            
            if (num == 1) {
                temp.val = 2;
            } else {
                int num1 = num, num2 = num;
                while (primes.get(num1) == 0) {
                    num1--;
                }
                while (primes.get(num2) == 0) {
                    num2++;
                }
                
                if (num - num1 > num2 - num) {
                    temp.val = num2;
                } else {
                    temp.val = num1;
                }
            }
            
            temp = temp.next;
        }
        
        return head;
    }
}