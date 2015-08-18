package basics.datastruct;

import java.util.LinkedList;

public class Hashtable {

  private Bucket[] hashTable;

  public Hashtable(int arrayLenght) {
    hashTable = new Bucket[arrayLenght];
  }

  private int hash(String s) {
    int h = s.length();
    for (Character c : s.toCharArray()) {
      h ^= c;
    }
    return h;
  }

  public void put(String key, Object entry) {
    int index = hash(key) % hashTable.length;
    if (hashTable[index] == null) {
      hashTable[index] = new Bucket();
    }
    for (Item item : hashTable[index].getItems()) {
      if (item.getKey() == key) {
        item.setEntry(entry);
        return;
      }
    }
    hashTable[index].getItems().push(new Item(key, entry));
  }

  public Object get(String key) {
    int index = hash(key) % hashTable.length;
    if (hashTable[index] != null) {
      for (Item item : hashTable[index].getItems()) {
        if (item.getKey() == key) {
          return item.getEntry();
        }
      }
    }
    return null;
  }

  private class Item {

    private String key;
    private Object entry;

    public Item(String key, Object entry) {
      this.key = key;
      this.entry = entry;
    }

    public String getKey() {
      return key;
    }

    public Object getEntry() {
      return entry;
    }

    public void setEntry(Object entry) {
      this.entry = entry;
    }
  }

  private class Bucket {
    private LinkedList<Item> items;

    public Bucket() {
      items = new LinkedList<Item>();
    }

    public LinkedList<Item> getItems() { // Just list
      return items;
    }
  }

  public static void main(String[] args) {
    Hashtable h = new Hashtable(3);
    h.put("1", "jedan");
    h.put("2", "dva");
    h.put("3", "three");
    h.put("4", "four");
    h.put("5", "five");

    System.out.println(h.get("3"));
    System.out.println(h.get("1"));
    System.out.println(h.get("5"));
  }
}


