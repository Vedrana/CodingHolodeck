package basics;

import java.io.*;
import java.util.*;

public class _Salabahter {

    private class Comp implements Comparable<Comp> {

        @Override
        public int compareTo(Comp o) {
            // TODO Auto-generated method stub
            return 0;
        }

    }

    private class Iter implements Iterable<Comp> {

        private List<Comp> c;

        @Override
        public Iterator<Comp> iterator() {
            Iterator<Comp> iComp = c.iterator();
            return iComp;
        }

        // for (Comp c : iter)
    }

    public static void main(String[] args) throws IOException {
        // String methods
        String s = "blabla";

        int length = s.length();

        String subStr = s.substring(1);
        String subStr2 = s.substring(1, 3);

        Character firstChar = s.charAt(0);
        String firstCharAsString = firstChar.toString();

        int lastIndex = s.lastIndexOf(firstChar);
        lastIndex = s.lastIndexOf("b");

        // arrays
        int[] intArr = new int[]{1, 2, 3};
        int arrLength = intArr.length;

        int[] intArr2 = new int[3];
        Arrays.fill(intArr2, 1); // set all values od intArr to 1

        List<Integer> intList = new ArrayList<Integer>();
        List<Integer> intList2 = new ArrayList<Integer>(Arrays.asList(9, 7, 5, 3, 1, 2, 4, 6, 8));
        Collections.sort(intList);

        // random
        Random random = new Random();
        random.nextBoolean();
        random.nextInt(5); // between 0 and 4!

        // Queue
        Queue<Integer> q = new PriorityQueue<Integer>();
        q.add(2);
        q.peek(); // Retrieves and removes the head, null if emtpy
        q.poll(); // Retrieves and removes the head, null if empty
        q.remove(3);
        q.size();

        // Stack
        Stack<Integer> stack = new Stack<Integer>();
        stack.peek();
        stack.push(3);
        stack.pop();

        // map
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("key", 3);
        map.get("key");
        map.containsKey("key");
        map.containsValue(3);
        map.isEmpty();
        map.keySet();
        map.remove("key");

        // read file line by line
        String filename = "blabla.txt";
        FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> lines = new ArrayList<String>();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line);
        }
        bufferedReader.close();
        String[] linesArray = lines.toArray(new String[lines.size()]);

        // write to file
        FileWriter fstream = new FileWriter(filename, true);
        BufferedWriter out = new BufferedWriter(fstream);
        out.write("this is a string");
        out.newLine();
        //Close the output stream
        out.close();
        
        
        /*
         Put very simply, there are two methods that a class needs to override to make objects of that class work as hash map keys:
			public int hashCode();
			public boolean equals(Object o);
        */

        int first = 123;
        System.out.println(Integer.toBinaryString(first));

    }

}
