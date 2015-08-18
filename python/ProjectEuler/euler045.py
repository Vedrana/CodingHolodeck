from collections import defaultdict

def triangleNumbers():
  n = 286
  while True:
    yield n * (n + 1) / 2
    n += 1

def pentagonalNumbers():
  n = 165
  while True:
    yield n * (3*n - 1) / 2
    n += 1
    
def hexagonalNumbers():
  n = 143
  while True:
    yield n * (2*n - 1)
    n += 1

def main():
  pentagonal = pentagonalNumbers()
  penta = pentagonal.next()
  
  hexagonal = hexagonalNumbers()
  hexa = hexagonal.next()
  
  numbers = defaultdict(int)
  numbers[penta] += 1
  numbers[hexa] += 1
  for triang in triangleNumbers():
    numbers[triang] += 1
    while penta <= triang:
      penta = pentagonal.next()
      numbers[penta] += 1
    while hexa <= triang:
      hexa = hexagonal.next()
      numbers[hexa] += 1
      if numbers[triang] == 3:
        print triang
        return

if __name__ == '__main__':
  main()

