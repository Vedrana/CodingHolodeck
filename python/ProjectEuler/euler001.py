def isMultiple(x):
  return x % 3 == 0 or x % 5 == 0

def add(x, y):
  return x + y

def main():
  print reduce(add, filter(isMultiple, range(1, 1000)))

if __name__ == '__main__':
  main()
