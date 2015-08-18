import euler

def main():
  sum = 0
  for i in euler.sieve(2000000):
    sum += i
  print sum


if __name__ == '__main__':
  main()

