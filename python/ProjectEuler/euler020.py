from math import factorial

def main():
  print reduce(lambda x, y: x+y, [int(i) for i in str(factorial(100))])

if __name__ == '__main__':
  main()

